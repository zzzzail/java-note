package org.teiba.java.dsa.sort;

/**
 * 快速排序
 *
 * @author zail
 */
public class QuickSortDemo02 {
    
    public static void main(String[] args) {
        int N = 10_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(QuickSortDemo02.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    
    /**
     * 快速排序递归方法
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     */
    public static void sort(Integer[] arr, int l, int r) {
        // 递归终止条件
        if (l >= r) return;
        
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }
    
    /**
     * 快速排序核心方法：分区
     * 对arr[l...r]部分进行partition操作
     * 返回p，使得arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     * @return 返回中间节点指针
     */
    public static int partition(Integer[] arr, int l, int r) {
        // 选择第一个元素作为分区点
        Integer v = arr[l];
        
        // 从l+1开始逐步遍历整个数组，arr[l+1...j] < v; arr[j+1...i] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        
        // 把l位置的元素和j位置的元素进行交换
        swap(arr, l, j);
        return j;
    }
    
    public static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
