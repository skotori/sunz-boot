package com.skotori.sunzboot.common.shiro;

import com.skotori.sunzboot.module.sys.mapper.SysDeptMapper;
import com.skotori.sunzboot.module.sys.mapper.SysPowerMapper;
import com.skotori.sunzboot.module.sys.mapper.SysRoleMapper;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysDept;
import com.skotori.sunzboot.module.sys.model.SysPower;
import com.skotori.sunzboot.module.sys.model.SysRole;
import com.skotori.sunzboot.module.sys.model.SysUser;
import com.skotori.sunzboot.util.SpringContextUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * shiro所需要的数据接口
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
    private SysPowerMapper sysPowerMapper;

    @Resource
    private SysDeptMapper sysDeptMapper;

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
        shiroUser.setDeptId(user.getDeptId());
        SysDept dept = sysDeptMapper.selectDeptById(user.getDeptId());
        shiroUser.setDeptName(dept.getName());
        List<SysRole> roles = sysRoleMapper.selectRolesByUserId(user.getId());
        List<String> roleCodes = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();
        for (SysRole role: roles) {
            roleCodes.add(role.getCode());
            roleIds.add(role.getId());
        }
        shiroUser.setRoleCodes(roleCodes);
        List<SysPower> powers = sysPowerMapper.selectPowersByRoleIds(roleIds);
        List<String> powerCodes = new ArrayList<>();
        for (SysPower power: powers) {
            powerCodes.add(power.getCode());
        }
        shiroUser.setPowerCodes(powerCodes);
        return shiroUser;
    }

}
