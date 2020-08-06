package com.skotori.sunzboot.common.log;

import com.skotori.sunzboot.module.sys.mapper.SysLogMapper;
import com.skotori.sunzboot.module.sys.entity.SysLog;
import com.skotori.sunzboot.common.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 记录日志工厂类
 * @author skotori
 * @date 2019-11-27 17:46
 */
@Service
@DependsOn("springContextUtil")
public class LogFactory {

    private static final Logger log = LoggerFactory.getLogger(LogFactory.class);

    @Resource
    private SysLogMapper sysLogMapper;

    public static LogFactory getLogFactory() {
        return SpringContextUtil.getBean(LogFactory.class);
    }

    public void log(SysLog sysLog) {
        try {
            sysLogMapper.insertLog(sysLog);
        } catch (Exception e) {
            log.error("记录日志异常：[ {} ]", e.getMessage());
        }
    }

}
