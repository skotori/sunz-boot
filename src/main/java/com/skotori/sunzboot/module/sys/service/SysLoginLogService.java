package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysLoginLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录日志service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

}
