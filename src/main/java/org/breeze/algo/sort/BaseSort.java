package org.breeze.algo.sort;

/**
 * 排序算法基础类
 *
 * @author andy
 */
public abstract class BaseSort {

    /**
     * 具体排序算法逻辑
     *
     * @param a 数组
     */
    public abstract void sort(int a[]);

    /**
     * 交换数组元素值
     *
     * @param a 数组
     * @param i index i
     * @param j index j
     */
    public void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 显示数组元素
     *
     * @param a 数据
     */
    public void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * 判断是否已经有序
     *
     * @param a
     * @return true 有序 ;  false 无序
     */
    public boolean isSorted(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }

    /**
     * 测试逻辑
     */
    public void test() {

    }

}
