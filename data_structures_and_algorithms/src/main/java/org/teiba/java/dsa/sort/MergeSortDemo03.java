package org.teiba.java.dsa.sort;


import java.util.Arrays;

/**
 * @author zail
 */
public class MergeSortDemo03 {
    
    public static void main(String[] args) {
        int total = 10_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        SortTestHelper.testSort(MergeSortDemo03.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    /**
     * @param arr
     */
    public static void sort(Integer[] arr) {
        // 合并两个数组
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    
    /**
     * 递归方法
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     */
    public static void sort(Integer[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) return;
        
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        
        // 合并两个有序数组
        merge(arr, l, mid, r);
    }
    
    /**
     * 按照顺序合并两个有序数组
     *
     * @param arr 数组的所有数据
     * @param l   左指针
     * @param mid 中间指针
     * @param r   右指针
     */
    public static void merge(Integer[] arr, int l, int mid, int r) {
        // 申请一个临时数组（因为r是下标，所以需要加1）
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        
        // i指向数组左侧的初始位置；j指向右侧数组的初始位置（mid + 1）
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            
            if (i > mid) { // 如果左侧数组已经全部处理完成
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) { // 如果右侧数组已经全部处理完成
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) { // 如果左侧元素 <= 右侧的元素
                arr[k] = aux[i - l];
                i++;
            } else { // 如果左侧元素 > 右侧元素
                arr[k] = aux[j - l];
                j++;
            }
        }
        
    }
    
}
