package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.module.sys.mapper.SysLogMapper;
import com.skotori.sunzboot.module.sys.entity.SysLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统日志service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * 分页查询日志列表
     * @param pageNum
     * @param pageSize
     * @param log
     * @return
     */
    public PageInfo<SysLog> pageList(Integer pageNum, Integer pageSize, SysLog log) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> operationLogList = sysLogMapper.selectList(log);
        return new PageInfo<>(operationLogList);
    }

}
