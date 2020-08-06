package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * 归并排序法
 * 时间复杂度为O(nlogn)
 *
 * @author zail
 * @date 2020/7/14
 */
public class MergeSortDemo01 {
    
    /**
     * 测试MergeSort
     *
     * @param args
     */
    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int total = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        SortTestHelper.testSort(MergeSortDemo01.class, "sort", Integer.class, arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 归并排序方法
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    
    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {
        
        if (l >= r) {
            return;
        }
        
        // int mid = (l + r) / 2;
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            
            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            // 如果右半部分元素已经全部处理完毕
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    
}
