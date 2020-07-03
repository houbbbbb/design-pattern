package nio;

/**
 * @author : hbw
 * @desctiption :
 * @date : 2020-07-03 10:02
 */
public class BufferDemo {
}

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
class BufferTest {
    public static void main(String[] args) {

    }
}
