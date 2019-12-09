package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.module.sys.mapper.SysOperationLogMapper;
import com.skotori.sunzboot.module.sys.model.SysOperationLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysOperationLogService {

    @Resource
    private SysOperationLogMapper sysOperationLogMapper;

    /**
     * 分页查询操作日志列表
     * @param pageNum
     * @param pageSize
     * @param operationLog
     * @return
     */
    public PageInfo<SysOperationLog> pageList(Integer pageNum, Integer pageSize, SysOperationLog operationLog) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysOperationLog> operationLogList = sysOperationLogMapper.selectOperationLogList(operationLog);
        return new PageInfo<>(operationLogList);
    }

    /**
     * 查询操作日志列表
     * @param operationLog
     * @return
     */
    public List<SysOperationLog> list(SysOperationLog operationLog) {
        return sysOperationLogMapper.selectOperationLogList(operationLog);
    }

}
