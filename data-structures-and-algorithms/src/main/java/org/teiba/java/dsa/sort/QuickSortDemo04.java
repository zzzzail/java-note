package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class QuickSortDemo04 {
    
    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        System.out.println(Arrays.toString(arr));
        SortTestHelper.testSort(QuickSortDemo04.class, "sort", Integer[].class, arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        // 边界条件
        if (arr == null || arr.length <= 1) return;
        
        int l = 0;
        int r = arr.length - 1;
        sortRecursion(arr, l, r);
    }
    
    private static void sortRecursion(Integer[] arr, int l, int r) {
        // 递归的结束条件
        if (l >= r) return;
        
        int[] p = partition(arr, l, r);
        int pl = p[0];
        int pr = p[1];
        sortRecursion(arr, l, pl);
        sortRecursion(arr, pr, r);
    }
    
    private static int[] partition(Integer[] arr, int l, int r) {
        // 随机一个元素和第一个位置交换
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Integer x = arr[l]; // 定义分区点
        
        /**
         * [l+1...lt] < x
         * [lt+1...i-1] == x
         * [gt...r] > x
         */
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i] < x) { // 当前元素小于x
                swap(arr, i, lt + 1);
                lt++;
                i++;
            }
            else if (arr[i] > x) { // 当前元素大于x
                swap(arr, i, gt - 1);
                gt--;
            }
            else {
                i++;
            }
        }
        // [l...lt-1] < x
        swap(arr, l, lt);
        // [lt...gt-1] == x
        return new int[]{lt - 1, gt};
    }
    
    private static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
