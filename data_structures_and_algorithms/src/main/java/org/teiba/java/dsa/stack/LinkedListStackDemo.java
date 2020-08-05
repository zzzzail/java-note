package org.teiba.java.dsa.stack;

/**
 * @author zail
 */
public class LinkedListStackDemo {
    
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(2);
        boolean flag1 = stack.push("Hello, Zail!");
        System.out.println(flag1);
        boolean flag2 = stack.push("Hello, Rhea!");
        System.out.println(flag2);
        boolean flag3 = stack.push("Hello, World!");
        System.out.println(flag3);
        boolean flag4 = stack.push("Can I push to the stack?");
        System.out.println(flag4);
        
        String pop1 = stack.pop();
        System.out.println(pop1);
        
        System.out.println(stack);
    }
    
    
    static class LinkedListStack {
        // 链表的头节点
        LinkedListNode head;
        // 链表的大小
        int n;
        // 栈中元素的个数
        int count;
        
        public LinkedListStack(int n) {
            this.n = n;
        }
        
        public boolean push(String item) {
            if (count == n) {
                return false;
            }
            LinkedListNode node = new LinkedListNode(item);
            node.next = head;
            head = node;
            count++;
            return true;
        }
        
        public String pop() {
            String val = head.val;
            head = head.next;
            count--;
            return val;
        }
        
        @Override
        public String toString() {
            return "LinkedListStack{" +
                    "head=" + head +
                    ", n=" + n +
                    ", count=" + count +
                    '}';
        }
    }
    
    static class LinkedListNode {
        String val;
        LinkedListNode next;
        
        public LinkedListNode(String val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            return "LinkedListNode{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
    
    
}
