package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 查询登录日志列表
     * @param loginLog
     * @return
     */
    List<SysLoginLog> selectLoginLogList(SysLoginLog loginLog);

}
