package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.tree.treeNode.DeptTreeNode;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.mapper.SysDeptMapper;
import com.skotori.sunzboot.module.sys.entity.SysDept;
import com.skotori.sunzboot.common.tree.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统部门service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    public List<SysDept> queryList(SysDept dept) {
        return sysDeptMapper.selectList(dept);
    }

    /**
     * 分页查询部门列表
     * @param pageNum
     * @param pageSize
     * @param dept
     * @return
     */
    public PageInfo<SysDept> pageList(Integer pageNum, Integer pageSize, SysDept dept) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysDept> deptList = sysDeptMapper.selectList(dept);
        return new PageInfo<>(deptList);
    }

    /**
     * 查询树型部门列表
     * @param dept
     * @return
     */
    public List<DeptTreeNode> treeList(SysDept dept) {
        List<DeptTreeNode> nodeList = sysDeptMapper.selectNodeList(dept);
        TreeUtil<DeptTreeNode> treeUtil = new TreeUtil<>();
        return treeUtil.listToTree(nodeList);
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public Integer add(SysDept dept) {
        dept.setCreateTime(new Date());
        dept.setCreateUser(HttpUtil.getAccount());
        return sysDeptMapper.insert(dept);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysDeptMapper.delete(id);
    }

    /**
     * 更新部门
     * @param dept
     * @return
     */
    public Integer update(SysDept dept) {
        dept.setUpdateUser(HttpUtil.getAccount());
        return sysDeptMapper.update(dept);
    }

}
