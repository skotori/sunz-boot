package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.common.tree.treeNode.DeptTreeNode;
import com.skotori.sunzboot.module.sys.model.SysDept;
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
     * 查询部门列表
     * @param dept
     * @return
     */
    List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询部门树形节点列表
     * @param dept
     * @return
     */
    List<DeptTreeNode> selectNodeList(SysDept dept);

    /**
     * 新增部门
     * @param dept
     * @return
     */
    Integer insertDept(SysDept dept);

    /**
     * 通过部门id删除部门
     * @param id
     * @return
     */
    Integer deleteDeptById(Integer id);

    /**
     * 更新部门
     * @param dept
     * @return
     */
    Integer updateDept(SysDept dept);

}
