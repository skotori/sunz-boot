package com.skotori.sunzboot.module.sys.mapper;

import com.skotori.sunzboot.module.sys.dto.DictTreeNode;
import com.skotori.sunzboot.module.sys.model.SysDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典mapper
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
    List<SysDict> selectDictList(SysDict dict);

    /**
     * 查询字典表格树形节点列表
     * @param dict
     * @return
     */
    List<DictTreeNode> selectNodeList(SysDict dict);

    /**
     * 新增字典
     * @param dict
     * @return
     */
    Integer insertDict(SysDict dict);

    /**
     * 通过字典id删除字典
     * @param id
     * @return
     */
    Integer deleteDictById(Integer id);

    /**
     * 更新字典
     * @param dict
     * @return
     */
    Integer updateDict(SysDict dict);

}
