package com.skotori.sunzboot.common.tree;

import com.skotori.sunzboot.common.tree.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形工具类
 * @author skotori
 * @date 2019-12-05 16:21
 */
public class TreeUtil<T extends TreeNode> {

    /**
     * 权限nodeList转treeList
     * @param nodeList
     * @return
     */
    public List<T> listToTree(List<T> nodeList) {
        List<T> treeList = new ArrayList<>();
        for (T node: nodeList) {
            if (node.getParentId().equals(0)) {
                treeList.add(findChildren(node, nodeList));
            }
        }
        return treeList;
    }

    /**
     * 使用递归法查找权限子节点
     * @param node
     * @param nodeList
     * @return
     */
    private T findChildren(T node, List<T> nodeList) {
        for (T childrenNode: nodeList) {
            if (childrenNode.getParentId().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChildren(childrenNode, nodeList));
            }
        }
        return node;
    }

}
