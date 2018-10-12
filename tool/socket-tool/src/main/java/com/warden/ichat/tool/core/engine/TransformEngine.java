package com.warden.ichat.tool.core.engine;

import com.google.common.collect.Lists;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.warden.ichat.tool.core.channel.ChannelHolder;
import com.warden.ichat.tool.core.factory.BootstrapFactory;
import com.warden.ichat.tool.core.factory.HandlerFactory;
import com.warden.ichat.tool.core.handler.BusinessHandler;
import com.warden.ichat.tool.core.handler.TransientModelHandler;
import com.warden.ichat.tool.domain.enums.ConnectionModel;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
@Slf4j
public class TransformEngine {

    public static void connect(String host, int port, int num) {
        num = num <= 0 ? 1 : num;
        Bootstrap bootstrap = BootstrapFactory.getInstance();
        for (int i = 0; i < num; i++) {
            ChannelFuture channelFuture = bootstrap.connect(host, port);
            channelFuture.addListener(future -> {
                log.info("add channel is {}", channelFuture.channel());
                ChannelHolder.add(channelFuture.channel());
            });
        }
    }

    public static void sendMsg(ConnectionModel model, String msg) {
        if (model == ConnectionModel.DEFAULT_MODEL || model == ConnectionModel.PERSISTENT) {
            ChannelHolder.removeHandler(TransientModelHandler.HANDLER_NAME);
            ChannelHolder.addLast(BusinessHandler.HANDLER_NAME, HandlerFactory.getBusinessHandle());
        } else {
            ChannelHolder.removeHandler(BusinessHandler.HANDLER_NAME);
            ChannelHolder.addLast(TransientModelHandler.HANDLER_NAME, HandlerFactory.getTransientModelHandler());
        }
        ChannelHolder.writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
    }




}
