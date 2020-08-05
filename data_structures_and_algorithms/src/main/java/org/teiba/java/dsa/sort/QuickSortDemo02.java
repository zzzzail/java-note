package org.teiba.java.dsa.sort;

/**
 * @author zail
 */
public class QuickSortDemo02 {
    
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
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     * @return 返回中间节点指针
     */
    public static int partition(Integer[] arr, int l, int r) {
        // 选择第一个元素作为分区点
        Integer p = arr[0];
        
        return 0;
    }
    
}
