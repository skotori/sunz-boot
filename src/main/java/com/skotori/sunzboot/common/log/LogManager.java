package com.skotori.sunzboot.common.log;

import com.skotori.sunzboot.module.sys.entity.SysLog;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 记录日志多线程管理器
 * @author skotori
 * @date 2019-11-29 18:00
 */
public class LogManager {

    // 日志记录操作延时
    private static final Integer OPERATE_DELAY_TIME = 10;

    // 日志记录异步操作的线程池
    private static final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private static final LogFactory logFactory = LogFactory.getLogFactory();

    public static void executeLog(SysLog sysLog) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                logFactory.log(sysLog);
            }
        };
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

}
