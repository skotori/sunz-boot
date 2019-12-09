package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 通知mapper
 * @author skotori
 * @date 2019-12-04 09:46
 */
@Mapper
public interface SysNoticeMapper {

    /**
     * 查询通知列表
     * @param notice
     * @return
     */
    List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增通知
     * @param notice
     * @return
     */
    Integer insertNotice(SysNotice notice);

    /**
     * 通过通知id删除通知
     * @param id
     * @return
     */
    Integer deleteNoticeById(Integer id);

    /**
     * 更新通知
     * @param notice
     * @return
     */
    Integer updateNotice(SysNotice notice);

}
