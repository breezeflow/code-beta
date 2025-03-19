package org.breeze.leetcode.two_pointer_array;

public class TwoSum {

    //  2 7 11 15    target  9
    public int[] twoSum(int[] numbers, int target) {
        // 非递减排序数组，双指针 从数组两头开始遍历
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // 如果等于，就返回结果
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // 如果相加之和小于 target,则左指针向右移，稍微再大一点
                left++;
            } else {
                // 如果相加之和大于 target,则右指针向左移，稍微再小一点
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
