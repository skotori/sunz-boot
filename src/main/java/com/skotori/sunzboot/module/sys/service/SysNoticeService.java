package com.skotori.sunzboot.module.sys.service;

import com.skotori.sunzboot.module.sys.mapper.SysNoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 通知service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysNoticeService {

    @Resource
    private SysNoticeMapper sysNoticeMapper;

}
