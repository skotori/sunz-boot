package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PowerTreeNode;
import com.skotori.sunzboot.module.sys.model.SysPower;
import com.skotori.sunzboot.module.sys.service.SysPowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysPower")
public class SysPowerController {

    private Logger log = LoggerFactory.getLogger(SysPowerController.class);

    @Autowired
    private SysPowerService sysPowerService;

    /**
     * 查询菜单树形
     * @return
     */
    @GetMapping("menuTree")
    public Result menuTree() {
        log.info("查询菜单树形");
        try {
            List<MenuTreeNode> menuTree = sysPowerService.menuTree();
            log.info("查询菜单树形成功");
            return Result.success(menuTree);
        } catch (Exception e) {
            log.error("查询菜单树形异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 分页查询权限列表
     * @param pageNum
     * @param pageSize
     * @param power
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysPower power) {
        log.info("分页查询权限列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数power：[ {} ]", pageNum, pageSize, power);
        try {
            PageInfo<SysPower> pageInfo = sysPowerService.pageList(pageNum, pageSize, power);
            log.info("分页查询权限列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询权限列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询权限列表
     * @param power
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysPower power) {
        log.info("查询权限列表，body参数power：[ {} ]", power);
        try {
            List<SysPower> powerList = sysPowerService.list(power);
            log.info("查询权限列表成功");
            return Result.success(powerList);
        } catch (Exception e) {
            log.error("查询权限列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询权限树形
     * @param power
     * @return
     */
    @PostMapping("powerTree")
    public Result powerTree(@RequestBody SysPower power) {
        log.info("查询权限树形，body参数power：[ {} ]", power);
        try {
            List<PowerTreeNode> powerTree = sysPowerService.powerTree(power);
            log.info("查询权限树形成功");
            return Result.success(powerTree);
        } catch (Exception e) {
            log.error("查询权限树形异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增权限
     * @param power
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SysPower power) {
        log.info("新增权限，body参数power：[ {} ]", power);
        try {
            sysPowerService.add(power);
            log.info("新增权限成功");
            return Result.success();
        } catch (Exception e) {
            log.error("新增权限异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除权限，param参数id：[ {} ]", id);
        try {
            sysPowerService.delete(id);
            log.info("删除权限成功");
            return Result.success();
        } catch (Exception e) {
            log.error("删除权限异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新权限
     * @param power
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SysPower power) {
        log.info("更新权限，body参数power：[ {} ]", power);
        try {
            sysPowerService.update(power);
            log.info("更新权限成功");
            return Result.success();
        } catch (Exception e) {
            log.error("更新权限异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
