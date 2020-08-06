package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.tree.TreeUtil;
import com.skotori.sunzboot.common.tree.treeNode.DictTreeNode;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.mapper.SysDictMapper;
import com.skotori.sunzboot.module.sys.entity.SysDict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统字典service
 * @author skotori
 * @date 2019-12-04 10:37
 */
@Service
public class SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    /**
     * 分页查询字典列表
     * @param pageNum
     * @param pageSize
     * @param dict
     * @return
     */
    public PageInfo<SysDict> pageList(Integer pageNum, Integer pageSize, SysDict dict) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysDict> dictList = sysDictMapper.selectList(dict);
        return new PageInfo<>(dictList);
    }

    /**
     * 查询树型字典列表
     * @param dict
     * @return
     */
    public List<DictTreeNode> treeList(SysDict dict) {
        List<DictTreeNode> nodeList = sysDictMapper.selectNodeList(dict);
        TreeUtil<DictTreeNode> treeUtil = new TreeUtil<>();
        return treeUtil.listToTree(nodeList);
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
    public Integer add(SysDict dict) {
        dict.setCreateTime(new Date());
        dict.setCreateUser(HttpUtil.getAccount());
        return sysDictMapper.insert(dict);
    }

    /**
     * 删除字典
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysDictMapper.delete(id);
    }

    /**
     * 更新字典
     * @param dict
     * @return
     */
    public Integer update(SysDict dict) {
        dict.setUpdateUser(HttpUtil.getAccount());
        return sysDictMapper.update(dict);
    }

}
