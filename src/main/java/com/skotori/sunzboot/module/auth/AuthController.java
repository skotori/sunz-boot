package com.skotori.sunzboot.module.auth;

import com.skotori.sunzboot.common.jwt.JWTToken;
import com.skotori.sunzboot.common.jwt.JWTUtil;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.result.ResultCodeEnum;
import com.skotori.sunzboot.module.auth.dto.AuthRequest;
import com.skotori.sunzboot.module.auth.dto.AuthResponse;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员认证控制器
 * @author skotori
 * @date 2019-11-08 15:57
 */
@RestController
@RequestMapping("")
public class AuthController {

    @Resource
    private SysUserMapper sysUserMapper;

    @PostMapping("auth")
    public Result auth(@RequestBody AuthRequest authRequest) {
        if (authRequest == null ||
            authRequest.getAccount() == null || "".equals(authRequest.getAccount()) ||
            authRequest.getPassword() == null || "".equals(authRequest.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_NOT_COMPLETE);
        }
        SysUser user = sysUserMapper.selectUserByAccount(authRequest.getAccount());
        if (user == null) {
            return Result.error(ResultCodeEnum.USER_NOT_EXIST);
        } else if (user.getStatus() == 2) {
            return Result.error(ResultCodeEnum.USER_ACCOUNT_FORBIDDEN);
        } else if (user.getStatus() == 3) {
            return Result.error(ResultCodeEnum.USER_NOT_EXIST);
        }
        if (!authRequest.getPassword().equals(user.getPassword())) {
            return Result.error(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        // 生成Token
        String token = JWTUtil.sign(authRequest.getAccount(), authRequest.getPassword());
        JWTToken jwtToken = new JWTToken(token);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUser(user);
        authResponse.setToken(jwtToken);
        return Result.success(authResponse);
    }

}
