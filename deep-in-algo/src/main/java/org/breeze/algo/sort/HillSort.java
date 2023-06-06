package org.breeze.algo.sort;


/**
 * 希尔排序：对插入排序的改进，不稳定
 *
 * @author andy
 */

public class HillSort extends BaseSort {

    /**
     * 从小到大顺序
     *
     * @param a
     */
    public void sort(int a[]) {
        int d = a.length;
        while (true) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j + d < a.length; j = j + d) {
                    if (a[j] > a[j + d]) {
                        swap(a, j, j + d);
                    }
                }
            }
            if (d == 1)
                break;
            d--;
        }
    }

}
