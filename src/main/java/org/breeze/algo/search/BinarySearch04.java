package org.breeze.algo.search;

/**
 * 二分查找——最后一个小于等于给定值的元素
 *
 * 
 */
public class BinarySearch04 {

    public static int search(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (a[mid] > target) end = mid - 1;
            else {
                if (mid == a.length - 1 || a[mid + 1] > target) return mid;
                else start = mid + 1;
            }
        }
        return -1;
    }


}
