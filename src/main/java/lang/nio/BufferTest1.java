package lang.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class BufferTest1 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        CharBuffer cbuf = buf.asCharBuffer();
        cbuf.put("xxxx");
        cbuf.flip();
        String s = cbuf.toString();
        System.out.println(s);
    }
}
