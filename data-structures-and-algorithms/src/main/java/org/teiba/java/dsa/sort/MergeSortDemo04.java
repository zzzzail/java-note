package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class MergeSortDemo04 {
    
    public static void main(String[] args) {
        // 千万不要用归并排序排一千万的数据啊
        // int total = 10_000_000;
        int total = 10_0000;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        SortTestHelper.testSort(MergeSortDemo04.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    /**
     * 递归处理排序
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     */
    public static void sort(Integer[] arr, int l, int r) {
        
        /**
         * 最重要的一步：递归的结束条件
         * 优化2： 近乎所有的排序算法都存在一个优化情况，就是排序到底的情况。
         * 如果递归到元素非常小的时候，可以使用插入排序来提高性能。
         * 原因1：当数组元素少的时候，数组近乎有序的概率就会比较大。此时使用插入排序有一定的优势。
         * 原因2：虽然插入排序最大的时间复杂度是O(n^2)，而归并排序是O(nlogn)级别的。
         * 插入排序的时间复杂度系数比归并排序时间复杂度系数小。换句话说，当n小到一定程度时，插入排序比归并排序要快一些。
         */
        // if (l >= r) return;
        if (r - l < 15) { // 15
            InsertionSortDemo04.sort(arr, l, r);
            return;
        }
        
        int mid = (l >> 1) + (r >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        
        /**
         * 合并两个有序数组。
         *
         * 优化1： 需要合并的两个有序的数组a，b。如果a的最大值也就是arr[mid] 大于 b 数组的最小值也就是 arr[mid + 1]。
         * 也就说明两个数组无需排序，拼接起来就是有序的。则无需合并两个数组，直接返回即可。
         */
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }
    
    /**
     * 合并两个有序数组
     *
     * @param arr 数组
     * @param l   左指针
     * @param mid 中间指针
     * @param r   右指针
     */
    public static void merge(Integer[] arr, int l, int mid, int r) {
        
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        
        // i指向左开始位置；j指向右开始位置（mid + 1）
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左侧元素已经全部处理完成
                arr[k] = aux[j - l];
                j++;
            }
            else if (j > r) { // 如果右侧元素已经全部处理完成
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l] <= aux[j - l]) { // 如果左侧元素 <= 右侧元素
                arr[k] = aux[i - l];
                i++;
            }
            else { // 如果左侧元素 > 右侧元素
                arr[k] = aux[j - l];
                j++;
            }
        }
        
    }
    
}
