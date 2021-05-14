package netty.demo.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import netty.demo.protocol.Message;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2019-10-24
 */
public class ProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        String jsonString = byteBuf.toString(StandardCharsets.UTF_8);
        System.out.println("=>" + jsonString);
        Message message = JSON.parseObject(jsonString, Message.class);
        out.add(message);
    }
}
