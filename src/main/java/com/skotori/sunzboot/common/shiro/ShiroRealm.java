package com.skotori.sunzboot.common.shiro;

import com.skotori.sunzboot.common.jwt.JWTToken;
import com.skotori.sunzboot.common.jwt.JWTUtil;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义ShiroRealm，包含认证和授权两大模块
 * @author skotori
 * @date 2019-11-07 17:21
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroFactory shiroFactory;

    /**
     * 必须重写此方法，不然ShiroRealm会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 用户授权
     * @param token
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
        // 从token中获取account
        String account = JWTUtil.getAccount(String.valueOf(token));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = shiroFactory.getUser(account);
        ShiroUser shiroUser = shiroFactory.getShiroUser(user);

        // 获取用户角色集
        Set<String> roleIdSet = new HashSet<>();
        for (Integer roleId: shiroUser.getRoleIds()) {
            roleIdSet.add(String.valueOf(roleId));
        }
        simpleAuthorizationInfo.setRoles(roleIdSet);

        // 获取用户权限集
        Set<String> powerIdSet = shiroFactory.getPowerIdSetByRoleIds(shiroUser.getRoleIds());
        simpleAuthorizationInfo.setStringPermissions(powerIdSet);

        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从JWTFilter的executeLogin的getSubject.login传递过来的jwtToken中获取token
        String token = ((JWTToken) authenticationToken).getToken();

        // 从token中获取account
        String account = JWTUtil.getAccount(token);
        if (account == null) {
            throw new AuthenticationException("从token中获取account失败");
        }

        // 通过账户查询用户信息
        SysUser user = shiroFactory.getUser(account);
        if (user == null) {
            throw new AuthenticationException("账户不存在");
        } else if (user.getStatus() == 2) {
            throw new AuthenticationException("账户已禁用");
        } else if (user.getStatus() == 3) {
            throw new AuthenticationException("账户已删除");
        }

        // 校验token
        if (!JWTUtil.verify(token, account, user.getPassword())) {
            throw new AuthenticationException("校验token失败");
        }

        return new SimpleAuthenticationInfo(token, token, super.getName());
    }

}
