// 19-remove-nth-node-from-end-of-list
// 删除链表的倒数第N个节点
// 2020-07-31 11:37:07
// 
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 913 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 边界条件
        if (head == null) return head;
    
        // 前面的一个指针
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        
        // start和end指针
        ListNode start = pre;
        ListNode end = pre;
        
        // end指针先移动n个位置
        while (n != 0) {
            end = end.next;
            n--;
        }
        
        // start和end指针一起移动，直到end指针指向最后一个节点
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        
        // 删除倒数第n个节点
        start.next = start.next.next;
        
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
