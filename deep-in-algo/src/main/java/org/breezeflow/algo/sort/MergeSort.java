package org.breezeflow.algo.sort;

/**
 * 归并排序
 * <p>
 * 1. 递归操作
 * 将数据对半拆分成左右两部分
 * 对左侧部分排序
 * 对右侧部分排序
 * 2. 合并操作：将左右两个有序数组，合并成一个有序数组
 * 两个指针分别指向数组第一个元素，开始遍历
 * 取较小的数据放入临时数组，对应数组指针往下移动，另外一个数组指针不动
 * 然后再重复上述判断、取数据操作。
 * 如果有一个数组遍历结束，就将另一个数组剩余的数据拷贝到临时数组。
 *
 * @author andy
 */

public class MergeSort extends BaseSort {

    public void sort(int[] a) {
        if (a.length <= 0) {
            return;
        }
        sort(a, 0, a.length - 1);
    }


    private void sort(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[a.length];
        int i = start;// 左序列指针
        int j = mid + 1;// 右序列指针
        int t = 0;// 临时数组指针
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) {// 将左边剩余元素填充进temp中
            temp[t++] = a[i++];
        }
        while (j <= end) {// 将右序列剩余元素填充进temp中
            temp[t++] = a[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (start <= end) {
            a[start++] = temp[t++];
        }
    }

}