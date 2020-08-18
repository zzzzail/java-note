package org.teiba.java.dsa.heap;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author zail
 */
public class IndexMaxHeapDemo01 {
    
    /**
     * 大顶堆
     *
     * @param <T>
     */
    static class IndexMaxHeap<T extends Comparable> {
        // 存储数据
        protected T[] data;
        // 索引
        protected int[] indexes;
        // 利用反向查找的方法解决change方法复杂度高的问题, rev中存储的是该下标的元素在索引数组中的位置
        protected int[] reverse;
        // 堆的容量
        protected int capacity;
        // 总数
        protected int count;
        
        public IndexMaxHeap(int capacity) {
            // 因为数组存储堆数据，是从下标1开始的，所以这里要加1
            data = (T[]) new Comparable[capacity + 1];
            indexes = new int[capacity + 1];
            reverse = new int[capacity + 1];
            // 初始化为0表示i索引在堆中不存在
            Arrays.fill(reverse, 0);
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
        
        /**
         * 插入一个元素，把元素索引i放入到indexes中，把元素放到data中
         *
         * @param i 元素索引
         * @param t 插入的元素
         */
        public boolean insert(int i, T t) {
            // 以后可以修改为可扩充容量
            if (count + 1 > capacity) {
                return false;
            }
            // 解决索引越界的问题
            if (i + 1 < 1 && i + 1 > capacity) {
                return false;
            }
            
            i += 1;
            data[i] = t;
            indexes[count + 1] = i; // 索引里存储的是data的索引
            reverse[i] = count + 1;
            
            count++;
            shiftUp(count);
            
            return true;
        }
        
        /**
         * 取出堆顶元素
         */
        public T extractMax() {
            if (count <= 0) {
                return null;
            }
            
            T t = data[indexes[1]];
            swap(indexes, 1, count);
            reverse[indexes[1]] = 1;
            reverse[indexes[count]] = 0;
            data[count] = null;
            count--;
            shiftDown(1);
            
            return t;
        }
        
        /**
         * 取出堆顶元素
         */
        public int extractMaxIndex() {
            if (count <= 0) {
                return -1;
            }
            
            int t = indexes[1] - 1;
            swap(indexes, 1, count);
            reverse[indexes[1]] = 1;
            reverse[indexes[count]] = 0;
            data[count] = null;
            count--;
            shiftDown(1);
            
            return t;
        }
        
        /**
         * 根据索引获取元素
         *
         * @param i 索引值
         * @return
         */
        public T getData(int i) {
            if (!contain(i)) {
                return null;
            }
            
            return data[i + 1];
        }
        
        /**
         * 把索引为i的内容修改成t
         *
         * @param i 索引值
         * @param t 新元素
         */
        public void change(int i, T t) {
            // 检查i防止数组越界
            if (!contain(i)) {
                return;
            }
            
            i += 1;
            data[i] = t;
            
            // 找到indexes[j] = i, j表示data[i]在堆中的位置
            // 之后shiftUp(j)，再shiftDown(j)即可
            // for (int j = 0; j < count; j++) {
            //     if (indexes[j] == i) {
            //         shiftUp(j);
            //         shiftDown(j);
            //         return;
            //     }
            // }
            
            // 修改之后
            int j = reverse[i];
            shiftUp(j);
            shiftDown(j);
        }
        
        /**
         * 数据中是否包含i
         *
         * @param i
         * @return
         */
        private boolean contain(int i) {
            // 检查i是否越界
            if (i + 1 < 1 && i + 1 > capacity) {
                return false;
            }
            return reverse[i + 1] == 0;
        }
        
        /**
         * 自底向上的堆化
         *
         * @param k 索引数组的下标
         */
        public void shiftUp(int k) {
            // 比k的父节点大，k的取值最大是2（k=1是根节点不需要再向上进行比较了）
            while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
                swap(indexes, k, k / 2);
                reverse[indexes[k / 2]] = k / 2;
                reverse[indexes[k]] = k;
                k /= 2;
            }
        }
        
        /**
         * 自顶向下堆化
         *
         * @param k
         */
        public void shiftDown(int k) {
            while (2 * k <= count) {
                // 再循环中，data[k]和data[j]交换位置
                int j = 2 * k;
                // 有右子节点，并且右子节点比左子节点大
                if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                    j += 1;
                }
                // 如果k位置的元素比j位置的元素大，则结束循环
                if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                    break;
                }
                // 交换位置
                swap(indexes, k, j);
                reverse[indexes[k]] = k;
                reverse[indexes[j]] = j;
                k = j;
            }
        }
        
        /**
         * 交换位置
         *
         * @param arr
         * @param i1
         * @param i2
         */
        private void swap(int[] arr, int i1, int i2) {
            int t = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = t;
        }
        
        @Override
        public String toString() {
            return "IndexMaxHeap{" +
                "data=" + Arrays.toString(data) +
                ", indexes=" + Arrays.toString(indexes) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
        }
    }
    
}
