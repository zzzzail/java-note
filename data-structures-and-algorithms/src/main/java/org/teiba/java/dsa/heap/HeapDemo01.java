package org.teiba.java.dsa.heap;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * 大顶堆
 * 1. 堆就是一颗完全二叉树
 * 2. 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 * 其中节点大于等于其子节点的堆叫做大顶堆。小于等于其子节点的堆叫做小顶堆。
 *
 * @author zail
 */
public class HeapDemo01 {
    
    static class Heap {
        int[] val; // 数组，从下标1开始存储数据。
        int n; // 堆可以存储的最大数据个数
        int count; // 堆中已存储的数据个数
        
        public Heap(int capacity) {
            int[] arr = new int[capacity + 1];
            this.n = capacity;
            this.count = 0;
        }
        
        public void insert(int data) {
            // 边界条件
            if (count >= n) return; // 堆已经存满了
            ++count; // 增加计数
            val[count] = data; // 直接把数据存储到数组最后一位
            int i = count;
            // 自下往上堆化
            while (i / 2 > 0 && val[i] > val[i / 2]) {
                // 交换位置
                swap(val, i, i / 2);
                i = i / 2;
            }
        }
        
        /**
         * 删除大顶堆中最大的元素，也就是下标为1的元素
         */
        public void removeMax() {
            // 边界条件
            if (count == 0) return; // 堆中没有元素
            val[1] = val[count]; // 把最后一个元素放到第一个元素中
            --count;
            heapify(val, count, 1);
        }
        
        /**
         * 自上往下堆化
         *
         * @param arr   需要堆化的数组
         * @param count 大小
         * @param i     需要堆化元素堆下标
         */
        private void heapify(int[] arr, int count, int i) {
            while (true) {
                int maxPos = i; // 最大
                if (i * 2 <= n && arr[i] < arr[i * 2]) maxPos = i * 2;
                if (i * 2 <= n && arr[i] < arr[i * 2 + 1]) maxPos = i * 2 + 1;
                if (maxPos == i) break;
                swap(arr, i, maxPos);
                i = maxPos;
            }
        }
        
        private void swap(int[] arr, int i1, int i2) {
            int t = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = t;
        }
    }
    
}
