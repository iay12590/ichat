package com.warden.ichat.tool.core.channel;

import com.google.common.collect.Lists;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/12
 */
public class ChannelHolder {

    private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("socket_tool_channel_group",
            GlobalEventExecutor.INSTANCE);

    private static final List<Channel> OLD_CHANNELS = Lists.newArrayList();

    public static boolean add(Channel channel){
        return CHANNEL_GROUP.add(channel);
    }

    public static ChannelGroupFuture write(Object msg) {
        return CHANNEL_GROUP.write(msg);
    }

    public static ChannelGroupFuture writeAndFlush(Object msg) {
        return CHANNEL_GROUP.writeAndFlush(msg);
    }

    public static void clear() {
        OLD_CHANNELS.addAll(CHANNEL_GROUP.parallelStream().collect(Collectors.toList()));
        close().addListener(future -> OLD_CHANNELS.clear());
        CHANNEL_GROUP.clear();
    }

    public static ChannelGroupFuture close() {
        return CHANNEL_GROUP.close();
    }

    public static void removeHandler(String handler) {
        CHANNEL_GROUP.forEach(channel -> {
            ChannelPipeline pipeline = channel.pipeline();
            if (pipeline.get(handler) != null) {
                pipeline.remove(handler);
            }
        });
    }

    public static void addLast(String handlerName, ChannelHandler handler) {
        CHANNEL_GROUP.forEach(channel -> {
            ChannelPipeline pipeline = channel.pipeline();
            if (pipeline.get(handlerName) == null) {
                channel.pipeline().addLast(handlerName, handler);
            }
        });
    }

}
