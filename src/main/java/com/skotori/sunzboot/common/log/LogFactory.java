package com.skotori.sunzboot.common.log;

import com.skotori.sunzboot.module.sys.mapper.SysLoginLogMapper;
import com.skotori.sunzboot.module.sys.mapper.SysOperationLogMapper;
import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import com.skotori.sunzboot.module.sys.model.SysOperationLog;
import com.skotori.sunzboot.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * log所需要的数据接口
 * @author skotori
 * @date 2019-11-27 17:46
 */
@Service
@DependsOn("springContextUtil")
public class LogFactory {

    private Logger log = LoggerFactory.getLogger(LogFactory.class);

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Resource
    private SysOperationLogMapper sysOperationLogMapper;

    public static LogFactory getLogFactory() {
        return SpringContextUtil.getBean(LogFactory.class);
    }

    public void loginSuccessLog(String account, String ip) {
        try {
            SysLoginLog loginLog = new SysLoginLog();
            loginLog.setAccount(account);
            loginLog.setType(1);
            loginLog.setTime(new Date());
            loginLog.setIp(ip);
            loginLog.setMsg("");
            sysLoginLogMapper.insertLoginLog(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void loginErrorLog(String account, String msg, String ip) {
        try {
            SysLoginLog loginLog = new SysLoginLog();
            loginLog.setAccount(account);
            loginLog.setType(2);
            loginLog.setTime(new Date());
            loginLog.setIp(ip);
            loginLog.setMsg(msg);
            sysLoginLogMapper.insertLoginLog(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void insertLog(SysOperationLog operationLog) {
        try {
            sysOperationLogMapper.insertOperationLog(operationLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
