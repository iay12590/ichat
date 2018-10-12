package com.warden.ichat.core.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@AllArgsConstructor
public class DefaultChannelInitializer extends ChannelInitializer<SocketChannel>{

    private boolean enableLogging;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        if (enableLogging) {
            ch.pipeline().addLast("logHandler", new LogHandler());
        }
        ch.pipeline().addLast("handler", new BusinessHandler());
    }
}
