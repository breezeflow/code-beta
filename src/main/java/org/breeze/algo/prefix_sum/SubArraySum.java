package org.breeze.algo.prefix_sum;

/**
 * 算法技巧(前缀和)训练案例:<a href="https://leetcode.cn/problems/subarray-sum-equals-k/">和为 K 的子数组</a>
 *
 * 
 */
public class SubArraySum {

    int[] preSum;

    public int subarraySum(int[] nums, int k) {

        //构造前缀和数组
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        // 计算子串区间和是否等于k
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum demo = new SubArraySum();
        int[] num = new int[]{1, 2, 3};
        System.out.println(demo.subarraySum(num, 3));
    }

}
