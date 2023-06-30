package org.breeze.base.DataStructure.Tree;

import org.breeze.base.DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeLevelTraverse {

    public void levelOrderBottom(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()){
            TreeNode currentRoot = currentLevel.poll();
            System.out.println(currentRoot.val);
            if(null != currentRoot.left) currentLevel.add(currentRoot.left);
            if(null != currentRoot.right) currentLevel.add(currentRoot.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left=node1;root.right=node2;
        node1.left=node3;
//        node1.right=node4;
//        node2.left=node5;
        node2.right=node6;
        TreeLevelTraverse demo = new TreeLevelTraverse();
        demo.levelOrderBottom(root);

    }
}
