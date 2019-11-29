package com.skotori.sunzboot.module.sys.mapper;

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

}
