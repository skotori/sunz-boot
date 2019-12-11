package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return new PageInfo<>(userList);
    }

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    public List<SysUser> list(SysUser user) {
        return sysUserMapper.selectUserList(user);
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
        return sysUserMapper.insertUser(user);
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
        return sysUserMapper.updateUser(user);
    }

}
