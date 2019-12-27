package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.tree.treeNode.DictTreeNode;
import com.skotori.sunzboot.module.sys.model.SysDict;
import com.skotori.sunzboot.module.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典控制器
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {

    private Logger log = LoggerFactory.getLogger(SysDictController.class);

    @Autowired
    private SysDictService sysDictService;

    /**
     * 分页查询字典列表
     * @param pageNum
     * @param pageSize
     * @param dict
     * @return
     */
    @PostMapping("pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysDict dict) {
        log.info("分页查询字典列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数dict：[ {} ]", pageNum, pageSize, dict);
        try {
            PageInfo<SysDict> pageInfo = sysDictService.pageList(pageNum, pageSize, dict);
            log.info("分页查询字典列表成功");
            return Result.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询字典列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询字典列表
     * @param dict
     * @return
     */
    @PostMapping("list")
    public Result list(@RequestBody SysDict dict) {
        log.info("查询字典列表，body参数dict：[ {} ]", dict);
        try {
            List<SysDict> dictList = sysDictService.list(dict);
            log.info("查询字典列表成功");
            return Result.success(dictList);
        } catch (Exception e) {
            log.error("查询字典列表异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询字典树形
     * @param dict
     * @return
     */
    @PostMapping("treeList")
    public Result treeList(@RequestBody SysDict dict) {
        log.info("查询字典表格树形，body参数dict：[ {} ]", dict);
        try {
            List<DictTreeNode> treeList = sysDictService.treeList(dict);
            log.info("查询字典表格树形成功");
            return Result.success(treeList);
        } catch (Exception e) {
            log.error("查询字典表格树形异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SysDict dict) {
        log.info("新增字典，body参数dict：[ {} ]", dict);
        try {
            sysDictService.add(dict);
            log.info("新增字典成功");
            return Result.success();
        } catch (Exception e) {
            log.error("新增字典异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除字典
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除字典，param参数id：[ {} ]", id);
        try {
            sysDictService.delete(id);
            log.info("删除字典成功");
            return Result.success();
        } catch (Exception e) {
            log.error("删除字典异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 更新字典
     * @param dict
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SysDict dict) {
        log.info("更新字典，body参数dict：[ {} ]", dict);
        try {
            sysDictService.update(dict);
            log.info("更新字典成功");
            return Result.success();
        } catch (Exception e) {
            log.error("更新字典异常：[ {} ]", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

}
