package org.teiba.java.dsa.sort;

import javax.swing.*;
import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zail
 */
public class MergeSortDemo05 {
    
    public static void main(String[] args) {
        // 千万不要用归并排序排一千万的数据啊
        // int total = 10_000_000;
        int total = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        System.out.println(Arrays.toString(arr));
        SortTestHelper.testSort(MergeSortDemo05.class, "sort", Integer[].class, arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        // 边界条件
        if (arr.length <= 1) return;
        
        // 1. 分数组
        int l = 0;
        int r = arr.length - 1;
        sortRecursion(arr, l, r);
    }
    
    public static void sortRecursion(Integer[] arr, int l, int r) {
        // 递归的结束条件
        if (l >= r) return;
        
        int mid = l + ((r - l) >> 1);
        sortRecursion(arr, l, mid);
        sortRecursion(arr, mid + 1, r);
        
        // 合并两个有序数组
        merge(arr, l, mid, r);
    }
    
    private static void merge(Integer[] arr, int l, int mid, int r) {
        // 临时数组
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        
        // i指向左侧开始位置，j指向右侧开始位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左侧元素已经全部处理完
                arr[k] = aux[j - l];
                j++;
            }
            else if (j > r) { // 如果右侧元素已经全部处理完
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l] <= aux[j - l]) { // 如果左侧元素小于等于右侧元素
                arr[k] = aux[i - l];
                i++;
            }
            else { // 如果左侧元素大于右侧元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    
}
















