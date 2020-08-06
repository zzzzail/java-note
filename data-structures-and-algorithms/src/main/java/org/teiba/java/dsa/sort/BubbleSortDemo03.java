package org.teiba.java.dsa.sort;

import org.teiba.java.dsa.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author zail
 * @date 2020/7/28
 */
public class BubbleSortDemo03 {
    
    public static void main(String[] args) {
        int[] arr = ArrayUtils.gen(10, 0, 10);
        System.out.println(Arrays.toString(arr));
        
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        
        // 把大的值往后移动
        for (int i = 0; i < arr.length; i++) {
            
            // 优化：记录如果二层循环已经没有可以互换的数字了，则直接返回即可
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    
                    flag = false;
                }
            }
            
            if (flag) {
                break;
            }
        }
        
        // 把小的值往前移动
        // for (int i = arr.length - 1; i < 0; i++) {
        //   for (int j = arr.length - 1; j < arr.length - i - 1; j++) {
        //     if (arr[j] > arr[j - 1]) {
        //       int t = arr[j];
        //       arr[j] = arr[j - 1];
        //       arr[j - 1] = t;
        //     }
        //   }
        // }
        
        return arr;
    }
}
