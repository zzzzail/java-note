package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡排序的核心思想就是每次循环都把要处理数中都最小值，放到前面去。
 *
 * @author zail
 * @date 2020/7/27
 */
public class BubbleSortDemo01 {
    
    public static void main(String[] args) {
        
        int[] arr1 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        arr1 = sort(arr1);
        System.out.println(Arrays.toString(arr1));
        
    }
    
    /**
     * 冒泡排序实现方法
     * 算法分析：
     * 时间复杂度：O(n^2)
     * 排序算法是否为原地排序：冒泡排序只涉及相邻数据的交换操作，只需要常量级的临时
     * 空间，所以它的空间复杂度为O(1)，是一个原地排序算法
     * 排序算法的稳定性：稳定
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        
        // 第一层循环
        for (int i = 0; i < arr.length; i++) {
            
            /**
             * 第二层循环
             * [9,8,7,6,5,4,3,2,1,0] length = 10
             * 0 -> 9
             * 0 -> 8
             * 0 -> 7
             * ...
             */
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            
        }
        
        return arr;
    }
}
