package com.skotori.sunzboot.common.shiro;

import com.skotori.sunzboot.module.sys.mapper.SysPowerMapper;
import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro所需要的数据接口
 * @author skotori
 * @date 2019-11-15 14:36
 */
@Service
@Transactional(readOnly = true)
public class ShiroFactory {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysPowerMapper sysPowerMapper;

    public SysUser getUser(String account) {
        return sysUserMapper.selectUserByAccount(account);
    }

    public ShiroUser getShiroUser(SysUser user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setName(user.getName());
        shiroUser.setDeptId(user.getDeptId());
        shiroUser.setRoleIds(sysRoleMapper.selectRoleIdsByUserId(user.getId()));
        return shiroUser;
    }

    public Set<String> getPowerIdSetByRoleIds(List<Integer> roleIds) {
        List<Integer> powerIds = sysPowerMapper.selectPowerIdsByRoleIds(roleIds);
        Set<String> powerIdSet = new HashSet<>();
        for (Integer powerId: powerIds) {
            powerIdSet.add(String.valueOf(powerId));
        }
        return powerIdSet;
    }

}
