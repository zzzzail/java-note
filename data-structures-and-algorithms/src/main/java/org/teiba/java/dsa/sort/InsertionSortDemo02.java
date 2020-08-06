package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class InsertionSortDemo02 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static void sort(int[] arr) {
        
        if (arr.length <= 1) return;
        
        for (int i = 1; i < arr.length; i++) {
            
            int val = arr[i];
            int j = i - 1;
            
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j]; // 数据移动
                } else {
                    break;
                }
            }
            
            arr[j + 1] = val; // 插入数据
        }
    }
}
