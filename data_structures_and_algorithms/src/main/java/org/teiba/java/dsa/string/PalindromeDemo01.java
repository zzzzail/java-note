package org.teiba.java.dsa.string;

/**
 * 判断字符串是否是回文字符串
 * 比如：上海自来水来自海上
 * 12321
 * 等等
 * 回文字符串的特点是：不管是从头开始读还是从结尾向前读，都是一样的。
 *
 * @author zail
 * @date 2020/7/11
 */
public class PalindromeDemo01 {
    
    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode nn = new ListNode(3);
        ListNode nnn = new ListNode(2);
        ListNode nnnn = new ListNode(1);
        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        
        boolean f = isPalindrome(head);
        System.out.println(f);
    }
    
    /**
     * 解题思路：
     * 使用快慢两个指针（fast、slow）找到链表中点，慢指针每次前进一步，快指针每次前进两步。
     * 在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。
     * 最后比较中点两侧的链表是否相等。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode prev = null;
        ListNode fast = head; // 快指针
        ListNode slow = head; // 慢指针
        
        // 12321
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // 如果
        if (fast != null) {
            slow = slow.next;
        }
        
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        
        return true;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
        }
    }
}
