package org.breeze.DataStructure.Tree;

import org.breeze.DataStructure.TreeNode;

/**
 * 求树的最大深度
 *
 * 递归：永远取左右子树深度最大得值，若数的根结点为null 则返回0，否则返回最大值加1
 */
public class TreeMaxDeep {

    public int maxDepth(TreeNode root) {
        if(null==root){
            return 0;
        }
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        int max = left_height>right_height?left_height:right_height;
        return max+1;
    }

    public static void main(String[] args) {

    }
}
