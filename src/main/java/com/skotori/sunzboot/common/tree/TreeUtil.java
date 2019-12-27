package com.skotori.sunzboot.common.tree;

import com.skotori.sunzboot.common.tree.treeNode.DeptTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.DictTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.MenuTreeNode;
import com.skotori.sunzboot.common.tree.treeNode.PowerTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形工具类
 * @author skotori
 * @date 2019-12-05 16:21
 */
public class TreeUtil {

    /**
     * 菜单节点list转tree
     * @param list
     * @return
     */
    public static List<MenuTreeNode> menuListToTree(List<MenuTreeNode> list) {
        List<MenuTreeNode> tree = new ArrayList<>();
        for (MenuTreeNode node: list) {
            if (node.getPid().equals(0)) {
                tree.add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 使用递归法查找菜单子节点
     * @param node
     * @param list
     * @return
     */
    private static MenuTreeNode findChildren(MenuTreeNode node, List<MenuTreeNode> list) {
        for (MenuTreeNode childrenNode: list) {
            if (childrenNode.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChildren(childrenNode, list));
            }
        }
        return node;
    }

    /**
     * 部门节点list转tree
     * @param list
     * @return
     */
    public static List<DeptTreeNode> deptListToTree(List<DeptTreeNode> list) {
        List<DeptTreeNode> tree = new ArrayList<>();
        for (DeptTreeNode node: list) {
            if (node.getPid().equals(0)) {
                tree.add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 使用递归法查找部门子节点
     * @param node
     * @param list
     * @return
     */
    private static DeptTreeNode findChildren(DeptTreeNode node, List<DeptTreeNode> list) {
        for (DeptTreeNode childrenNode: list) {
            if (childrenNode.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChildren(childrenNode, list));
            }
        }
        return node;
    }

    /**
     * 字典节点list转tree
     * @param list
     * @return
     */
    public static List<DictTreeNode> dictListToTree(List<DictTreeNode> list) {
        List<DictTreeNode> tree = new ArrayList<>();
        for (DictTreeNode node: list) {
            if (node.getPid().equals(0)) {
                tree.add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 使用递归法查找字典子节点
     * @param node
     * @param list
     * @return
     */
    private static DictTreeNode findChildren(DictTreeNode node, List<DictTreeNode> list) {
        for (DictTreeNode childrenNode: list) {
            if (childrenNode.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(findChildren(childrenNode, list));
            }
        }
        return node;
    }

    /**
     * 权限节点list转tree
     * @param list
     * @return
     */
    public static List<PowerTreeNode> powerListToTree(List<PowerTreeNode> list) {
        List<PowerTreeNode> tree = new ArrayList<>();
        for (PowerTreeNode node: list) {
            if (node.getPid().equals(0)) {
                tree.add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 使用递归法查找权限子节点
     * @param node
     * @param list
     * @return
     */
    private static PowerTreeNode findChildren(PowerTreeNode node, List<PowerTreeNode> list) {
        for (PowerTreeNode childrenNode: list) {
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
