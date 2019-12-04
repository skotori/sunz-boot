package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysDictMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 字典service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

}
