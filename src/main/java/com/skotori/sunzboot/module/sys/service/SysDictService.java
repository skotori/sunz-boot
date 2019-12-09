package com.skotori.sunzboot.module.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.dto.DictTreeNode;
import com.skotori.sunzboot.module.sys.mapper.SysDictMapper;
import com.skotori.sunzboot.module.sys.model.SysDict;
import com.skotori.sunzboot.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字典service
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
        List<SysDict> dictList = sysDictMapper.selectDictList(dict);
        return new PageInfo<>(dictList);
    }

    /**
     * 查询字典列表
     * @param dict
     * @return
     */
    public List<SysDict> list(SysDict dict) {
        return sysDictMapper.selectDictList(dict);
    }

    /**
     * 查询字典表格树形
     * @param dict
     * @return
     */
    public List<DictTreeNode> treeList(SysDict dict) {
        List<DictTreeNode> nodeList = sysDictMapper.selectNodeList(dict);
        List<DictTreeNode> tree = new ArrayList<>();
        for (DictTreeNode node: nodeList) {
            if (node.getPid().equals(0)) {
                tree.add(node);
            }
            for (DictTreeNode node2: nodeList) {
                if (node2.getPid().equals(node.getId())) {
                    if (node.getChildren() == null) {
                        node.setChildren(new ArrayList<>());
                    }
                    node.getChildren().add(node2);
                }
            }
        }
        return tree;
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
    public Integer add(SysDict dict) {
        dict.setCreateTime(new Date());
        dict.setCreateUser(ShiroUtil.getAccount());
        return sysDictMapper.insertDict(dict);
    }

    /**
     * 删除字典
     * @param id
     * @return
     */
    public Integer delete(Integer id) {
        return sysDictMapper.deleteDictById(id);
    }

    /**
     * 更新字典
     * @param dict
     * @return
     */
    public Integer update(SysDict dict) {
        dict.setUpdateUser(ShiroUtil.getAccount());
        return sysDictMapper.updateDict(dict);
    }

}
