package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysNotice;
import com.skotori.sunzboot.module.sys.service.SysNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通知控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysNotice")
public class SysNoticeController {

    private Logger log = LoggerFactory.getLogger(SysNoticeController.class);

    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * 分页查询通知列表
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysNotice notice) {
        log.info("分页查询通知列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数notice：[ {} ]", pageNum, pageSize, notice);
        try {
            PageInfo<SysNotice> pageInfo = sysNoticeService.pageList(pageNum, pageSize, notice);
            log.info("分页查询通知列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询通知列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询通知列表
     * @param notice
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysNotice notice) {
        log.info("查询通知列表，body参数notice：[ {} ]", notice);
        try {
            List<SysNotice> noticeList = sysNoticeService.list(notice);
            log.info("查询通知列表成功");
            return Result.success(noticeList);
        } catch (Exception e) {
            log.error("查询通知列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增通知
     * @param notice
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SysNotice notice) {
        log.info("新增通知，body参数notice：[ {} ]", notice);
        try {
            sysNoticeService.add(notice);
            log.info("新增通知成功");
            return Result.success();
        } catch (Exception e) {
            log.error("新增通知异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除通知
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除通知，param参数id：[ {} ]", id);
        try {
            sysNoticeService.delete(id);
            log.info("删除通知成功");
            return Result.success();
        } catch (Exception e) {
            log.error("删除通知异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新通知
     * @param notice
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SysNotice notice) {
        log.info("更新通知，body参数notice：[ {} ]", notice);
        try {
            sysNoticeService.update(notice);
            log.info("更新通知成功");
            return Result.success();
        } catch (Exception e) {
            log.error("更新通知异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
