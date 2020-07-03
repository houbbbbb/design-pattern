package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : hbw
 * @desctiption : 为请求建一个队列，哪个请求过来就加入到队列中，如果没有请求过来就处理队列中的请求
 * @date : 2020-07-03 16:24
 */
public class ChannelDemo2 {
    static class ChannelServer {
        public static void main(String[] args) {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.bind(new InetSocketAddress(8899));

                List<SocketChannel> scl = new ArrayList<>();
                while (true) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (null != socketChannel) {
                        socketChannel.configureBlocking(false);
                        scl.add(socketChannel);
                    } else {
                        Iterator<SocketChannel> it = scl.iterator();
                        if (it.hasNext()) {
                            SocketChannel sc = it.next();
                            it.remove();

                            String rd = rd(sc);

                            System.out.println("获取到的请求为：" + rd);

                            String wt = "响应给客户端 - " + rd;

                            wt(sc, wt);
                        }
                    }
                }
            } catch (Exception e) {e.printStackTrace();}
        }
    }

    static class ChannelClient {
        public static void main(String[] args) {
            try {
                SocketChannel sc = SocketChannel.open();
                sc.configureBlocking(false);
                sc.connect(new InetSocketAddress("127.0.0.1", 9999));

                while (!sc.finishConnect()) {Thread.yield();}

                String wt = "客户端";

                wt(sc, wt);

                String rd = rd(sc);

                System.out.println("服务端的返回：" + rd);

            } catch (Exception e) {e.printStackTrace();}
        }
    }

    public static void wt(SocketChannel sc, String wt) throws IOException {
        ByteBuffer wb = ByteBuffer.wrap(wt.getBytes());
        while (wb.hasRemaining()) {
            sc.write(wb);
        }
    }

    public static String rd(SocketChannel sc) throws IOException {
        ByteBuffer rb = ByteBuffer.allocate(1024);
        while (true) {
            if (sc.isOpen() && sc.read(rb) != -1 && rb.position() > 0) break;
        }
        rb.flip();
        byte[] rby = new byte[rb.limit()];
        rb.get(rby);
        return new String(rby);
    }
}
