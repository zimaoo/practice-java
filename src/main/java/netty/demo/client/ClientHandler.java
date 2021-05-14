package netty.demo.client;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.demo.protocol.Message;

import java.util.concurrent.TimeUnit;

/**
 * 客户端业务处理
 * @author zhangxinpeng
 * @date 2019-10-23
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        System.out.println("客户端收到：" + JSON.toJSONString(message));
        message.setId(message.getId() + 1);
        message.setContent("from client");
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        TimeUnit.SECONDS.sleep(3);
        ctx.flush();
    }
}
