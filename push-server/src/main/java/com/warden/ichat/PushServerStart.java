package com.warden.ichat;

import com.warden.ichat.annotion.EnableLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@SpringBootApplication
@EnableScheduling
@EnableLogging
public class PushServerStart {

    public static void main(String[] args) {
        SpringApplication.run(PushServerStart.class, args);
    }

}
