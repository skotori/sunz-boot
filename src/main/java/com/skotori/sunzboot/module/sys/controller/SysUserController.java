package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysUser;
import com.skotori.sunzboot.module.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员控制器
 * @author skotori
 * @date 2019/11/06 20:35
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    private Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysUser user) {
        log.info("分页查询用户列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数user：[ {} ]", pageNum, pageSize, user);
        try {
            PageInfo<SysUser> pageInfo = sysUserService.pageList(pageNum, pageSize, user);
            log.info("分页查询用户列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询用户列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysUser user) {
        log.info("查询用户列表，body参数user：[ {} ]", user);
        try {
            List<SysUser> userList = sysUserService.list(user);
            log.info("查询用户列表成功");
            return Result.success(userList);
        } catch (Exception e) {
            log.error("查询用户列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SysUser user) {
        log.info("新增用户，body参数user：[ {} ]", user);
        try {
            sysUserService.add(user);
            log.info("新增用户成功");
            return Result.success();
        } catch (Exception e) {
            log.error("新增用户异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除用户，param参数id：[ {} ]", id);
        try {
            sysUserService.delete(id);
            log.info("删除用户成功");
            return Result.success();
        } catch (Exception e) {
            log.error("删除用户异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SysUser user) {
        log.info("更新用户，body参数user：[ {} ]", user);
        try {
            sysUserService.update(user);
            log.info("更新用户成功");
            return Result.success();
        } catch (Exception e) {
            log.error("更新用户异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
