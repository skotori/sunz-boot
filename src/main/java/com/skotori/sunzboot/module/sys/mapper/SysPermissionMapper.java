package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PermissionTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统权限mapper
 * @author skotori
 * @date 2019/11/06 20:38
 */
@Mapper
public interface SysPermissionMapper {

    /**
     * 通过角色id列表查询权限列表
     * @param roleIds
     * @return
     */
    List<SysPermission> selectPermissionsByRoleIds(List<Integer> roleIds);


    /**
     * 查询树型菜单列表
     * @param account
     * @return
     */
    List<MenuTreeNode> selectMenuNodeList(String account);

    /**
     * 查询权限列表
     * @param permission
     * @return
     */
    List<SysPermission> selectList(SysPermission permission);

    /**
     * 查询树型权限列表
     * @param permission
     * @return
     */
    List<PermissionTreeNode> selectNodeList(SysPermission permission);

    /**
     * 新增权限
     * @param permission
     * @return
     */
    Integer insert(SysPermission permission);

    /**
     * 删除权限
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新权限
     * @param permission
     * @return
     */
    Integer update(SysPermission permission);

}
