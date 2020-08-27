package org.teiba.java.dsa.stack;

import java.util.Stack;

/**
 * @author zail
 */
public class StackDemo01 {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(8);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
