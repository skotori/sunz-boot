package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.mapper.SysDeptMapper;
import com.skotori.sunzboot.module.sys.model.SysDept;
import com.skotori.sunzboot.util.TreeNode;
import com.skotori.sunzboot.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 部门service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 分页查询部门列表
     * @param pageNum
     * @param pageSize
     * @param dept
     * @return
     */
    public PageInfo<SysDept> pageList(Integer pageNum, Integer pageSize, SysDept dept) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysDept> deptList = sysDeptMapper.selectDeptList(dept);
        return new PageInfo<>(deptList);
    }

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    public List<SysDept> list(SysDept dept) {
        return sysDeptMapper.selectDeptList(dept);
    }

    /**
     * 查询部门树形
     * @param dept
     * @return
     */
    public List<TreeNode> treeList(SysDept dept) {
        List<TreeNode> nodeList = sysDeptMapper.selectNodeList(dept);
        return TreeUtil.listToTree(nodeList);
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    public Integer add(SysDept dept) {
        dept.setCreateTime(new Date());
        dept.setCreateUser(ShiroUtil.getAccount());
        return sysDeptMapper.insertDept(dept);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysDeptMapper.deleteDeptById(id);
    }

    /**
     * 更新部门
     * @param dept
     * @return
     */
    public Integer update(SysDept dept) {
        dept.setUpdateUser(ShiroUtil.getAccount());
        return sysDeptMapper.updateDept(dept);
    }

}
