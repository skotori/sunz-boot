package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色mapper
 * @author skotori
 * @date 2019/11/06 20:38
 */
@Mapper
public interface SysRoleMapper {

    /**
     * 通过管理员id查询角色列表
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Integer userId);

    /**
     * 查询角色列表
     * @param role
     * @return
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 新增角色
     * @param role
     * @return
     */
    Integer insertRole(SysRole role);

    /**
     * 通过角色id删除角色
     * @param id
     * @return
     */
    Integer deleteRoleById(Integer id);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Integer updateRole(SysRole role);

}
