package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.module.sys.mapper.SysLoginLogMapper;
import com.skotori.sunzboot.module.sys.model.SysLoginLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 分页查询登录日志列表
     * @param pageNum
     * @param pageSize
     * @param loginLog
     * @return
     */
    public PageInfo<SysLoginLog> pageList(Integer pageNum, Integer pageSize, SysLoginLog loginLog) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLoginLog> loginLogList = sysLoginLogMapper.selectLoginLogList(loginLog);
        return new PageInfo<>(loginLogList);
    }

    /**
     * 查询登录日志列表
     * @param loginLog
     * @return
     */
    public List<SysLoginLog> list(SysLoginLog loginLog) {
        return sysLoginLogMapper.selectLoginLogList(loginLog);
    }

}
