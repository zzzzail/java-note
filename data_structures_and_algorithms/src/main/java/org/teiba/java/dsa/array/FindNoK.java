package org.teiba.java.dsa.array;

import org.teiba.java.dsa.sort.BubbleSortDemo01;
import org.teiba.java.dsa.util.ArrayUtils;

import java.util.Arrays;

/**
 * 设一个数组有n个数，确定其中第k个最大者。我们称之为选择问题（selection problem）。
 *
 * @author zail
 * @date 2020/7/27
 */
public class FindNoK {
    
    public static void main(String[] args) {
        
        int n = 10000;
        int[] arr = ArrayUtils.gen(n, 0, n);
        System.out.println(Arrays.toString(arr));
        
        int k = 100;
        int arrk = solution2(arr, k);
        System.out.println(arrk);
        
    }
    
    /**
     * solution 1
     * 1. 使用冒泡排序把数组排序好
     * 2. 直接返回排序好的数组中第k个元素即可
     *
     * @param arr
     * @param k
     * @return
     */
    public static int solution1(int[] arr, int k) {
        arr = BubbleSortDemo01.sort(arr);
        return arr[k];
    }
    
    /**
     * solution 2
     * 1. 先把k个元素读入到数组中（以递减的顺序）对其排序
     * 2. 再将剩下的元素逐个读入。新元素被读取到时，如果它小于数组中的第k个元素则忽略之，否则就
     * 将其放到数组中正确的位置上，同时将数组中的一个元素挤出数组。
     * 3. 当算法终止时，位于第k个位置上的元素作为答案返回。
     * 时间、空间复杂度为 O(n*k)
     */
    public static int solution2(int[] arr, int k) {
        // 申请一个k + 1长度的数组
        int[] karr = new int[k];
        // 1. 先把k个元素读入到数组中
        for (int i = 0; i < k; i++) {
            karr[i] = arr[i];
        }
        // 排序该数组
        karr = BubbleSortDemo01.sort(karr);
        System.out.println(Arrays.toString(karr));
        for (int i = k; i < arr.length; i++) {
            
            for (int j = 0; j < karr.length; j++) {
                if (karr[j] > arr[i]) {
                    // 往后挪一个位置
                    insert(karr, j, arr[i]);
                    break;
                }
            }
            
        }
        System.out.println(Arrays.toString(karr));
        return karr[k - 1];
    }
    
    /**
     * 数组中插入数据
     *
     * @param arr   数组
     * @param index 下标
     * @param value 值
     * @return
     */
    public static int[] insert(int[] arr, int index, int value) {
        if (arr == null) {
            return null;
        }
        
        int cur = value;
        for (int i = index; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = cur;
            cur = t;
        }
        
        return arr;
    }
    
}
