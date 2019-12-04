package com.skotori.sunzboot.module.sys.controller;

import com.skotori.sunzboot.module.sys.service.SysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController {

    private Logger log = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private SysDeptService sysDeptService;

}
