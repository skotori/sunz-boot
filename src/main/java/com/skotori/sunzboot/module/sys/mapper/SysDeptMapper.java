package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.common.tree.treeNode.DeptTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统部门mapper
 * @author skotori
 * @date 2019-11-15 11:49
 */
@Mapper
public interface SysDeptMapper {

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    List<SysDept> selectList(SysDept dept);

    /**
     * 查询树型部门列表
     * @param dept
     * @return
     */
    List<DeptTreeNode> selectNodeList(SysDept dept);

    /**
     * 新增部门
     * @param dept
     * @return
     */
    Integer insert(SysDept dept);

    /**
     * 删除部门
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新部门
     * @param dept
     * @return
     */
    Integer update(SysDept dept);

}
