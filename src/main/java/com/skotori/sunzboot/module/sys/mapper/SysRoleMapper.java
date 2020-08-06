package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统角色mapper
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
    List<SysRole> selectList(SysRole role);

    /**
     * 新增角色
     * @param role
     * @return
     */
    Integer insert(SysRole role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Integer update(SysRole role);

}
