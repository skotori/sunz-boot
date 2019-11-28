package com.skotori.sunzboot.common.log;

import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.mapper.SysLoginLogMapper;
import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * log所需要的数据接口
 * @author skotori
 * @date 2019-11-27 17:46
 */
@Service
public class LogFactory {

    private Logger log = LoggerFactory.getLogger(LogFactory.class);

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    public void loginSuccessLog(String account, String msg) {
        try {
            SysLoginLog loginLog = new SysLoginLog();
            loginLog.setAccount(account);
            loginLog.setType(2);
            loginLog.setTime(new Date());
            loginLog.setIp(ShiroUtil.getIp());
            loginLog.setMsg(msg);
            sysLoginLogMapper.insertLoginLog(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void loginErrorLog(String account, String msg) {
        try {
            SysLoginLog loginLog = new SysLoginLog();
            loginLog.setAccount(account);
            loginLog.setType(1);
            loginLog.setTime(new Date());
            loginLog.setIp(ShiroUtil.getIp());
            loginLog.setMsg(msg);
            sysLoginLogMapper.insertLoginLog(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
