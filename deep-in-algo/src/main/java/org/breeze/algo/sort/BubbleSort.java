package org.breeze.algo.sort;


/**
 * 冒泡排序 时间复杂度：O(n^2)，适合小规模数据的排序
 *
 * @author andy
 */
public class BubbleSort extends BaseSort {

    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

}
