package lang.math;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Random;

public class ManagementTest extends Thread{
    public static void main(String[] args) {
        new ManagementTest().run();
        List<MemoryPoolMXBean> memoryPoolMXBeanList =  ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean memoryPoolMXBean : memoryPoolMXBeanList) {
            System.out.println(memoryPoolMXBean.getName());
        }
    }

    @Override
    public void run() {
        //512m
        long length = 1L << 29;
        //4g
        long _4G = 1L << 3;
        long cur = 0L;
        try {
            MappedByteBuffer mappedByteBuffer;
            Random random = new Random();
            while (cur < _4G) {
                mappedByteBuffer = new RandomAccessFile("/Users/wanba/IdeaProjects/practice-java/src/main/java/management/bf.data", "rw").getChannel()
                        .map(FileChannel.MapMode.READ_WRITE, cur, length);
                IntBuffer intBuffer = mappedByteBuffer.asIntBuffer();
                while (intBuffer.position() < intBuffer.capacity()) {
                    intBuffer.put(random.nextInt());
                }
                cur += length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
