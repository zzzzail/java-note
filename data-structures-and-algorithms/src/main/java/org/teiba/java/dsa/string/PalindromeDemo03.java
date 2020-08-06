package org.teiba.java.dsa.string;

/**
 * @author zail
 * @date 2020/7/29
 */
public class PalindromeDemo03 {
    
    public static void main(String[] args) {
        ListNode head = ListNode.of("上");
        ListNode n = ListNode.of("海");
        ListNode nn = ListNode.of("自");
        ListNode nnn = ListNode.of("来");
        ListNode nnnn = ListNode.of("水");
        ListNode nnnnn = ListNode.of("来");
        ListNode nnnnnn = ListNode.of("自");
        ListNode nnnnnnn = ListNode.of("海");
        ListNode nnnnnnnn = ListNode.of("上");
        head.next = n;
        n.next = nn;
        nn.next = nnn;
        nnn.next = nnnn;
        nnnn.next = nnnnn;
        nnnnn.next = nnnnnn;
        nnnnnn.next = nnnnnnn;
        // nnnnnnn.next = nnnnnnnn;
        
        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }
    
    /**
     * 判断链表是否为回文字符串
     * 解题思路：
     * 使用快慢指针（fast、slow）找到链表中心节点，慢指针每次前进一步，快指针每次前进两步。
     * 在慢指针前进的过程中，同时修改其next指针，使得链表的前半部分反序。
     * 最后比较中点两侧的链表是否相等。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // 三个指针 prev、slow、fast
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        // 判断
        while (slow != null) {
            if (!prev.val.equals(slow.val)) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    static class ListNode {
        String val;
        PalindromeDemo03.ListNode next;
        
        public ListNode(String val) {
            this.val = val;
        }
        
        public static ListNode of(String val) {
            return new ListNode(val);
        }
    }
}
