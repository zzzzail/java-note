package org.teiba.java.dsa.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author zail
 */
public class CountingSortDemo01 {
    
    public static void main(String[] args) {
        // 数据必须在0-10之间
        int[] a = {6, 1, 6, 9, 9, 1, 4, 2, 1, 5, 8, 8};
        int[] count = new int[10];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
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
