package com.warden.ichat.tool.core.handler;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
public class TransientModelHandler extends BusinessHandler{

    public static final String HANDLER_NAME = "transientModelHandler";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead0(ctx, msg);
    }
}
