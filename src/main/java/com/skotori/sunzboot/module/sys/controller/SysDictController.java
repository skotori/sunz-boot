package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.tree.treeNode.DictTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysDict;
import com.skotori.sunzboot.module.sys.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统字典controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {

    private static final Logger log = LoggerFactory.getLogger(SysDictController.class);

    @Resource
    private SysDictService sysDictService;

    /**
     * 分页查询字典列表
     * @param pageNum
     * @param pageSize
     * @param dict
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询字典列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysDict dict) {
        log.info("分页查询字典列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数dict：[ {} ]", pageNum, pageSize, dict);
        PageInfo<SysDict> pageInfo = sysDictService.pageList(pageNum, pageSize, dict);
        log.info("分页查询字典列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 查询树型字典列表
     * @param dict
     * @return
     */
    @PostMapping("treeList")
    @Log(msg = "查询树型字典列表", type = OPERATE_LOG)
    public Result treeList(@RequestBody SysDict dict) {
        log.info("查询树型字典列表，body参数dict：[ {} ]", dict);
        List<DictTreeNode> treeList = sysDictService.treeList(dict);
        log.info("查询树型字典列表成功");
        return Result.success(treeList);
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增字典", type = OPERATE_LOG)
    public Result add(@RequestBody SysDict dict) {
        log.info("新增字典，body参数dict：[ {} ]", dict);
        sysDictService.add(dict);
        log.info("新增字典成功");
        return Result.success();
    }

    /**
     * 删除字典
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除字典", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除字典，param参数id：[ {} ]", id);
        sysDictService.delete(id);
        log.info("删除字典成功");
        return Result.success();
    }

    /**
     * 更新字典
     * @param dict
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新字典", type = OPERATE_LOG)
    public Result update(@RequestBody SysDict dict) {
        log.info("更新字典，body参数dict：[ {} ]", dict);
        sysDictService.update(dict);
        log.info("更新字典成功");
        return Result.success();
    }

}
