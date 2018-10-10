package com.warden.ichat.config;

import com.warden.ichat.core.server.NettyServerBuilder;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Configuration
public class ApplicationConfiguration extends ApplicationObjectSupport {

    @Bean
    public NettyServerBuilder nettyServerBuilder(ServerConfig config) {
        return new NettyServerBuilder(config);
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        NettyServerBuilder builder = context.getBean(NettyServerBuilder.class);
        builder.build();
        super.initApplicationContext(context);
    }
}
