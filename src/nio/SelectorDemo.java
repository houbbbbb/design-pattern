package nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : hbw
 * @desctiption :
 * @date : 2020-07-03 10:02
 */
public class SelectorDemo {
    static class ChannelServer {
        public static void main(String[] args) {
            try {
                ServerSocketChannel ssc = ServerSocketChannel.open();
                ssc.configureBlocking(false);
                ssc.socket().bind(new InetSocketAddress(9999));
                Selector slt = Selector.open();
                ssc.register(slt, SelectionKey.OP_ACCEPT, ssc);
                System.out.println("启动成功：" + 9999);
                while (true) {
                    slt.select();
//                    slt.selectNow();
                    Set<SelectionKey> slks = slt.selectedKeys();
                    Iterator<SelectionKey> it = slks.iterator();
                    while (it.hasNext()) {
                        SelectionKey slku = it.next();
                        it.remove();

                        if (slku.isAcceptable()) {
                            ServerSocketChannel sscu = (ServerSocketChannel) slku.attachment();
                            SocketChannel sc = sscu.accept();
                            sc.configureBlocking(false);
                            sc.register(slt, SelectionKey.OP_READ, sc);
                        } else if (slku.isReadable()) {
                            try {
                                SocketChannel sc = (SocketChannel) slku.attachment();
                                String rd = ChannelDemo2.rd(sc);
                                System.out.println("接收到的请求：" + rd);
                                String wt = "来自服务端的响应：" + rd;
                                ChannelDemo2.wt(sc, wt);
                            } catch (Exception e) {
                                slku.cancel();
                            }
                        }
                    }
                    slt.selectNow();
                }
            } catch (Exception e) {e.printStackTrace();}
        }
    }
}
