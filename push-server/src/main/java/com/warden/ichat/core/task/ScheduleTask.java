package com.warden.ichat.core.task;

import com.warden.ichat.annotion.EnableLogging;
import com.warden.ichat.core.handler.LogHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/10
 */
@Slf4j
@Component
public class ScheduleTask {

    @Scheduled(cron = "0/30 * * * * * ")
    @ConditionalOnBean(annotation = EnableLogging.class)
    public void logTask() {
        LogHandler.showLog();
    }

}
