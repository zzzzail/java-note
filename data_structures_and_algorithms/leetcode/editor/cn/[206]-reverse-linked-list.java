// 206-reverse-linked-list
// 反转链表
// 2020-07-29 11:45:26
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 实现思路：
 * 使用两个指针，指针p始终指向要处理的节点，prev指针是反转的值
 * 利用next指针，使得p指针反转，并赋值到prev指针上
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) return head;
    
        ListNode p = head;
        ListNode prev = null;
    
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
