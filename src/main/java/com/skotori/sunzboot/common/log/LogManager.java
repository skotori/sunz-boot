package com.skotori.sunzboot.common.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日志记录线程管理器
 * @author skotori
 * @date 2019-11-29 18:00
 */
public class LogManager {

    // 日志记录操作延时
    private static Integer OPERATE_DELAY_TIME = 10;

    // 日志记录异步操作的线程池
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private static LogFactory logFactory = LogFactory.getLogFactory();

    public static void executeLoginSuccessLog(String account, String ip) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                logFactory.loginSuccessLog(account, ip);
            }
        };
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    public static void executeLoginErrorLog(String account, String msg, String ip) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                logFactory.loginErrorLog(account, msg, ip);
            }
        };
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

}
