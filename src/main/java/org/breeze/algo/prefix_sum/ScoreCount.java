package org.breeze.algo.prefix_sum;

/**
 * 算法技巧(前缀和)训练案例:统计分数区间中学生的个数
 *
 * 
 */
public class ScoreCount {

    private int[] count;

    /**
     * 通俗方法：排序所有成绩，遍历分数区间，统计人数
     * <p>
     * 构造前缀和数组：count[n]为前n个分数对应人数的和，注意n为分数[0,100]
     *
     * @param score 分数数组
     */
    public ScoreCount(int[] score) {
        if (score.length == 0) {
            return;
        }
        // 统计指定分数的学生有多少个，总分100分
        count = new int[100 + 1];
        for (int s : score) {
            count[s]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
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
        if (left == 0) {
            return count[right];
        } else {
            return count[right] - count[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] score = new int[]{0, 8, 13, 22, 33, 46, 51, 67, 78, 89, 95, 100};
        ScoreCount demo = new ScoreCount(score);
        System.out.println(demo.sumRange(1, 51));
    }

}
