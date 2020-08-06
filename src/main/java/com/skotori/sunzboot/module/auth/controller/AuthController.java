package com.skotori.sunzboot.module.auth.controller;

import com.skotori.sunzboot.common.jwt.JWTUtil;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.shiro.ShiroFactory;
import com.skotori.sunzboot.common.shiro.ShiroUser;
import com.skotori.sunzboot.common.utils.Md5Util;
import com.skotori.sunzboot.module.auth.dto.AuthRequest;
import com.skotori.sunzboot.module.auth.dto.AuthResponse;
import com.skotori.sunzboot.module.sys.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.skotori.sunzboot.common.log.LogTypeEnum.LOGIN_LOG;
import static com.skotori.sunzboot.common.result.ResultEnum.*;

/**
 * 系统用户认证controller
 * @author skotori
 * @date 2019-11-08 15:57
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final ShiroFactory shiroFactory = ShiroFactory.getShiroFactory();

    /**
     * 管理员登录
     * @param authRequest
     * @return
     */
    @PostMapping("")
    @Log(msg = "管理员登录", type = LOGIN_LOG)
    public Result auth(@RequestBody AuthRequest authRequest) {
        log.info("管理员登录，请求body：[ {} ]", authRequest);
        if (authRequest == null ||
                authRequest.getAccount() == null || "".equals(authRequest.getAccount()) ||
                authRequest.getPassword() == null || "".equals(authRequest.getPassword())) {
            log.error("请求参数缺失，登录失败");
            return Result.error(PARAM_NOT_COMPLETE);
        }

        SysUser user = shiroFactory.getUser(authRequest.getAccount());
        if (user == null) {
            log.error("用户不存在，登录失败");
            return Result.error(USER_NOT_EXIST);
        } else if (user.getDisabledState() == 1) {
            log.error("用户已禁用，登录失败");
            return Result.error(USER_ACCOUNT_FORBIDDEN);
        } else if (user.getDeletedState() == 1) {
            log.error("用户已删除，登录失败");
            return Result.error(USER_ACCOUNT_DELETE);
        }

        String password = Md5Util.md5(authRequest.getPassword(), user.getCredentialsSalt());
        if (!password.equals(user.getPassword())) {
            log.error("账号或密码错误，登录失败");
            return Result.error(USER_LOGIN_ERROR);
        }

        String token = JWTUtil.sign(authRequest.getAccount(), password);
        ShiroUser shiroUser = shiroFactory.getShiroUser(user);
        AuthResponse authResponse = new AuthResponse(shiroUser, token);
        log.info("用户[ {} ]登录成功，生成TOKEN[ {} ]", authRequest.getAccount(), token);
        return Result.success(authResponse);
    }

}
