package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户mapper
 * @author skotori
 * @date 2019/11/06 20:37
 */
@Mapper
public interface SysUserMapper {

    /**
     * 通过账号查询用户信息
     * @param account
     * @return
     */
    SysUser selectUserByAccount(String account);


    /**
     * 查询用户列表
     * @param user
     * @return
     */
    List<SysUser> selectList(SysUser user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insert(SysUser user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Integer update(SysUser user);


    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    SysUser selectUserById(Integer id);

    /**
     * 新增用户权限关联
     * @param userId
     * @param roleIds
     * @return
     */
    Integer insertUserRole(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);

    /**
     * 删除用户权限关联
     * @param id
     * @return
     */
    Integer deleteUserRole(Integer id);

}
