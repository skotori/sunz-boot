package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.entity.SysRole;
import com.skotori.sunzboot.module.sys.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统角色controller
 * @author skotori
 * @date 2019-12-04 10:48
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {

    private static final Logger log = LoggerFactory.getLogger(SysRoleController.class);

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param role
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询角色列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysRole role) {
        log.info("分页查询角色列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数role：[ {} ]", pageNum, pageSize, role);
        PageInfo<SysRole> pageInfo = sysRoleService.pageList(pageNum, pageSize, role);
        log.info("分页查询角色列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增角色", type = OPERATE_LOG)
    public Result add(@RequestBody SysRole role) {
        log.info("新增角色，body参数role：[ {} ]", role);
        sysRoleService.add(role);
        log.info("新增角色成功");
        return Result.success();
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除角色", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除角色，param参数id：[ {} ]", id);
        sysRoleService.delete(id);
        log.info("删除角色成功");
        return Result.success();
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新角色", type = OPERATE_LOG)
    public Result update(@RequestBody SysRole role) {
        log.info("更新角色，body参数role：[ {} ]", role);
        sysRoleService.update(role);
        log.info("更新角色成功");
        return Result.success();
    }

}
