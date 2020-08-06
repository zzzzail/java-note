package org.teiba.java.dsa.sort;

/**
 * @author zail
 */
public class QuickSortDemo03 {
    
    public static void main(String[] args) {
        int N = 10_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(QuickSortDemo03.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(Integer[] arr) {
        sortRecursion(arr, 0, arr.length - 1);
    }
    
    /**
     * 对arr[l...r]进行递归排序
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     */
    public static void sortRecursion(Integer[] arr, int l, int r) {
        // 递归的结束条件
        if (l >= r) return;
        
        // 对数组进行partition操作
        int p = partition(arr, l, r);
        sortRecursion(arr, l, p - 1);
        sortRecursion(arr, p + 1, r);
    }
    
    /**
     * 对arr[l...r]进行partition操作
     *
     * @param arr 数组
     * @param l   左指针
     * @param r   右指针
     * @return 返回分区的节点
     */
    private static int partition(Integer[] arr, int l, int r) {
        // 把数组第一个元素作为分区点
        Integer v = arr[l];
        
        // i指向下一个要处理的元素，从l+1开始遍历整个数组，arr[l+1...j] < v;arr[j+1...i-1] > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        
        // 最后把v位置的元素和j位置的元素进行交换
        swap(arr, l, j);
        return j;
    }
    
    private static void swap(Integer[] arr, int i1, int i2) {
        Integer t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
