package algorithm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * @author : hbw
 * @desctiption : 什么是一致性hash
 * 1. hash环，0-max
 * 2. 每个服务器创建一部分虚拟节点，尽量均匀地分布在hash环上
 * 3. 请求的hash值在hash环上顺时针递增到最近一个节点所对应的服务器即为它要访问的服务器
 * 4. 特点提高服务器的可伸缩性
 * @date : 2020-06-30 08:53
 */
public class ConsistentHash {
    private static TreeMap<Long, String> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        String ipPre = "192.168.2.";
        // 为每个服务添加虚拟节点，hash环
        for (int i = 0; i < 10; i ++) {
            put(100, ipPre + i);
        }
        // 随机请求，统计个服务接收到的请求次数
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i ++) {
            String ip = get(hash(UUID.randomUUID().toString()+i));
            countMap.compute(ip, (a, b) -> {
                if (null == b) return 1;
                return b + 1;
            });
        }

        countMap.forEach((a, b) -> {
            System.out.println("ip = " + a + ", count = " + b);
        });
    }

    public static void put (int n, String ip) {
        for (int i = 0; i < n; i ++) {
            treeMap.put(hash((ip+i)), ip);
        }
    }

    public static String get (Long key) {
        if (treeMap.containsKey(key)) return treeMap.get(key);
        SortedMap<Long, String> tailMap = treeMap.tailMap(key);
        key = tailMap.isEmpty() ? treeMap.firstKey() : tailMap.firstKey();
        return treeMap.get(key);
    }

    public static Long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }
}


