package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限mapper
 * @author skotori
 * @date 2019/11/06 20:38
 */
@Mapper
public interface SysPermissionMapper {

    /**
     * 通过角色id数组查询权限数组
     * @param roleIds
     * @return
     */
    List<SysPermission> selectPermissionListByRoleIds(List<Integer> roleIds);

}
