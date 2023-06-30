package org.breeze.base.DataStructure.Tree;



import org.breeze.base.DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraverseTree {

    TreeNode root;

    public TraverseTree(){

    }

    public TraverseTree(TreeNode root){
        this.root=root;
    }

    /**
     * 前序遍历
     * @param node
     */
    public  void PreOrder(TreeNode node){
        if(node == null) return ;
        System.out.print(node.val+"  ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void MidOrder(TreeNode node){
        if(node == null) return ;
        MidOrder(node.left);
        System.out.print(node.val+"  ");
        MidOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void PostOrder(TreeNode node){
        if(node == null) return ;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.val+"  ");
    }

    /**
     * 层序遍历
     * @param node
     */
    public void LevelOrder(TreeNode node){
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()){
            TreeNode currentRoot = currentLevel.poll();
            System.out.println(currentRoot.val);
            if(null != currentRoot.left) currentLevel.add(currentRoot.left);
            if(null != currentRoot.right) currentLevel.add(currentRoot.right);
        }
    }
}
