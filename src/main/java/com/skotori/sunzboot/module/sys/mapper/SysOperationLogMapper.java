package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysOperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志mapper
 * @author skotori
 * @date 2019-12-03 10-25
 */
@Mapper
public interface SysOperationLogMapper {

    /**
     * 添加操作日志
     * @param sysOperationLog
     * @return
     */
    Integer insertOperationLog(SysOperationLog sysOperationLog);

}
