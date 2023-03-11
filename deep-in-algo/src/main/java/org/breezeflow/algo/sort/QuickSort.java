package org.breezeflow.algo.sort;

/**
 * 快速排序
 *
 * <p>思路：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的
 * <p>根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从
 * q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了
 *
 * @author andy
 */
public class QuickSort extends BaseSort {

    public void sort(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int p, int r) {
        if (p >= r) return;
        int q = partition(arr, p, r);
        sort(arr, p, q - 1);
        sort(arr, q + 1, r);
    }

    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        System.out.print("找到中间点：i = " + i + "  ");
        System.out.print("此时结果为：");
        show(arr);
        return i;
    }

}