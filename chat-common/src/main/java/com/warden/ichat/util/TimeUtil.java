package com.warden.ichat.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @author <a href="linjianhua@wxchina.com">JianHua.Lin</a>
 * @version 1.0.0
 * @date 2018/10/11
 */
public class TimeUtil {

    private static final ThreadLocal<StopWatch> STOP_WATCH_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 开始计时
     */
    public static void start() {
        if(STOP_WATCH_THREAD_LOCAL.get() == null) {
            STOP_WATCH_THREAD_LOCAL.set(new StopWatch());
        }
        STOP_WATCH_THREAD_LOCAL.get().reset();
        STOP_WATCH_THREAD_LOCAL.get().start();
    }

    /**
     * 结束计时,并返回耗时(s或者ms)
     */
    public static String stop(boolean removed) {
        Preconditions.checkState(STOP_WATCH_THREAD_LOCAL.get() != null, "not start a stopwatch");
        STOP_WATCH_THREAD_LOCAL.get().stop();
        long total = STOP_WATCH_THREAD_LOCAL.get().getTime();
        String totalTimeStr;
        if(total >= 1000){
            totalTimeStr = (total / 1000.0) + "s";
        }else{
            totalTimeStr = total + "ms";
        }
        if (removed) {
            STOP_WATCH_THREAD_LOCAL.remove();
        }
        return totalTimeStr;
    }

    /**
     * 返回耗时(s或者ms)
     */
    public static String getTime(long startTime, long endTime) {
        long total = endTime - startTime;
        String totalTimeStr;
        if(total / 1000.0 >= 1){
            totalTimeStr = (total / 1000.0) + "s";
        }else{
            totalTimeStr = total + "ms";
        }
        return totalTimeStr;
    }

}
