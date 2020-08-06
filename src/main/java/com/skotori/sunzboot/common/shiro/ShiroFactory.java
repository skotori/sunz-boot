package com.skotori.sunzboot.common.shiro;

import com.skotori.sunzboot.module.sys.mapper.SysPermissionMapper;
import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.entity.SysPermission;
import com.skotori.sunzboot.module.sys.entity.SysRole;
import com.skotori.sunzboot.module.sys.entity.SysUser;
import com.skotori.sunzboot.common.utils.SpringContextUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * shiro工厂类
 * @author skotori
 * @date 2019-11-15 14:36
 */
@Service
@DependsOn("springContextUtil")
public class ShiroFactory {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    public static ShiroFactory getShiroFactory() {
        return SpringContextUtil.getBean(ShiroFactory.class);
    }

    public SysUser getUser(String account) {
        return sysUserMapper.selectUserByAccount(account);
    }

    public ShiroUser getShiroUser(SysUser user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setName(user.getName());
        shiroUser.setIcon(user.getIcon());
        shiroUser.setSex(user.getSex());
        shiroUser.setBirthday(user.getBirthday());
        shiroUser.setEmail(user.getEmail());
        shiroUser.setTell(user.getTell());
        shiroUser.setDeptId(user.getDeptId());
        shiroUser.setDeptName(user.getDeptName());
        List<SysRole> roles = sysRoleMapper.selectRolesByUserId(user.getId());
        List<String> roleCodes = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();
        for (SysRole role: roles) {
            roleCodes.add(role.getCode());
            roleIds.add(role.getId());
        }
        shiroUser.setRoleCodes(roleCodes);
        List<SysPermission> permissions = sysPermissionMapper.selectPermissionsByRoleIds(roleIds);
        List<String> permissionCodes = new ArrayList<>();
        for (SysPermission permission: permissions) {
            permissionCodes.add(permission.getCode());
        }
        shiroUser.setPermissionCodes(permissionCodes);
        return shiroUser;
    }

}
