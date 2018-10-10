package com.warden.ichat.core.server;

import com.warden.ichat.config.ServerConfig;
import com.warden.ichat.core.handler.DefaultChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Slf4j
@AllArgsConstructor
public class NettyServerBuilder {

    private ServerConfig config;

    public void build() {
        log.info("server start ...");
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new DefaultChannelInitializer(true))
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, config.getEnableLog());
            ChannelFuture future = bootstrap.bind(config.getPort()).sync();
            log.info("server has started at port: {}", config.getPort());
            future.channel().closeFuture().sync();
            log.info("server has been interrupted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}