package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * @author zail
 */
public class BubbleSortDemo04 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 冒泡排序
     *
     * 1. 冒泡排序是原地排序算法吗？
     * 是，因为冒泡排序只涉及到数组中两个相邻的数据比对，并没有申请一个新的数组。所以冒泡排序的空间复杂度为O(1)。
     * 是一个原地排序算法。
     * 2. 冒泡排序是稳定的排序算法吗？
     * 在冒泡排序中，只有交换才可以改变两个元素的前后顺序。为了保证冒泡排序的稳定性，当有相邻的两个元素大小相等时，
     * 我们不做交换，相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
     * 3. 冒牌排序的时间复杂度
     * O(n^2)
     * 最好情况下，要排序的数据已经是有序的了，我们只需要进行一次冒泡排序操作，就可以结束了。
     * 所以最好情况复杂度为O(n)。
     * 而最坏情况下，要排序的数据刚好是倒序排列的，我们需要进行n次冒泡操作，所以最坏时间复杂度为O(n^2)。
     * 平均时间复杂度为O(n^2)
     *
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            
            // 冒泡排序存在提前结束的情况。一次排序中没有一次交换数据，则整个数组就是有序的。
            boolean flag = true;
            
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    flag = false;
                }
            }
            System.out.println("i=" + i + ": " + Arrays.toString(arr));
            
            if (flag)
                break;
        }
        
        return arr;
    }
    
}
