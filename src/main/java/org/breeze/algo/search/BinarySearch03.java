package org.breeze.algo.search;

/**
 * 二分查找变形——查找第一个大于等于给定值的元素
 *
 * 
 */
public class BinarySearch03 {

    public static int search(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (a[mid] >= target) {
                if (mid == 0 || a[mid - 1] < target) return mid;
                else end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
