package com.skotori.sunzboot.module.sys.mapper;

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
     * 通过角色id查询权限id列表
     * @param roleId
     * @return
     */
    List<Integer> selectPowerIdsByRoleId(Integer roleId);

    /**
     * 通过角色id列表查询权限id列表
     * @param roleIds
     * @return
     */
    List<Integer> selectPowerIdsByRoleIds(List<Integer> roleIds);

}
