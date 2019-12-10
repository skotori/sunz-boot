package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysRole;
import com.skotori.sunzboot.module.sys.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {

    private Logger log = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param role
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysRole role) {
        log.info("分页查询角色列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数role：[ {} ]", pageNum, pageSize, role);
        try {
            PageInfo<SysRole> pageInfo = sysRoleService.pageList(pageNum, pageSize, role);
            log.info("分页查询角色列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询角色列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询角色列表
     * @param role
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysRole role) {
        log.info("查询角色列表，body参数role：[ {} ]", role);
        try {
            List<SysRole> roleList = sysRoleService.list(role);
            log.info("查询角色列表成功");
            return Result.success(roleList);
        } catch (Exception e) {
            log.error("查询角色列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SysRole role) {
        log.info("新增角色，body参数role：[ {} ]", role);
        try {
            sysRoleService.add(role);
            log.info("新增角色成功");
            return Result.success();
        } catch (Exception e) {
            log.error("新增角色异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除角色，param参数id：[ {} ]", id);
        try {
            sysRoleService.delete(id);
            log.info("删除角色成功");
            return Result.success();
        } catch (Exception e) {
            log.error("删除角色异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SysRole role) {
        log.info("更新角色，body参数role：[ {} ]", role);
        try {
            sysRoleService.update(role);
            log.info("更新角色成功");
            return Result.success();
        } catch (Exception e) {
            log.error("更新角色异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
