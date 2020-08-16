package org.teiba.java.dsa;

/**
 * 全排列问题
 *
 * @author zail
 */
public class PermutationsDemo01 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        printPermutations(arr, arr.length, arr.length);
    }
    
    /**
     * 对数组中的所有数字，以n个为一组进行全排列
     * int[] a = {1, 2, 3, 4};
     * printPermutations(a, 4, 4);
     * <p>
     * 假设数组中存储的是1，2， 3...n。
     * f(1,2,...n) = {最后一位是1, f(n-1)} + {最后一位是2, f(n-1)} +...+{最后一位是n, f(n-1)}。
     * k = 0就是结束条件
     *
     * @param arr 数组
     * @param n   n个数字
     * @param k   表示要处理的子数组的数据个数
     */
    public static void printPermutations(int[] arr, int n, int k) {
        // k每次递归就减去1，递归到最后一个数字的时候就打印
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < k; i++) {
            swap(arr, i, k - 1);
            printPermutations(arr, n, k - 1);
            // 把数组变回去
            swap(arr, i, k - 1);
        }
    }
    
    /**
     * 根据下标交换数组中两个元素的位置
     *
     * @param arr 原数组
     * @param i1  下标1
     * @param i2  下标2
     */
    private static void swap(int[] arr, int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
    
}
