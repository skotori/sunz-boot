package com.skotori.sunzboot.module.auth.controller;

import com.skotori.sunzboot.common.jwt.JWTUtil;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.result.ResultCodeEnum;
import com.skotori.sunzboot.Util.ShiroUtil;
import com.skotori.sunzboot.module.auth.dto.AuthRequest;
import com.skotori.sunzboot.module.auth.dto.AuthResponse;
import com.skotori.sunzboot.module.sys.mapper.SysUserMapper;
import com.skotori.sunzboot.module.sys.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 管理员登录
     * @param authRequest
     * @return
     */
    @PostMapping("auth")
    public Result auth(@RequestBody AuthRequest authRequest) {
        log.info("管理员登录，请求body：[ {} ]", authRequest);
        try {
            if (authRequest == null ||
                    authRequest.getAccount() == null || "".equals(authRequest.getAccount()) ||
                    authRequest.getPassword() == null || "".equals(authRequest.getPassword())) {
                log.info("请求参数缺失，登录失败");
                return Result.error(ResultCodeEnum.PARAM_NOT_COMPLETE);
            }
            SysUser user = sysUserMapper.selectUserByAccount(authRequest.getAccount());
            if (user == null) {
                log.info("用户不存在，登录失败");
                return Result.error(ResultCodeEnum.USER_NOT_EXIST);
            } else if (user.getStatus() == 2) {
                log.info("用户已禁用，登录失败");
                return Result.error(ResultCodeEnum.USER_ACCOUNT_FORBIDDEN);
            } else if (user.getStatus() == 3) {
                log.info("用户已删除，登录失败");
                return Result.error(ResultCodeEnum.USER_ACCOUNT_DELETE);
            }
            String password = ShiroUtil.md5(authRequest.getPassword(), user.getCredentialsSalt());
            if (!password.equals(user.getPassword())) {
                log.info("账号或密码错误，登录失败");
                return Result.error(ResultCodeEnum.USER_LOGIN_ERROR);
            }
            String token = JWTUtil.sign(authRequest.getAccount(), password);
            AuthResponse authResponse = new AuthResponse(user, token);
            log.info("用户[ {} ]登录成功，生成TOKEN[ {} ]", authRequest.getAccount(), token);
            return Result.success(authResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error();
        }
    }

}
