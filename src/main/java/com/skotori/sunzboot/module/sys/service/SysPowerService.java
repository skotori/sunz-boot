package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PowerTreeNode;
import com.skotori.sunzboot.module.sys.mapper.SysPowerMapper;
import com.skotori.sunzboot.module.sys.model.SysPower;
import com.skotori.sunzboot.common.tree.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 权限service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysPowerService {

    @Resource
    private SysPowerMapper sysPowerMapper;

    /**
     * 查询菜单树形
     * @return
     */
    public List<MenuTreeNode> menuTree() {
        List<MenuTreeNode> nodeList = sysPowerMapper.selectMenuNodeList(ShiroUtil.getAccount());
        return TreeUtil.menuListToTree(nodeList);
    }

    /**
     * 分页查询权限列表
     * @param pageNum
     * @param pageSize
     * @param power
     * @return
     */
    public PageInfo<SysPower> pageList(Integer pageNum, Integer pageSize, SysPower power) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysPower> powerList = sysPowerMapper.selectPowerList(power);
        return new PageInfo<>(powerList);
    }

    /**
     * 查询权限列表
     * @param power
     * @return
     */
    public List<SysPower> list(SysPower power) {
        return sysPowerMapper.selectPowerList(power);
    }

    /**
     * 查询权限树形
     * @param power
     * @return
     */
    public List<PowerTreeNode> powerTree(SysPower power) {
        List<PowerTreeNode> nodeList = sysPowerMapper.selectPowerNodeList(power);
        return TreeUtil.powerListToTree(nodeList);
    }

    /**
     * 新增权限
     * @param power
     * @return
     */
    public Integer add(SysPower power) {
        power.setCreateTime(new Date());
        power.setCreateUser(ShiroUtil.getAccount());
        return sysPowerMapper.insertPower(power);
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysPowerMapper.deletePowerById(id);
    }

    /**
     * 更新权限
     * @param power
     * @return
     */
    public Integer update(SysPower power) {
        power.setUpdateUser(ShiroUtil.getAccount());
        return sysPowerMapper.updatePower(power);
    }

}
