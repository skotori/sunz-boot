package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysDeptMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 部门service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

}
