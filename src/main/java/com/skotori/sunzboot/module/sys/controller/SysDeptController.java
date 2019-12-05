package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.model.SysDept;
import com.skotori.sunzboot.module.sys.service.SysDeptService;
import com.skotori.sunzboot.util.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController {

    private Logger log = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 分页查询部门列表
     * @param pageNum
     * @param pageSize
     * @param dept
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysDept dept) {
        log.info("分页查询部门列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数dept：[ {} ]", pageNum, pageSize, dept);
        try {
            PageInfo<SysDept> pageInfo = sysDeptService.pageList(pageNum, pageSize, dept);
            log.info("分页查询部门列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询部门列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysDept dept) {
        log.info("查询部门列表，body参数dept：[ {} ]", dept);
        try {
            List<SysDept> deptList = sysDeptService.list(dept);
            log.info("查询部门列表成功");
            return Result.success(deptList);
        } catch (Exception e) {
            log.error("查询部门列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询部门树形
     * @param dept
     * @return
     */
    @PostMapping("treeList")
    public Result treeList(@RequestBody SysDept dept) {
        log.info("查询部门树形，body参数dept：[ {} ]", dept);
        try {
            List<TreeNode> treeList = sysDeptService.treeList(dept);
            log.info("查询部门树形成功");
            return Result.success(treeList);
        } catch (Exception e) {
            log.error("查询部门树形异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
