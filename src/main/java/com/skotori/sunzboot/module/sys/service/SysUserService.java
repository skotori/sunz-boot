package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员service
 * @author skotori
 * @date 2019/11/06 20:36
 */
@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

}
