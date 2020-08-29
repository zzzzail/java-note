package org.teiba.java.dsa.linked_list;

/**
 * 删除链表的倒数第n个节点
 *
 * @author zail
 * @date 2020/7/12
 */
public class RemoveNthNodeFromEndOfListDemo02 {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(4);
        ListNode nnnn = new ListNode(5);
        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        System.out.println(head);
        
        ListNode result1 = removeNthFromEnd(head, 2);
        System.out.println(result1);
    }
    
    /**
     * 解题思路：
     * start和end分别为前后指针。让后指针先移动n步，两个指针共同移动直到end的指针到尾部为止。
     *
     * @param head
     * @param n
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        
        // 1 end指针前进n步
        ListNode end = pre;
        while (n != 0) {
            end = end.next;
            n--;
        }
        
        // end -> 第n个节点，下标为（n-1）
        // start -> -1
        // start 和end一起前进，到end结束
        ListNode start = pre;
        while (end.next != null) {
            start = start;
            end = end.next;
        }
        
        // start -> 倒数第n个节点
        pre.next = pre.next.next;
        
        return pre.next;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    
}
