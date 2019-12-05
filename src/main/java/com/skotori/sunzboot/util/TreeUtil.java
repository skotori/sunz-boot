package com.skotori.sunzboot.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形工具类
 * @author skotori
 * @date 2019-12-05 16:21
 */
public class TreeUtil {

    /**
     * list转tree
     * @param list
     * @return
     */
    public static List<TreeNode> listToTree(List<TreeNode> list) {
        List<TreeNode> tree = new ArrayList<>();
        for (TreeNode node: list) {
            if (node.getPid().equals(0)) {
                tree.add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 使用递归法查找子节点
     * @param node
     * @param list
     * @return
     */
    private static TreeNode findChildren(TreeNode node, List<TreeNode> list) {
        for (TreeNode childrenNode: list) {
            if (childrenNode.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChildren(childrenNode, list));
            }
        }
        return node;
    }

}
