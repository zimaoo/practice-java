package netty.demo.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import netty.demo.protocol.Message;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2019-10-24
 */
public class ProtocolEncoder extends MessageToMessageEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message responseMessage, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(JSON.toJSONString(responseMessage).getBytes(StandardCharsets.UTF_8));
        out.add(buffer);
    }
}
