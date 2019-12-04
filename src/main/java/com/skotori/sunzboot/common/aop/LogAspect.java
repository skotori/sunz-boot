package com.skotori.sunzboot.common.aop;

import com.skotori.sunzboot.common.annotation.Log;
import com.skotori.sunzboot.common.annotation.LogType;
import com.skotori.sunzboot.common.log.LogManager;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.model.SysOperationLog;
import com.skotori.sunzboot.util.HttpUtil;
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

    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.skotori.sunzboot.common.annotation.Log)") // 植入Advice的触发条件
    public void pointcut() {
    }

    @Around("pointcut()") // 环绕增强
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        long endTime = System.currentTimeMillis();
        // 执行时长(毫秒)
        long executeTime = endTime - beginTime;
        log.info("程序执行[ {} ]毫秒", executeTime);
        // 保存日志
        try {
            saveLog(point);
        } catch (Exception e) {
            log.error("记录日志异常：[ {} ]", e.getMessage());
        }
        return proceed;
    }

    private void saveLog(ProceedingJoinPoint point) {
        SysOperationLog operationLog = new SysOperationLog();
        operationLog.setAccount(ShiroUtil.getAccount());
        operationLog.setTime(new Date());
        operationLog.setIp(HttpUtil.getIp());

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);
        LogType type = null;
        if (logAnnotation != null) {
            // 注解上的描述
            operationLog.setName(logAnnotation.name());
            type = logAnnotation.type();
        }

        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        operationLog.setMethod(className + "." + methodName + "()");

        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
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
            operationLog.setParam(params);
        }

        // 保存操作日志
        if (type != null) {
            operationLog.setType(type.getCode());
            LogManager.executeOperationLog(operationLog);
        }
    }

}
