package org.breezeflow.algo.search;

/**
 * 简单的二分查找：无重复值，递归实现
 */
public class SimpleBinarySearch02 {

    public static int search(int[] a, int low, int height, int target) {
        if (low > height) return -1;
        int mid = low + ((height - low) >> 1);
        if (a[mid] == target) return mid;
        if (a[mid] < target) {
            return search(a, mid + 1, height, target);
        } else {
            return search(a, low, mid - 1, target);
        }
    }

}
