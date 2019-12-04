package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysOperationLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysOperationLogService {

    @Resource
    private SysOperationLogMapper sysOperationLogMapper;

}
