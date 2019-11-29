package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.model.SysDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门mapper
 * @author skotori
 * @date 2019-11-15 11:49
 */
@Mapper
public interface SysDeptMapper {

    /**
     * 通过部门id查询部门信息
     * @param id
     * @return
     */
    SysDept selectDeptById(Integer id);

}
