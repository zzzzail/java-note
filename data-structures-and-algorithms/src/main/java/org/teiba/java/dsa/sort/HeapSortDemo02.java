package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class HeapSortDemo02 {
    
    public static void main(String[] args) {
        int total = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        System.out.println(Arrays.toString(arr));
        SortTestHelper.testSort(HeapSortDemo02.class, "sort", Integer[].class, arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * parent(i) = (i-1)/2
     * left child (i) = 2 * i + 1
     * right child (i) = 2 * i + 2
     * 最后一个非叶子节点的索引 (count - 1) / 2
     *
     * @param arr 需要排序的数组
     */
    public static void sort(Integer[] arr) {
        heapify(arr);
        
        // 当堆里只剩下一个元素的时候就不需要操作了
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }
    
    /**
     * 堆化
     *
     * @param arr 堆化的数组
     */
    private static void heapify(Integer[] arr) {
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
    }
    
    /**
     * 自顶向下堆化一个元素
     *
     * @param arr 数组
     * @param n   需要堆化的数组的长度
     * @param k   需要堆化的索引位置
     */
    private static void shiftDown(Integer[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            // 循环中交换k和j的位置
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }
    
    private static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
