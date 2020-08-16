package org.teiba.java.dsa.sort;

/**
 * 堆排序
 * 第一步：建堆
 * 第二步：排序
 *
 * @author zail
 */
public class HeapSortDemo01 {
    
    // 建堆
    public static void buildHeap(Integer[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }
    }
    
    /**
     * 堆排序
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        buildHeap(arr);
        int k = arr.length;
        while (k > 1) {
            swap(arr, 1, k);
            --k;
            heapify(arr, k, 1);
        }
    }
    
    private static void heapify(Integer[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }
    
    private static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
