package com.warden.ichat.tool.core.factory;

import com.warden.ichat.tool.core.handler.BusinessHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
public class BootstrapFactory {

    private volatile static Bootstrap instance;

    public static Bootstrap getInstance() {
        if (instance == null) {
            synchronized (BootstrapFactory.class) {
                instance = getBootstrap();
            }
        }
        return instance;
    }

    private static Bootstrap getBootstrap() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class);
        b.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {

            }
        });
        return b;
    }

}
