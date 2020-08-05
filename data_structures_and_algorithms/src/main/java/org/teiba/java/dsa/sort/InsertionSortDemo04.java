package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class InsertionSortDemo04 {
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr, 4, 8);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 对arr[l...r]范围的数组进行插入排序
     *
     * @param arr 数组
     * @param l   左侧指针
     * @param r   右侧指针
     */
    public static void sort(Integer[] arr, int l, int r) {
        
        for (int i = l + 1; i <= r; i++) {
            
            Integer val = arr[i];
            int j = i - 1;
            for (; j >= l; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j]; // 把元素往后挪一个位置
                }
                else {
                    break;
                }
            }
            
            arr[j + 1] = val;
        }
        
    }
    
}
