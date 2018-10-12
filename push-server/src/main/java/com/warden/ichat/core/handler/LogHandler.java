package com.warden.ichat.core.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.CombinedChannelDuplexHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Slf4j
public class LogHandler extends CombinedChannelDuplexHandler {

    private static final AtomicInteger COUNT = new AtomicInteger();

    public LogHandler() {
        super(new LogInboundChannelHandler(), new LogOutboundChannelHandler());
    }

    public static void showLog() {
        log.info("connection count is {}", COUNT.get());
    }

    private static class LogInboundChannelHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            COUNT.incrementAndGet();
            super.channelActive(ctx);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            COUNT.decrementAndGet();
            super.channelInactive(ctx);
        }
    }

    private static class LogOutboundChannelHandler extends ChannelOutboundHandlerAdapter {

    }
}
