package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PowerTreeNode;
import com.skotori.sunzboot.module.sys.model.SysPower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限mapper
 * @author skotori
 * @date 2019/11/06 20:38
 */
@Mapper
public interface SysPowerMapper {

    /**
     * 通过角色id列表查询权限列表
     * @param roleIds
     * @return
     */
    List<SysPower> selectPowersByRoleIds(List<Integer> roleIds);

    /**
     * 通过账号查询菜单树形节点列表
     * @param account
     * @return
     */
    List<MenuTreeNode> selectMenuNodeList(String account);

    /**
     * 查询权限列表
     * @param power
     * @return
     */
    List<SysPower> selectPowerList(SysPower power);

    /**
     * 查询权限树形节点列表
     * @param power
     * @return
     */
    List<PowerTreeNode> selectPowerNodeList(SysPower power);

    /**
     * 新增权限
     * @param power
     * @return
     */
    Integer insertPower(SysPower power);

    /**
     * 通过权限id删除权限
     * @param id
     * @return
     */
    Integer deletePowerById(Integer id);

    /**
     * 更新权限
     * @param power
     * @return
     */
    Integer updatePower(SysPower power);

}
