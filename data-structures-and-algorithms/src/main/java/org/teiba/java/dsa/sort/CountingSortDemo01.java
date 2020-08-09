package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 时间复杂度为O(n + m)m为计数的数量
 * 空间复杂度为O(n)
 *
 * @author zail
 */
public class CountingSortDemo01 {
    
    public static void main(String[] args) {
        // 数据必须在0-10之间
        int[] a = {6, 1, 6, 9, 9, 1, 4, 2, 1, 5, 8, 8};
        int[] count = new int[10];
        for (int j : a) {
            count[j]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                a[index] = i;
                index++;
                count[i]--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
