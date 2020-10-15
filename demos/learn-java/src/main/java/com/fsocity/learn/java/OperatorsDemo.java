package com.fsocity.learn.java;

import java.util.Arrays;

/**
 * @author zail
 */
public class OperatorsDemo {
    
    public static void main(String[] args) {
        int x = -100;
        // 算数左、右移符号不改变数字的符号
        // x << n = x * 2^n
        System.out.println(x << 1);
        System.out.println(x << 2);
        System.out.println(x << 3);
    
        // x >> n = x / 2^n
        System.out.println(x >> 1);
        System.out.println(x >> 2);
        System.out.println(x >> 3);
    
        // 逻辑右移动运算符，不能保证不改变原数的符号
        System.out.println(-10 >>> 1);
        System.out.println(-10 >>> 32);
    
    
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];
        /*
        src 源数组
        srcPos 源数组下标位置
        dest 目标数组
        destPos 目标数组下标位置
        length 克隆元素的个数
         */
        System.arraycopy(arr1, 0, arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
