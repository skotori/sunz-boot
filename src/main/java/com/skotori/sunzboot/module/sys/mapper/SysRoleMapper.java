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
     * 通过管理员id查询角色id列表
     * @param userId
     * @return
     */
    List<Integer> selectRoleIdsByUserId(Integer userId);

}
