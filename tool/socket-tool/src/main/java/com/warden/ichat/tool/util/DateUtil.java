package com.warden.ichat.tool.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
@Slf4j
public class DateUtil {

    public static void sleepWithoutInterrupt(long time) {
        while (true) {
            try {
                Thread.sleep(time);
                break;
            } catch (InterruptedException e) {
                log.error("Interrupted when sleep! this will be ignored!", e);
            }
        }
    }

}
