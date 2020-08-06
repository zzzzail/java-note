// 234-palindrome-linked-list
// 回文链表
// 2020-07-29 10:59:39
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 576 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 实现思路：
 * 使用快慢两个指针（fast、slow）找到链表中点，慢指针每次前进一步，快指针每次前进两步。
 * 在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。
 * 最后比较中点两侧的链表是否相等。
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    
        if (head == null || head.next == null) {
            return true;
        }
    
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
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
    
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
