package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PermissionTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysPermission;
import com.skotori.sunzboot.module.sys.service.SysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统权限controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysPower")
public class SysPermissionController {

    private static final Logger log = LoggerFactory.getLogger(SysPermissionController.class);

    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 查询树型菜单列表
     * @return
     */
    @GetMapping("menuTreeList")
    @Log(msg = "查询树型菜单列表", type = OPERATE_LOG)
    public Result menuTreeList() {
        log.info("查询树型菜单列表");
        List<MenuTreeNode> menuTreeList = sysPermissionService.menuTreeList();
        log.info("查询树型菜单列表成功");
        return Result.success(menuTreeList);
    }


    /**
     * 分页查询权限列表
     * @param pageNum
     * @param pageSize
     * @param permission
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询权限列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysPermission permission) {
        log.info("分页查询权限列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数permission：[ {} ]", pageNum, pageSize, permission);
        PageInfo<SysPermission> pageInfo = sysPermissionService.pageList(pageNum, pageSize, permission);
        log.info("分页查询权限列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 查询树型权限列表
     * @param permission
     * @return
     */
    @PostMapping("powerTree")
    @Log(msg = "查询树型权限列表", type = OPERATE_LOG)
    public Result powerTree(@RequestBody SysPermission permission) {
        log.info("查询树型权限列表，body参数permission：[ {} ]", permission);
        List<PermissionTreeNode> treeList = sysPermissionService.treeList(permission);
        log.info("查询树型权限列表成功");
        return Result.success(treeList);
    }

    /**
     * 新增权限
     * @param permission
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增权限", type = OPERATE_LOG)
    public Result add(@RequestBody SysPermission permission) {
        log.info("新增权限，body参数permission：[ {} ]", permission);
        sysPermissionService.add(permission);
        log.info("新增权限成功");
        return Result.success();
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除权限", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除权限，param参数id：[ {} ]", id);
        sysPermissionService.delete(id);
        log.info("删除权限成功");
        return Result.success();
    }

    /**
     * 更新权限
     * @param permission
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新权限", type = OPERATE_LOG)
    public Result update(@RequestBody SysPermission permission) {
        log.info("更新权限，body参数permission：[ {} ]", permission);
        sysPermissionService.update(permission);
        log.info("更新权限成功");
        return Result.success();
    }

}
