package org.teiba.java.dsa.basic;

/**
 * @author zail
 * @date 2020/6/29
 */
public class StringDemo1 {
    
    public static void main(String[] args) {
        String a = new String("ss");
        String b = new String("ss");
        System.out.println("a.equals(b):" + a.equals(b));
        System.out.println("a == b:" + (a == b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
