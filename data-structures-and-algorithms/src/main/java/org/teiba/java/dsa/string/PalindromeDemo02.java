package org.teiba.java.dsa.string;

import org.teiba.java.dsa.util.ArrayUtils;

/**
 * 判断是否是回文字符串
 *
 * @author zail
 * @date 2020/7/29
 */
public class PalindromeDemo02 {
    
    public static void main(String[] args) {
        
        String[] arr1 = new String[]{"上", "海", "自", "来", "水", "来", "自", "海", "上"};
        boolean flag1 = isPalindrome(arr1);
        System.out.println(flag1);
        
        String[] arr2 = new String[]{"日", "照", "老", "年", "人", "年", "老", "照", "日"};
        boolean flag2 = isPalindrome(arr2);
        System.out.println(flag2);
        
        String[] arr3 = new String[]{"1", "2", "3", "4", "1"};
        boolean flag3 = isPalindrome(arr3);
        System.out.println(flag3);
        
    }
    
    /**
     * 判断字符串数组是否为回文字符串
     * 例如：上海自来水来自海上，返回true
     * 12321，返回true
     * 解体思路：
     * 1. 计算数组是否可以被2整除，若可以被2整除，则直接返回false
     * 2. 计算数组的中心节点m，从中心节点分别向前遍历和向后遍历数组
     * 3. 比较前后遍历的值，若有不相等的，则直接返回false
     * 4. 比较完成，若全部相等，返回true
     *
     * @param arr
     * @return
     */
    public static boolean isPalindrome(String[] arr) {
        
        if (ArrayUtils.isEmpty(arr)) {
            return true;
        }
        
        // 1. 计算数组是否可以被2整除，若可以被2整除，则直接返回false
        if (arr.length % 2 == 0) {
            return false;
        }
        
        // 中心节点m
        int m = (arr.length >> 1) + 1;
        for (int i = 0, j = arr.length - 1; i < m && j >= m; i++, j--) {
            if (!arr[i].equals(arr[j])) {
                return false;
            }
        }
        
        return true;
    }
    
}
