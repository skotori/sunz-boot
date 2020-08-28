package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.tree.treeNode.DeptTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysDept;
import com.skotori.sunzboot.module.sys.service.SysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统部门controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController {

    private static final Logger log = LoggerFactory.getLogger(SysDeptController.class);

    @Resource
    private SysDeptService sysDeptService;

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    @PostMapping("queryList")
    @Log(msg = "查询部门列表", type = OPERATE_LOG)
    public Result queryList(@RequestBody SysDept dept) {
        log.info("查询部门列表，body参数dept：[ {} ]", dept);
        List<SysDept> deptList = sysDeptService.queryList(dept);
        log.info("查询部门列表成功");
        return Result.success(deptList);
    }

    /**
     * 分页查询部门列表
     * @param pageNum
     * @param pageSize
     * @param dept
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询部门列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysDept dept) {
        log.info("分页查询部门列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数dept：[ {} ]", pageNum, pageSize, dept);
        PageInfo<SysDept> pageInfo = sysDeptService.pageList(pageNum, pageSize, dept);
        log.info("分页查询部门列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 查询树型部门列表
     * @param dept
     * @return
     */
    @PostMapping("treeList")
    @Log(msg = "查询树型部门列表", type = OPERATE_LOG)
    public Result treeList(@RequestBody SysDept dept) {
        log.info("查询树型部门列表，body参数dept：[ {} ]", dept);
        List<DeptTreeNode> treeList = sysDeptService.treeList(dept);
        log.info("查询树型部门列表成功");
        return Result.success(treeList);
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增部门", type = OPERATE_LOG)
    public Result add(@RequestBody SysDept dept) {
        log.info("新增部门，body参数dept：[ {} ]", dept);
        sysDeptService.add(dept);
        log.info("新增部门成功");
        return Result.success();
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除部门", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除部门，param参数id：[ {} ]", id);
        sysDeptService.delete(id);
        log.info("删除部门成功");
        return Result.success();
    }

    /**
     * 更新部门
     * @param dept
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新部门", type = OPERATE_LOG)
    public Result update(@RequestBody SysDept dept) {
        log.info("更新部门，body参数dept：[ {} ]", dept);
        sysDeptService.update(dept);
        log.info("更新部门成功");
        return Result.success();
    }

}
