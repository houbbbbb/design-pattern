package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author : hbw
 * @desctiption :
 * 这种方式获取连接时用的循环，读取数据时用的循环，写入数据时用的循环，
 * 唯一的好处是哪个请求先过来就先处理哪个，但是处理的过程是阻塞的
 * @date : 2020-07-03 10:03
 */
public class ChannelDemo1 {
    static class ChannelServer {
        public static void main(String[] args) {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(new InetSocketAddress(8898));
                System.out.println("启动成功");
                while (true) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (null != socketChannel) {
                        socketChannel.configureBlocking(false);
                        System.out.println("本机地址：" + socketChannel.getLocalAddress());
                        System.out.println("请求地址：" + socketChannel.getRemoteAddress());

                        String req = read(socketChannel);

                        System.out.println("请求的内容：" + req);

                        String resp = "服务器已收到" + req;
                        write(socketChannel, resp);
                    }
                }
            } catch (Exception e) {e.printStackTrace();}
        }
    }

    static class ChannelClient {
        public static void main(String[] args) {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                socketChannel.socket().bind(new InetSocketAddress(8899));
                socketChannel.connect(new InetSocketAddress("127.0.0.1", 8898));
                while (!socketChannel.finishConnect()) {
                    Thread.yield();
                }

                String req = "客户端的请求";

                System.out.println("请求内容为：" + req);

                write(socketChannel, req);

                String resp = read(socketChannel);

                System.out.println("响应结果为：" + resp);

            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    private static void write(SocketChannel socketChannel, String str) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(str.getBytes());
        while (writeBuffer.hasRemaining()) {
            socketChannel.write(writeBuffer);
        }
    }

    private static String read(SocketChannel socketChannel) throws IOException {
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        while (true) {
            if (socketChannel.isOpen() && socketChannel.read(readBuffer) != -1 && readBuffer.position() > 0) break;
        }
        readBuffer.flip();
        byte[] readBytes = new byte[readBuffer.limit()];
        System.out.println("readByte::length " + readBytes.length);
        System.out.println("readBuffer::limit " + readBuffer.limit());
        readBuffer.get(readBytes);
        return new String(readBytes);
    }
}

