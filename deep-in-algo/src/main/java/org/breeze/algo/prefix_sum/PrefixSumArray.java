package org.breeze.algo.prefix_sum;

import java.util.Arrays;

/**
 * 前缀和 数组
 *
 * @author andy
 */
public class PrefixSumArray {

    //前缀和数组
    private int[] sum;

    /**
     * 构造前缀和数组：sum[n]为前n个数的和
     *
     * @param nums
     * @return
     */
    public int[] buildDiff(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return sum;
    }

    public int[] buildResult() {
        int[] res = new int[sum.length - 1];
        for (int i = 1; i < sum.length; i++) {
            res[i - 1] = sum[i] - sum[i - 1];
        }
        return res;
    }


    public static void main(String[] args) {
        PrefixSumArray demo = new PrefixSumArray();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(demo.buildDiff(nums)));
        System.out.println(Arrays.toString(demo.buildResult()));
    }

}

