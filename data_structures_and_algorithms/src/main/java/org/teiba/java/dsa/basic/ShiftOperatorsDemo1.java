package org.teiba.java.dsa.basic;

/**
 * @author zail
 * @date 2020/6/30
 */
public class ShiftOperatorsDemo1 {
    
    public static void main(String[] args) {
        /**
         * Java中的位运算符：
         *
         * >>表示右移bai，如果该du数为正，则高位补0，若为负数，zhi则高位补1；
         * >>>表示无符号右dao移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
         */
        int a = 10;
        System.out.println(a >>> 1);
        
        /**
         * https://www.cnblogs.com/qubaba/p/11558127.html
         * |= 符号
         * a = a | b
         * a = 10 的二进制为 1010
         * b = 5 的二进制为 0101
         * 结果为 1111，转换成十进制为 15
         *
         * 10000 |= 01000 = 11000 = 24
         * 11111 |= 00001 = 11111 = 31
         */
        
    }
}
