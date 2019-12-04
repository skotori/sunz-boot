package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysPowerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysPowerService {

    @Resource
    private SysPowerMapper sysPowerMapper;

}
