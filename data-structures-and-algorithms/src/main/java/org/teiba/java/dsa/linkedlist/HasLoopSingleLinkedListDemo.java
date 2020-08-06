package org.teiba.java.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表中，环的检测
 *
 * @author zail
 */
public class HasLoopSingleLinkedListDemo {
    
    public static void main(String[] args) {
        // 测试
    }
    
    /**
     * 2.链表中，环的检测（检测该链表中有没有形成一个环）
     * ------------------------------------
     * ｜   1 —> 2 -> 3 -> 4 -> 5 -
     * ｜             ↑           ｜
     * ｜             --- 7 <- 6 <-
     * ｜----------------------------------
     * 上图中 5 -> ... -> 3 形成了一个闭环
     * 解决思路1：快慢指针法
     * 有两个指针fast、slow，同时从头节点开始往下遍历链表中的所有节点
     * slow是慢指针，一次遍历一个节点
     * fast是快指针，一次遍历两个节点
     * 如果链表中没有环，slow和fast会先后遍历完成所有节点。
     * 如果链表中有环，slow和fast则会先后进入环中，一直循环，并一定会在某一次遍历中相遇。
     * 因此，只要发现slow和fast相遇了，就可以判定链表中存在环。
     */
    public static boolean hasLoop1(SingleLinkedNode<Integer> l) {
        if (l == null || l.getNext() == null) {
            return false;
        }
        
        SingleLinkedNode<Integer> fast = l;
        SingleLinkedNode<Integer> slow = l;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            if (fast == null) {
                return false;
            }
            if (fast.getValue().equals(slow.getValue())) {
                return true;
            }
            slow = slow.getNext();
        }
        
        return false;
    }
    
    /**
     * 解决思路2：足迹法
     * 利用HashMap的键唯一的特性，如果接下来的某个节点出现了两次，则说明该链表是有环的。
     *
     * @param l
     * @return
     */
    public static boolean hasLoop2(SingleLinkedNode<Integer> l) {
        if (l == null || l.getNext() == null)
            return false;
        
        
        Map<Integer, Object> map = new HashMap<>();
        
        SingleLinkedNode<Integer> p = l;
        while (p != null) {
            if (map.containsKey(p.getValue())) {
                return true;
            }
            map.put(p.getValue(), p);
            p = p.getNext();
        }
        
        return false;
    }
}
