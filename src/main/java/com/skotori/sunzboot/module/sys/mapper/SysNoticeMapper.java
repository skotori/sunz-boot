package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.entity.SysNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统通知mapper
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
    List<SysNotice> selectList(SysNotice notice);

    /**
     * 新增通知
     * @param notice
     * @return
     */
    Integer insert(SysNotice notice);

    /**
     * 删除通知
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新通知
     * @param notice
     * @return
     */
    Integer update(SysNotice notice);

}
