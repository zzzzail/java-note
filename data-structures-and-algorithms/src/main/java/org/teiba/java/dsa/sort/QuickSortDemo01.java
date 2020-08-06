package org.teiba.java.dsa.sort;

/**
 * 快速排序
 * 被称为20世纪对世界影响最大的算法之一
 *
 * @author zail
 * @date 2020/7/14
 */
public class QuickSortDemo01 {
    
    public static void main(String[] args) {
        int N = 1_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(QuickSortDemo01.class, "sort", Comparable.class, arr);
    }
    
    /**
     * 快速排序
     *
     * @param arr
     */
    public static void sort(Comparable<Object>[] arr) {
        // 使用递归的方式对数组进行排序
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    
    /**
     * 对arr[l...r]区间进行快速排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable<Object>[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }
    
    /**
     * 对arr[l...r]区间进行partition操作
     * 返回p，使得arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable<Object>[] arr, int l, int r) {
        
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        
        // 参考的标准
        Comparable<Object> v = arr[l];
        
        // 逐步地从l+1开始遍历数组，让数组在l+1之后分成两部分
        // arr[l+1...j] < v; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                // 交换
                Comparable<Object> e = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = e;
                // 交换完成后
                j++;
            }
        }
        
        // l和j进行位置交换
        Comparable<Object> e = arr[l];
        arr[l] = arr[j];
        arr[j] = e;
        
        return j;
    }
    
    private static void swap(Comparable<Object>[] arr, int i1, int i2) {
        Comparable<Object> t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
