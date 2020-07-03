package nio;

import java.nio.ByteBuffer;

/**
 * @author : hbw
 * @desctiption :
 * @date : 2020-07-03 10:02
 */
public class BufferDemo {
    /**
     * ByteBuffer中有三个重要标志：
     * capacity: 容量
     * position: 位置
     * limit: 限制，主要用于在读操作时记录有效数据的位置，即最后写入的位置，也是可以读取的数据的最大值
     *
     * 基本操作：
     * put：写入
     * flip：转为读取模式
     * get：读
     * compact：清除已读数据
     */
    static class BufferTest {
        public static void main(String[] args) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(5); // 堆内存

            // ByteBuffer byteBuffer = ByteBuffer.allocateDirect(5); // 直接内存

            long t1 = System.currentTimeMillis();

            byteBuffer.put((byte) 'a'); // 写入
            byteBuffer.put((byte) 'b');
            byteBuffer.put((byte) 'c');
            byteBuffer.put((byte) 'd');
            byteBuffer.put((byte) 'e');

            byteBuffer.flip(); // 转为读模式

            for(int i = 0; i < byteBuffer.limit(); i++) {
                System.out.println(byteBuffer.get()); // 读取
            }

            byteBuffer.compact(); // 清除已读

            for(int i = 0; i < 5; i++) {
                byteBuffer.put((byte) i); // 写入
            }

            byteBuffer.flip(); // 转为读

            for(int i = 0; i < byteBuffer.limit(); i++) {
                System.out.println("value " + byteBuffer.get());
                System.out.println("pos " + byteBuffer.position());
            }

            System.out.println(byteBuffer.limit());

            System.out.println(byteBuffer.capacity());

            long t2 = System.currentTimeMillis();

            System.out.println(t2 - t1);
        }
    }
}


