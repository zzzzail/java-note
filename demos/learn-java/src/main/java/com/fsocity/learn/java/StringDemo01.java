package com.fsocity.learn.java;

/**
 * @author zail
 */
public class StringDemo01 {
    
    public static void main(String[] args) {
        String s = "JavaWorld!";
        System.out.println(s.substring(4, 6));
        
        char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7'};
        String s2 = new String(chars, 2, 4);
        System.out.println(s2);
    }
}
