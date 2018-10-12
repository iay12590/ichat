package com.warden.ichat.tool.core.handler;

import com.warden.ichat.tool.core.engine.LoggingEngine;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Slf4j
@ChannelHandler.Sharable
public class BusinessHandler extends SimpleChannelInboundHandler {

    public static final String HANDLER_NAME = "businessHandler";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            String str = buf.toString(Charset.forName("utf-8"));
            log.info("client receive msg : {}", str);
            LoggingEngine.showText("channel: " + ctx.channel().toString() + " receive msg: " + str);
        }
    }
}
