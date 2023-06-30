package org.breeze.base.DataStructure.Tree;


import org.breeze.base.DataStructure.TreeNode;

/**
 * 校验是否是BST （二叉查找树）
 * <p>
 * 二叉查找树的特点：
 * 1. 根节点的值必须大于左节点的值，小于右节点的值
 * 2. 左右子树也必须是二叉查找树
 * 3. 叶子节点 也是二叉查找树
 */
public class IsValidBST {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        IsValidBST demo = new IsValidBST();
        System.out.println(demo.isValidBST(t1));
        demo = null;

    }

    /**
     * 每个节点的值都有一个固定的范围，例如根节点的范围就是【Long.MIN_VALUE,Long.MAX_VALUE】
     * 当遍历左节点时，左节点的范围就是【Long.MIN_VALUE,root.value】 右节点的范围就是【root.value, Long.MAX_VALUE】
     * 以此规律递推，退出条件，当前节点为null，或者不满足二叉查找树的特点就退出
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return checkBST(root.left, minValue, root.val) && checkBST(root.right, root.val, maxValue);
    }


    /**
     * 错误写法：只考虑了当前节点与父节点的关系，而忽略了 所在子树的数值范围约束，
     * 例如：虽然大于当前节点，但所在根节点的左子树上，却别根节点的值还大，则不属于二叉查找树
     *
     * @param root
     * @return
     * @Deprecated
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if ((root.left != null && root.val <= root.left.val) || (root.right != null && root.val >= root.right.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

}
