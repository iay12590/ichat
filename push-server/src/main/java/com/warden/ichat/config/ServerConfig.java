package com.warden.ichat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ichat.server")
public class ServerConfig {
    private String host = "";
    private Integer port = 80;
    private Boolean enableLog = false;
}
