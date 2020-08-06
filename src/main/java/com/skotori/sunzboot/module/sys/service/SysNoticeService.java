package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.mapper.SysNoticeMapper;
import com.skotori.sunzboot.module.sys.entity.SysNotice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统通知service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysNoticeService {

    @Resource
    private SysNoticeMapper sysNoticeMapper;

    /**
     * 分页查询通知列表
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */
    public PageInfo<SysNotice> pageList(Integer pageNum, Integer pageSize, SysNotice notice) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysNotice> noticeList = sysNoticeMapper.selectList(notice);
        return new PageInfo<>(noticeList);
    }

    /**
     * 新增通知
     * @param notice
     * @return
     */
    public Integer add(SysNotice notice) {
        notice.setCreateTime(new Date());
        notice.setCreateUser(HttpUtil.getAccount());
        return sysNoticeMapper.insert(notice);
    }

    /**
     * 删除通知
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysNoticeMapper.delete(id);
    }

    /**
     * 更新通知
     * @param notice
     * @return
     */
    public Integer update(SysNotice notice) {
        notice.setUpdateUser(HttpUtil.getAccount());
        return sysNoticeMapper.update(notice);
    }

}
