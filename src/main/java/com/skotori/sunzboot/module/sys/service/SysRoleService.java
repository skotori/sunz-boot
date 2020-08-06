package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import com.skotori.sunzboot.module.sys.entity.SysRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统角色service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param role
     * @return
     */
    public PageInfo<SysRole> pageList(Integer pageNum, Integer pageSize, SysRole role) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> roleList = sysRoleMapper.selectList(role);
        return new PageInfo<>(roleList);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    public Integer add(SysRole role) {
        role.setCreateTime(new Date());
        role.setCreateUser(HttpUtil.getAccount());
        return sysRoleMapper.insert(role);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysRoleMapper.delete(id);
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    public Integer update(SysRole role) {
        role.setUpdateUser(HttpUtil.getAccount());
        return sysRoleMapper.update(role);
    }

}
