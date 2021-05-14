package netty.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.demo.codec.FrameDecoder;
import netty.demo.codec.FrameEncoder;
import netty.demo.codec.ProtocolDecoder;
import netty.demo.codec.ProtocolEncoder;
import netty.demo.protocol.Message;

/**
 * 客户端
 * @author zhangxinpeng
 * @date 2019-10-23
 */
public class Client {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();
                            channelPipeline.addLast("frameDecoder", new FrameDecoder());
                            channelPipeline.addLast("frameEncoder", new FrameEncoder());

                            channelPipeline.addLast("protocolDecoder", new ProtocolDecoder());
                            channelPipeline.addLast("protocolEncoder", new ProtocolEncoder());
                            // channelPipeline.addLast(new LoggingHandler(LogLevel.INFO));
                            channelPipeline.addLast(new ClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090).sync();

            Message requestMessage = new Message(1, "from client");
            channelFuture.channel().writeAndFlush(requestMessage);

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
