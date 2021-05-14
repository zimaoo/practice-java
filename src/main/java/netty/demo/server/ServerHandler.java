package netty.demo.server;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.demo.protocol.Message;

/**
 * 服务端业务处理
 * @author zhangxinpeng
 * @date 2019-10-24
 */
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        if (ctx.channel().isActive() && ctx.channel().isWritable()) {
            System.out.println("服务端收到：" + JSON.toJSONString(message));
            message.setId(message.getId() + 1);
            message.setContent("from server");
            ctx.writeAndFlush(message);
        }
    }
}
