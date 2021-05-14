package netty.demo.codec;


import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author zhangxinpeng
 * @date 2019-10-24
 */
public class FrameEncoder extends LengthFieldPrepender {
    public FrameEncoder() {
        super(2);
    }
}
