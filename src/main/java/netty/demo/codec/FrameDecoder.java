package netty.demo.codec;


import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author zhangxinpeng
 * @date 2019-10-24
 */
public class FrameDecoder extends LengthFieldBasedFrameDecoder {
    public FrameDecoder() {
        super(10240, 0, 2, 0, 2);
    }
}
