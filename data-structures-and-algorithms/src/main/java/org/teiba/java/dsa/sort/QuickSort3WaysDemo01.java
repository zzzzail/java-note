package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class QuickSort3WaysDemo01 {
    
    public static void main(String[] args) {
        int N = 10_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort(QuickSort3WaysDemo01.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    private static void sort(Integer[] arr, int l, int r) {
        // terminator
        if (r - l <= 15) {
            InsertionSortDemo04.sort(arr, l, r);
            return;
        }
        
        int[] pq = partition(arr, l, r);
        int p = pq[0]; // arr[l...p] < v
        int q = pq[1]; // arr[q...r] > v
        sort(arr, l, p);
        sort(arr, q, r);
    }
    
    /**
     * 三路快速排序处理arr[l...r]
     * 将arr[l...r]分为<v; =v; >v三个部分
     * 之后分别对<v; >v两部分进行三路快速排序
     *
     * @param arr 数组
     * @param l   做指针
     * @param r   右指针
     * @return
     */
    private static int[] partition(Integer[] arr, int l, int r) {
        // 设置随机选取一个元素作为分区点
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Integer v = arr[l];
        
        int lt = l; // arr[l+1...lt] <v;
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1; // arr[lt+1....i-1] == v;
        while (i < gt) { // 只要i还没有和gt碰上
            if (arr[i] < v) {
                swap(arr, lt + 1, i);
                lt++;
                i++;
            }
            else if (arr[i] > v) {
                swap(arr, gt - 1, i);
                gt--;
            }
            else { // arr[i] == v
                i++;
            }
        }
        
        swap(arr, l, lt);
        return new int[]{lt - 1, gt};
    }
    
    private static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
