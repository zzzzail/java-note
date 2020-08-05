package org.teiba.java.dsa.basic;

/**
 * 异或，英文为exclusive OR，缩写成xor异或（xor）是一个数学运算符。
 *
 * @author zail
 * @date 2020/6/29
 */
public class ExclusiveORDemo1 {
    
    public static void main(String[] args) {
        
        /**
         * 位异或运算（^）
         *
         * 运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
         *
         * 比如：8^11.
         *
         * 8转为二进制是1000，11转为二进制是1011.从高位开始比较得到的是：0011.
         * 然后二进制转为十进制，就是Integer.parseInt("0011",2)=3;
         */
        int a = 8 ^ 11;
        System.out.println(a);
        
    }
    
}
