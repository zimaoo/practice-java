package lang.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class BufferTest {
    private static final String ENCODING  = "utf-8";

    public static void main(String[] args) throws CharacterCodingException {
        String slogan = "Good Job! 你好";
        ByteBuffer byteBuffer = ByteBuffer.wrap(slogan.getBytes());
        CharBuffer charBuffer = Charset.forName(ENCODING).newDecoder().decode(byteBuffer.asReadOnlyBuffer());
        System.out.println(charBuffer.toString());
    }
}
