package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class MergeSortDemo06 {
    
    public static void main(String[] args) {
        // 千万不要用归并排序排一千万的数据啊
        // int total = 10_000_000;
        int total = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        System.out.println(Arrays.toString(arr));
        SortTestHelper.testSort(MergeSortDemo06.class, "sort", Integer[].class, arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        if (arr.length <= 1) return;
        
        int l = 0;
        int r = arr.length - 1;
        sortRecursion(arr, l, r);
    }
    
    private static void sortRecursion(Integer[] arr, int l, int r) {
        // 递归终止条件
        if (l >= r) return;
        
        int mid = l + ((r - l) >> 1);
        sortRecursion(arr, l, mid);
        sortRecursion(arr, mid + 1, r);
        
        merge(arr, l, mid, r);
    }
    
    // 合并两个有序数组
    private static void merge(Integer[] arr, int l, int mid, int r) {
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        
        // i指向左侧开始位置，j指向右侧开始位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左侧的元素都遍历完
                arr[k] = aux[j - l];
                j++;
            }
            else if (j > r) { // 如果右侧的元素都遍历完
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l] <= aux[j - l]) { // 如果左侧元素小
                arr[k] = aux[i - l];
                i++;
            }
            else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    
}
