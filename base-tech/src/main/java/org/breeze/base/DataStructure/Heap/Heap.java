package org.breeze.base.DataStructure.Heap;

/**
 * 堆的特性：
 * 1. 完全二叉树
 * 2. 节点必须大于等于（或小于等于）子树所有节点
 *
 * 堆的分类：
 * 1. 大根堆：节点大于等于子树节点的堆
 * 2. 小根堆：节点小于等于子树节点的堆
 *
 * 数组存储堆：数组从下标0开始存储
 * 节点i的子节点为：2*i + 1、2*i+2
 * 节点i的父节点为：（i-1）/ 2
 *
 * 堆的常用操作：添加、删除
 */

//以大根堆为例
public class Heap {

    //存储堆的数组
    private int[] a;

    //堆能存储元素的最大个数
    private int n;

    //堆中已经存在元素的个数
    private int count;

    //初始化
    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    //插入操作
    public void insert(int data) {
        //判断堆是否满
        if (count >= n) {
            return;
        }
        //尾部插入
        ++count;
        a[count] = data;
        int i = count;
        //堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            //当父节点存在 且 大于父节点 时 swap
            int temp = a[i / 2];
            a[i / 2] = a[i];
            a[i] = temp;
            i = i / 2;
        }
    }

    //删除堆顶元素
    public int removeMax() {
        //判断堆是否为空
        if(count==0){
            return 0;
        }

        //堆顶元素：
        int result = a[1];

        //用最后一个元素替换第一个元素（对顶元素） 并 移除最后有一个元素
        a[1] = a[count];
        count--;

        //自顶而下堆化
        int i = 1;
        while (true){
            int maxPos = i;
           //三个节点找最大
            int left = 2*i;
            int right = 2*i+1;
            if(left<=n&&a[left]>a[i]) {
                maxPos = left;
            }
            if (right <= n && a[right]>a[maxPos]) {
                maxPos=right;
            }
            if(maxPos ==i ) {
                break;
            }
            int temp = a[i];
            a[i]=a[maxPos];
            a[maxPos] = temp;
            i=maxPos;
        }
        return result;
    }

    /**
     * 显示堆
     */
    public void display(){
        for(int i = 1;i<=count;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(8);
        heap.insert(9);
        heap.insert(17);
        heap.insert(10);
        heap.insert(15);
        heap.insert(6);
        heap.insert(16);
        heap.display();

        //基于堆排序：对顶永远是最大 或者 最小的 ，挨个取 对顶元素即可
        for(int i = 0;i<5;i++){
            System.out.println(heap.removeMax());
        }

    }

}
