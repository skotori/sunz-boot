package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.common.tree.treeNode.DictTreeNode;
import com.skotori.sunzboot.module.sys.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统字典mapper
 * @author skotori
 * @date 201-12-04 09:45
 */
@Mapper
public interface SysDictMapper {

    /**
     * 查询字典列表
     * @param dict
     * @return
     */
    List<SysDict> selectList(SysDict dict);

    /**
     * 查询树型字典列表
     * @param dict
     * @return
     */
    List<DictTreeNode> selectNodeList(SysDict dict);

    /**
     * 新增字典
     * @param dict
     * @return
     */
    Integer insert(SysDict dict);

    /**
     * 删除字典
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 更新字典
     * @param dict
     * @return
     */
    Integer update(SysDict dict);

}
