package org.breezeflow.algo.prefix_sum;

import java.util.Arrays;

/**
 * 前缀和
 */
public class PrefixSumArray {

    //前缀和数组
    private int[] diff;

    /**
     * 前缀和数组
     *
     * @param nums
     * @return
     */
    public int[] buildDiff(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = diff[i - 1] + nums[i];
        }
        return diff;
    }

    public int[] buildResult() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] - diff[i - 1];
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

