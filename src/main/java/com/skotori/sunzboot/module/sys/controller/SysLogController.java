package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.entity.SysLog;
import com.skotori.sunzboot.module.sys.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统日志controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysOperationLog")
public class SysLogController {

    private static final Logger log = LoggerFactory.getLogger(SysLogController.class);

    @Resource
    private SysLogService sysLogService;

    /**
     * 分页查询日志列表
     * @param pageNum
     * @param pageSize
     * @param sysLog
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询日志列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysLog sysLog) {
        log.info("分页查询日志列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数operationLog：[ {} ]", pageNum, pageSize, sysLog);
        PageInfo<SysLog> pageInfo = sysLogService.pageList(pageNum, pageSize, sysLog);
        log.info("分页查询日志列表成功");
        return Result.success(pageInfo);
    }

}
