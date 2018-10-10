package com.warden.ichat.core.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Slf4j
public class BusinessHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) msg;
            String str = buf.toString(Charset.forName("utf-8"));
            log.info("receive msg :{}", str);
        }
        ctx.writeAndFlush(Unpooled.wrappedBuffer("return msg".getBytes())).addListener(future -> ctx.close());
    }
}
