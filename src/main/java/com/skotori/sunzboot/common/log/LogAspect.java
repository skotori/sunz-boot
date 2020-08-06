package com.skotori.sunzboot.common.log;

import com.alibaba.fastjson.JSON;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.entity.SysLog;
import com.skotori.sunzboot.common.utils.HttpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 记录日志注解切面
 * @author skotori
 * @date 2019-12-03 15:17
 */
@Aspect // 把当前类标识为一个切面供容器读取
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.skotori.sunzboot.common.log.Log)") // 植入Advice的触发条件
    public void pointcut() {}

    @Around("pointcut()") // 环绕增强
    public Object around(ProceedingJoinPoint point) {
        Object proceed = null;
        String exceptionMsg = "";
        long beginTime = System.currentTimeMillis();
        try {
            // 执行程序
            proceed = point.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
            exceptionMsg = t.getMessage();
            proceed = Result.error(exceptionMsg);
            log.error("程序执行异常：[ {} ]", exceptionMsg);
        }
        long endTime = System.currentTimeMillis();
        // 执行耗时(毫秒)
        long executeTime = endTime - beginTime;
        log.info("程序执行耗时：[ {} ]毫秒", executeTime);
        try {
            // 记录日志
            saveLog(point, proceed, executeTime, exceptionMsg);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("记录日志异常：[ {} ]", e.getMessage());
        }
        return proceed;
    }

    private void saveLog(ProceedingJoinPoint point, Object proceed, long executeTime, String exceptionMsg) {
        SysLog sysLog = new SysLog();
        sysLog.setSourceIp(HttpUtil.getIp());
        sysLog.setSourceBrowser(HttpUtil.getBrowser());
        sysLog.setRequestUrl(HttpUtil.getUrl());
        sysLog.setRequestMethod(HttpUtil.getMethod());
        sysLog.setRequestTime(new Date());
        sysLog.setRequestUser(HttpUtil.getAccount());

        // 执行的方法
        String className = point.getTarget().getClass().getName();
        MethodSignature signature = (MethodSignature) point.getSignature();
        String methodName = signature.getName();
        sysLog.setExecuteMethod(className + "." + methodName + "()");

        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的信息
            sysLog.setExecuteMsg(logAnnotation.msg());
            sysLog.setLogType(logAnnotation.type().getCode());
        }

        // 方法的参数
        Object[] args = point.getArgs();
        // 方法的参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += ", " + paramNames[i] + ": " + args[i];
            }
            if (params.length() > 1) {
                params = params.substring(2);
            }
            sysLog.setRequestData(params);
        }

        sysLog.setExecuteTime(executeTime);
        sysLog.setResponseData(JSON.toJSONString(proceed));
        if (!"".equals(exceptionMsg)) {
            sysLog.setExceptionMsg(exceptionMsg);
            sysLog.setResponseState(0);
        } else {
            Result result = (Result) proceed;
            if ("0".equals(result.getStatus())) {
                sysLog.setExceptionMsg(result.getMessage());
                sysLog.setResponseState(0);
            } else {
                sysLog.setResponseState(1);
            }
        }

        // 多线程记录日志
        LogManager.executeLog(sysLog);
    }

}
