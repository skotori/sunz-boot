package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PermissionTreeNode;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.mapper.SysPermissionMapper;
import com.skotori.sunzboot.module.sys.entity.SysPermission;
import com.skotori.sunzboot.common.tree.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统权限service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 查询树型菜单列表
     * @return
     */
    public List<MenuTreeNode> menuTreeList() {
        List<MenuTreeNode> nodeList = sysPermissionMapper.selectMenuNodeList(HttpUtil.getAccount());
        TreeUtil<MenuTreeNode> treeUtil = new TreeUtil<>();
        return treeUtil.listToTree(nodeList);
    }


    /**
     * 分页查询权限列表
     * @param pageNum
     * @param pageSize
     * @param permission
     * @return
     */
    public PageInfo<SysPermission> pageList(Integer pageNum, Integer pageSize, SysPermission permission) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysPermission> powerList = sysPermissionMapper.selectList(permission);
        return new PageInfo<>(powerList);
    }

    /**
     * 查询树型权限列表
     * @param permission
     * @return
     */
    public List<PermissionTreeNode> treeList(SysPermission permission) {
        List<PermissionTreeNode> nodeList = sysPermissionMapper.selectNodeList(permission);
        TreeUtil<PermissionTreeNode> treeUtil = new TreeUtil<>();
        return treeUtil.listToTree(nodeList);
    }

    /**
     * 新增权限
     * @param permission
     * @return
     */
    public Integer add(SysPermission permission) {
        permission.setCreateTime(new Date());
        permission.setCreateUser(HttpUtil.getAccount());
        return sysPermissionMapper.insert(permission);
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysPermissionMapper.delete(id);
    }

    /**
     * 更新权限
     * @param permission
     * @return
     */
    public Integer update(SysPermission permission) {
        permission.setUpdateUser(HttpUtil.getAccount());
        return sysPermissionMapper.update(permission);
    }

}
