package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author zhangxinpeng
 * @date 2019-10-25
 */
public class HttpServer {
    public static void main(String[] args) {
        EventLoopGroup masterEventLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup slaveEventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterEventLoopGroup, slaveEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();
                            channelPipeline.addLast(new HttpServerCodec());
                            channelPipeline.addLast(new HttpServerExpectContinueHandler());
                            channelPipeline.addLast(new HttpServerHandler());
                        }
                    });

            Channel channel = serverBootstrap.bind(8080).sync().channel();

            System.err.println("http://127.0.0.1:8080");

            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            masterEventLoopGroup.shutdownGracefully();
            slaveEventLoopGroup.shutdownGracefully();
        }

    }
}
