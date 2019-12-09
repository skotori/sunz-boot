package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysOperationLog;
import com.skotori.sunzboot.module.sys.service.SysOperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysOperationLog")
public class SysOperationLogController {

    private Logger log = LoggerFactory.getLogger(SysOperationLogController.class);

    @Autowired
    private SysOperationLogService sysOperationLogService;

    /**
     * 分页查询操作日志列表
     * @param pageNum
     * @param pageSize
     * @param operationLog
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysOperationLog operationLog) {
        log.info("分页查询操作日志列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数operationLog：[ {} ]", pageNum, pageSize, operationLog);
        try {
            PageInfo<SysOperationLog> pageInfo = sysOperationLogService.pageList(pageNum, pageSize, operationLog);
            log.info("分页查询操作日志列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询操作日志列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询操作日志列表
     * @param operationLog
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysOperationLog operationLog) {
        log.info("查询操作日志列表，body参数operationLog：[ {} ]", operationLog);
        try {
            List<SysOperationLog> operationLogList = sysOperationLogService.list(operationLog);
            log.info("查询操作日志列表成功");
            return Result.success(operationLogList);
        } catch (Exception e) {
            log.error("查询操作日志列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
