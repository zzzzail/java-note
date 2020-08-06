package org.teiba.java.dsa.basic;

import java.util.List;

/**
 * @author zail
 * @date 2020/6/29
 */
public class ShiftOperatorsDemo2 {
    
    public static void main(String[] args) {
        
        int a = 10;
        /**
         * 左移动运算符：<<
         * 10 的二进制是 01010
         * 0*2^4 + 1 * 2^3 + 0*2^2 + 1*2^1 + 0*2^0
         * 第一组0*2^4：0是二进制对应位置的数字，2是固定的，4是二进制所在的位数从0开始数
         * 0 + 8 + 2 + 0 = 10
         *
         * 111111
         * 32 16 8 4 2 1
         *
         * 左移动运算符，移位为 1，右侧补0
         * 01010 => 10100
         * 10100 二进制转换成十进制为 20
         */
        System.out.println(a << 1);
        
        /**
         * 右移动运算符：>>
         *
         * 10 的二进制为 1010
         * 右移运算符，移位为 1
         * 1010 => 0101
         * 0101 二进制转换成十进制为 5
         *
         * 向有移动一位相当于 num / 2
         * @see java.util.Collections#reverse(List)
         * 设 size = 18
         * for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
         * i = 0; mid = 9; j = 17; i < mid true
         * i = 1; mid = 9; j = 16; i < mid true
         * i = 2; mid = 9; j = 15; i < mid true
         * i = 3; mid = 9; j = 14; i < mid true
         * i = 4; mid = 9; j = 13; i < mid true
         * i = 5; mid = 9; j = 12; i < mid true
         * i = 6; mid = 9; j = 11; i < mid true
         * i = 7; mid = 9; j = 10; i < mid true
         * i = 8; mid = 9; j = 9; i < mid true
         * i = 9; mid = 9; j = 9; i < mid false
         *
         * 循环9次
         */
        System.out.println(a >> 1);
        
    }
    
}
