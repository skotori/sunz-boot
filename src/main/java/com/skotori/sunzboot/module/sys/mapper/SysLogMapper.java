package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统日志mapper
 * @author skotori
 * @date 2019-12-03 10-25
 */
@Mapper
public interface SysLogMapper {

    /**
     * 添加操作日志
     * @param log
     * @return
     */
    Integer insertLog(SysLog log);


    /**
     * 查询操作日志列表
     * @param log
     * @return
     */
    List<SysLog> selectList(SysLog log);

}
