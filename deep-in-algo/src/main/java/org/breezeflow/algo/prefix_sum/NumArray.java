package org.breezeflow.algo.prefix_sum;

/**
 * 算法技巧(前缀和)训练案例:区域和检索 - 数组不可变
 *
 * @author breezeflow
 * @link https://leetcode.cn/problems/range-sum-query-immutable/
 * @date 2023/02/07
 */
public class NumArray {

    private int[] sum;

    /**
     * 构造前缀和数组：sum[n]为前n个数的和
     *
     * @param arr
     */
    public NumArray(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        sum = new int[arr.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = arr[i - 1] + sum[i - 1];
        }
    }

    /**
     * 前缀和：构造前缀和数组，right-left 即原数组left至right和
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    /**
     * 通俗方法：遍历数组left至right
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRangeV1(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += this.sum[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 5));
    }
}
