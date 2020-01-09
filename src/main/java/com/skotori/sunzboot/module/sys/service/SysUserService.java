package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysRole;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 管理员service
 * @author skotori
 * @date 2019/11/06 20:36
 */
@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    public PageInfo<SysUser> pageList(Integer pageNum, Integer pageSize, SysUser user) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> userList = sysUserMapper.selectUserList(user);
        for (SysUser userItem: userList) {
            List<SysRole> roleList = sysRoleMapper.selectRolesByUserId(userItem.getId());
            userItem.setRoles(roleList);
        }
        return new PageInfo<>(userList);
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    public SysUser userInfoById(Integer id) {
        SysUser user = sysUserMapper.selectUserById(id);
        List<SysRole> roles = sysRoleMapper.selectRolesByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }

    /**
     * 重复账号检查
     * @param account
     * @return
     */
    public Integer accountCheck(String account) {
        SysUser user = sysUserMapper.selectUserByAccount(account);
        if (user != null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    public Integer add(SysUser user) {
        user.setSalt(ShiroUtil.getRandomSalt());
        String password = ShiroUtil.md5(user.getPassword(), user.getCredentialsSalt());
        user.setPassword(password);
        user.setCreateTime(new Date());
        user.setCreateUser(ShiroUtil.getAccount());
        Integer i = sysUserMapper.insertUser(user);
        if (i == 1) {
            SysUser sysUser = sysUserMapper.selectUserByAccount(user.getAccount());
            List<SysRole> roles = user.getRoles();
            List<Integer> roleIds = new ArrayList<>();
            for (SysRole role: roles) {
                roleIds.add(role.getId());
            }
            sysUserMapper.insertUserRole(sysUser.getId(), roleIds);
        }
        return i;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysUserMapper.deleteUserById(id);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public Integer update(SysUser user) {
        user.setUpdateUser(ShiroUtil.getAccount());
        Integer i = sysUserMapper.updateUser(user);
        if (i == 1) {
            List<SysRole> roles = user.getRoles();
            List<Integer> roleIds = new ArrayList<>();
            for (SysRole role: roles) {
                roleIds.add(role.getId());
            }
            sysUserMapper.deleteUserRole(user.getId());
            sysUserMapper.insertUserRole(user.getId(), roleIds);
        }
        return i;
    }

}
