package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志mapper
 * @author skotori
 * @date 2019-11-27 17:38
 */
@Mapper
public interface SysLoginLogMapper {

    /**
     * 添加登录日志
     * @param sysLoginLog
     * @return
     */
    Integer insertLoginLog(SysLoginLog sysLoginLog);

}
