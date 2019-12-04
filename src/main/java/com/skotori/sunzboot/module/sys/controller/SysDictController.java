package com.skotori.sunzboot.module.sys.controller;

import com.skotori.sunzboot.module.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {

    private Logger log = LoggerFactory.getLogger(SysDictController.class);

    @Autowired
    private SysDictService sysDictService;

}
