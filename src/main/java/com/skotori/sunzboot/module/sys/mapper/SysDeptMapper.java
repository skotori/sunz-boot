package com.skotori.sunzboot.module.sys.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门mapper
 * @author skotori
 * @date 2019-11-15 11:49
 */
@Mapper
public interface SysDeptMapper {

    /**
     * 通过部门id查询子部门id列表
     * @param id
     * @return
     */
    List<Integer> selectSidsById(Integer id);

}
