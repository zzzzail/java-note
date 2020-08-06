// 141-linked-list-cycle
// 环形链表
// 2020-07-29 13:58:54
// 
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
// （索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针 
// 👍 692 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    // 解题思路2：
    public boolean hasCycle(ListNode head) {
    
        // 边界
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
    
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                return false;
            }
            
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
        }
    
        return false;
    }
    
    // 解题思路1：利用HashMap的key值唯一特性，判断链表中是否有换
    /*
    public boolean hasCycle(ListNode head) {
        
        // 边界
        if (head == null || head.next == null) {
            return false;
        }
        
        Map<ListNode, Object> map = new HashMap<>();
    
        ListNode p = head;
    
        while (p != null) {
            if (map.containsKey(p)) {
                return true;
            }
            map.put(p, null);
            p = p.next;
        }
    
        return false;
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
