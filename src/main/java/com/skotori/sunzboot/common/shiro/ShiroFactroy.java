package com.skotori.sunzboot.common.shiro;

import com.skotori.sunzboot.module.sys.mapper.SysDeptMapper;
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
 * 自定义shiro所需要的数据接口
 * @author skotori
 * @date 2019-11-15 14:36
 */
@Service
@Transactional(readOnly = true)
public class ShiroFactroy {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysPowerMapper sysPowerMapper;

    @Resource
    private SysDeptMapper sysDeptMapper;

    public ShiroUser getShiroUser(String account) {
        SysUser user = sysUserMapper.selectUserByAccount(account);
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setPassword(user.getPassword());
        shiroUser.setCredentialsSalt(user.getCredentialsSalt());
        shiroUser.setName(user.getName());
        shiroUser.setStatus(user.getStatus());
        shiroUser.setDeptId(user.getDeptId());
        List<Integer> roleIds = sysRoleMapper.selectRoleIdsByUserId(user.getId());
        shiroUser.setRoleIds(roleIds);
        return shiroUser;
    }

    public Set<String> findRoleIdSetByUserId(Integer userId) {
        List<Integer> roleIds = sysRoleMapper.selectRoleIdsByUserId(userId);
        Set<String> roleIdSet = new HashSet<>();
        for (Integer roleId: roleIds) {
            roleIdSet.add(String.valueOf(roleId));
        }
        return roleIdSet;
    }

    public Set<String> findPowerIdSetByRoleIds(List<Integer> roleIds) {
        List<Integer> powerIds = sysPowerMapper.selectPowerIdsByRoleIds(roleIds);
        Set<String> powerIdSet = new HashSet<>();
        for (Integer powerId: powerIds) {
            powerIdSet.add(String.valueOf(powerId));
        }
        return powerIdSet;
    }

    public List<Integer> findSonDeptIdsByDeptId(Integer deptId) {
        return sysDeptMapper.selectSidsById(deptId);
    }

}
