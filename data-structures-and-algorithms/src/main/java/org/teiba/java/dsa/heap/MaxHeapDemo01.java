package org.teiba.java.dsa.heap;

import java.util.Arrays;

/**
 * @author zail
 * @date 2020/7/14
 */
public class MaxHeapDemo01 {
    
    public static void main(String[] args) throws Exception {
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        System.out.println(maxHeap.size());
        
        for (int i = 0; i < n; i++) {
            maxHeap.insert(Integer.valueOf((int) (Math.random() * n)));
            System.out.println(maxHeap);
        }
    }
    
    /**
     * 大顶堆
     *
     * @param <T>
     */
    static class MaxHeap<T extends Comparable<T>> {
        // 存储数据
        private T[] data;
        // 堆的容量
        private int capacity;
        // 总数
        private int count;
        
        public MaxHeap(int capacity) {
            // 因为数组存储堆数据，是从下标1开始的，所以这里要加1
            data = (T[]) new Comparable[capacity + 1];
            this.capacity = capacity;
            this.count = 0;
        }
        
        /**
         * 返回堆的大小
         *
         * @return
         */
        public int size() {
            return count;
        }
        
        /**
         * 判断堆是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }
        
        public void insert(T t) throws Exception {
            // 以后可以修改为可扩充容量
            if (count + 1 > capacity) {
                throw new Exception("容量超出了限制！");
            }
            
            data[count + 1] = t;
            count++;
            shiftUp(count);
        }
        
        /**
         * 自底向上的堆化
         *
         * @param k
         */
        public void shiftUp(int k) {
            // 比k的父节点大，k的取值最大是2（k=1是根节点不需要再向上进行比较了）
            while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
                swap(data, k, k / 2);
                k /= 2;
            }
        }
        
        /**
         * 交换位置
         *
         * @param data
         * @param i1
         * @param i2
         */
        private void swap(T[] data, int i1, int i2) {
            T t = data[i1];
            data[i1] = data[i2];
            data[i2] = t;
        }
        
        @Override
        public String toString() {
            return "MaxHeap{" +
                "data=" + Arrays.toString(data) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
        }
    }
    
}
