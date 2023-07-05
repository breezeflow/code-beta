package org.breeze.DataStructure.Tree;

/**
 * 判断一棵树是否为对称数
 * 1
 * 2 2
 * 3 4 4 3
 */

import org.breeze.DataStructure.TreeNode;

/**
 * 递归的难点在于：找到可以递归的点
 * <p>
 * 为什么很多人觉得递归一看就会，一写就废。 或者说是自己写无法写出来，关键就是你对递归理解的深不深。
 * <p>
 * 对于此题： 递归的点怎么找？从拿到题的第一时间开始，思路如下：
 * <p>
 * 1.怎么判断一棵树是不是对称二叉树？ 答案：如果所给根节点，为空，那么是对称。如果不为空的话，当他的左子树与右子树对称时，他对称
 * <p>
 * 2.那么怎么知道左子树与右子树对不对称呢？在这我直接叫为左树和右树 答案：如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。
 * <p>
 * 仔细读这句话，是不是有点绕？怎么感觉有一个功能A我想实现，但我去实现A的时候又要用到A实现后的功能呢？
 * <p>
 * 当你思考到这里的时候，递归点已经出现了： 递归点：我在尝试判断左树与右树对称的条件时，发现其跟两树的孩子的对称情况有关系。
 * <p>
 * 想到这里，你不必有太多疑问，上手去按思路写代码，函数A（左树，右树）功能是返回是否对称
 * <p>
 * def 函数A（左树，右树）： 左树节点值等于右树节点值 且 函数A（左树的左子树，右树的右子树），函数A（左树的右子树，右树的左子树）均为真 才返回真
 * <p>
 * 实现完毕。。。
 * <p>
 * 写着写着。。。你就发现你写出来了。。。。。。
 */


public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return childTreeIsSymmetric(root, root);
    }

    /**
     * 判断左右字数是否对称
     *
     * @param left
     * @param right
     * @return
     */
    public boolean childTreeIsSymmetric(TreeNode left, TreeNode right) {
        //当为叶子节点（左右子树都为空），对称
        if (left == null && right == null) return true;

        //当左右子树只有一个为空时，不对称
        if (left == null || right == null) return false;

        //如果左右子树根节点相同，则对称，继续判断左右子树是否对称。
        if (left.val == right.val) {
            return childTreeIsSymmetric(left.left, right.right) && childTreeIsSymmetric(left.right, right.left);
        }

        //其他情况，不对称
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        SymmetricTree demo = new SymmetricTree();
        System.out.println(demo.isSymmetric(root));
    }
}
