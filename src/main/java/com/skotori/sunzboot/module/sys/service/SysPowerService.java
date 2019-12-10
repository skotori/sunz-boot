package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.mapper.SysPowerMapper;
import com.skotori.sunzboot.module.sys.model.SysPower;
import com.skotori.sunzboot.util.TreeNode;
import com.skotori.sunzboot.util.TreeUtil;
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
     * 查询菜单列表
     * @return
     */
    public List<SysPower> menuList() {
        return sysPowerMapper.selectMenuList(ShiroUtil.getAccount());
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
    public List<TreeNode> treeList(SysPower power) {
        List<TreeNode> nodeList = sysPowerMapper.selectNodeList(power);
        return TreeUtil.listToTree(nodeList);
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
