package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员mapper
 * @author skotori
 * @date 2019/11/06 20:37
 */
@Mapper
public interface SysUserMapper {

    /**
     * 通过账号查询管理员
     * @param account
     * @return
     */
    SysUser selectUserByAccount(String account);

}
