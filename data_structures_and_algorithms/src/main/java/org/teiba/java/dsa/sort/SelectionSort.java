package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序空间复杂度为 O(1)，是一种原地排序算法。选择排序的最好情况时间复杂
 * 度、最坏情况和平均情况时间复杂度都为 O(n2)。你可以自己来分析看看。
 * <p>
 * 选择排序是一种不稳定的排序算法。从我前面画的那张图中，你可以看出来，选择排
 * 序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳
 * 定性。
 * <p>
 * 比如 5，8，5，2，9 这样一组数据，使用选择排序算法来排序的话，第一次找到最
 * 小元素 2，与第一个 5 交换位置，那第一个 5 和中间的 5 顺序就变了，所以就
 * 不稳定了。正是因此，相对于冒泡排序和插入排序，选择排序就稍微逊色了。
 *
 * @author zail
 * @date 2020/7/13
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 选择排序
     * 1.找到数组中的最小值
     * 2.把最小值与数组的第一个0个元素交换
     * 以此类推
     * -------------------------------------------------------------------------------------------
     * |                                    10                         10 ----------↓
     * |  1   [ 10 9 7 5 4 3 1 ]    =>    [ 1 9 7 5 4 3 1 ]    =>    [ 1 9 7 5 4 3 10 ]
     * |        ↑------------|              ↑
     * | -----------------------------------------------------------------------------------------
     * |                                      9                           9-------↓
     * |  2   [ 1 9 7 5 4 3 10 ]    =>    [ 1 3 7 5 4 3 10 ]    =>    [ 1 3 7 5 4 9 10 ]
     * |          ↑-------|                   ↑
     * | -----------------------------------------------------------------------------------------
     * |                                       7                           7---↓
     * |  3  [ 1 3 7 5 4 9 10 ]    =>    [ 1 3 4 5 4 9 10 ]    =>    [ 1 3 4 5 7 9 10 ]
     * |           ↑---|                       ↑
     * | -----------------------------------------------------------------------------------------
     * |
     * |  4  ...
     * |
     * -------------------------------------------------------------------------------------------
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            
            // 寻找[i, n)区间中最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 交换i索引和minIndex索引的值
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
        
    }
    
}
