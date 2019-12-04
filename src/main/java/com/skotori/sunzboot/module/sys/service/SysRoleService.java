package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}
