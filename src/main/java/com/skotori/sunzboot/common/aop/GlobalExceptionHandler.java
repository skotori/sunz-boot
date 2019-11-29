package com.skotori.sunzboot.common.aop;

import com.skotori.sunzboot.common.result.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理
 * @author skotori
 * @date 2019-11-29 09:24
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleException(Exception e) {
        log.error("服务器内部异常：[ {} ]", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 统一处理请求参数(对象传参)
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result validExceptionHandler(BindException e) {
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            msg.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        msg = new StringBuilder(msg.substring(0, msg.length() - 1));
        return Result.error(String.valueOf(msg));

    }

    /**
     * 统一处理请求参数(普通传参)
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = String.valueOf(path).split("\\.");
            msg.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        msg = new StringBuilder(msg.substring(0, msg.length() - 1));
        return Result.error(String.valueOf(msg));
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleUnauthorizedException(Exception e) {
        log.error("权限不足：[ {} ]", e.getMessage());
        return Result.error(e.getMessage());
    }

}
