package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.entity.SysNotice;
import com.skotori.sunzboot.module.sys.service.SysNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统通知controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysNotice")
public class SysNoticeController {

    private static final Logger log = LoggerFactory.getLogger(SysNoticeController.class);

    @Resource
    private SysNoticeService sysNoticeService;

    /**
     * 分页查询通知列表
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询通知列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysNotice notice) {
        log.info("分页查询通知列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数notice：[ {} ]", pageNum, pageSize, notice);
        PageInfo<SysNotice> pageInfo = sysNoticeService.pageList(pageNum, pageSize, notice);
        log.info("分页查询通知列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 新增通知
     * @param notice
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增通知", type = OPERATE_LOG)
    public Result add(@RequestBody SysNotice notice) {
        log.info("新增通知，body参数notice：[ {} ]", notice);
        sysNoticeService.add(notice);
        log.info("新增通知成功");
        return Result.success();
    }

    /**
     * 删除通知
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除通知", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除通知，param参数id：[ {} ]", id);
        sysNoticeService.delete(id);
        log.info("删除通知成功");
        return Result.success();
    }

    /**
     * 更新通知
     * @param notice
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新通知", type = OPERATE_LOG)
    public Result update(@RequestBody SysNotice notice) {
        log.info("更新通知，body参数notice：[ {} ]", notice);
        sysNoticeService.update(notice);
        log.info("更新通知成功");
        return Result.success();
    }

}
