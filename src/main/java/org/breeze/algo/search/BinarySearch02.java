package org.breeze.algo.search;

/**
 * 二分查找变形——查找最后一个等于给定值的元素
 *
 * 
 */
public class BinarySearch02 {

    public static int search(int[] a, int target) {
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (a[mid] > target) {
                end = mid - 1;
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                //因为 数组是有序的，所以当 mid 不是最后一个且mid == target时，
                // 需要判断后一个数是否也等于target，如果是就继续 在后半区域找，
                //如果不是，那么mid就是第一个出现的值
                if (mid == a.length - 1 || a[mid + 1] != target) return mid;
                else start = mid + 1;
            }
        }
        return -1;

    }
}
