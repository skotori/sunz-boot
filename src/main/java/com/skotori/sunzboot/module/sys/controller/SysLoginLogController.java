package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import com.skotori.sunzboot.module.sys.service.SysLoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登录日志控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysLoginLog")
public class SysLoginLogController {

    private Logger log = LoggerFactory.getLogger(SysLoginLogController.class);

    @Autowired
    private SysLoginLogService sysLoginLogService;

    /**
     * 分页查询登录日志列表
     * @param pageNum
     * @param pageSize
     * @param loginLog
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysLoginLog loginLog) {
        log.info("分页查询登录日志列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数loginLog：[ {} ]", pageNum, pageSize, loginLog);
        try {
            PageInfo<SysLoginLog> pageInfo = sysLoginLogService.pageList(pageNum, pageSize, loginLog);
            log.info("分页查询登录日志列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询登录日志列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询登录日志列表
     * @param loginLog
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysLoginLog loginLog) {
        log.info("查询登录日志列表，body参数loginLog：[ {} ]", loginLog);
        try {
            List<SysLoginLog> loginLogList = sysLoginLogService.list(loginLog);
            log.info("查询登录日志列表成功");
            return Result.success(loginLogList);
        } catch (Exception e) {
            log.error("查询登录日志列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
