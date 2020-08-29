package org.teiba.java.dsa.linked_list;

/**
 * 两个有序的链表合并
 * 给出两个已经排序好的脸变，从大到小合并两个单链表的值。
 * 一般有两种解法：
 * 1. 递归法
 * 2. 非递归法
 *
 * @author zail
 * @date 2020/7/12
 */
public class MergeTwoSingleLinkedListDemo {
    
    public static void main(String[] args) {
        // 测试
        SingleLinkedNode<Integer> l1 = new SingleLinkedNode(1, null);
        SingleLinkedNode<Integer> n1 = new SingleLinkedNode<>(3, null);
        SingleLinkedNode<Integer> nn1 = new SingleLinkedNode<>(5, null);
        SingleLinkedNode<Integer> nnn1 = new SingleLinkedNode<>(7, null);
        SingleLinkedNode<Integer> nnnn1 = new SingleLinkedNode<>(9, null);
        l1.setNext(n1);
        n1.setNext(nn1);
        nn1.setNext(nnn1);
        nnn1.setNext(nnnn1);
        
        SingleLinkedNode<Integer> l2 = new SingleLinkedNode(2, null);
        SingleLinkedNode<Integer> n2 = new SingleLinkedNode(4, null);
        SingleLinkedNode<Integer> nn2 = new SingleLinkedNode(6, null);
        SingleLinkedNode<Integer> nnn2 = new SingleLinkedNode(8, null);
        SingleLinkedNode<Integer> nnnn2 = new SingleLinkedNode(10, null);
        l2.setNext(n2);
        n2.setNext(nn2);
        nn2.setNext(nnn2);
        nnn2.setNext(nnnn2);
        
        SingleLinkedNode<Integer> result = merge2(l1, l2);
        System.out.println(result);
    }
    
    /**
     * 两个有序链表合并成一个链表
     * 分析：
     * 1.边界条件：如果有任何一个链表为空，返回另一个不为空的链表
     * 2.选择一个头节点值较小的链表头作为新的head
     * 3.选择两个链表指针，cur1指向头节点较小的链表值，cur2指向另一个链表
     * 4.新建cur1的pre节点，和cur2的next节点，用来处理数据
     * 5.开始遍历，两个指针有一个为空，即终止遍历
     * 若cur1值小与等于cur2值，pre指向cur1当前值，并更新cur1指针指向cur1的下一个节点，进行下一次循环；
     * 否则，pre的next指针指向cur2，后将cur2的下一个节点指针指回cur1。
     * （因为我们始终认为cur1是小的，若下次循环的时候cur1是小的值时，则pre->cur1没有断链）。
     * 更新pre指针指向自身的下一个节点。
     * 更新cur2指针指向cur2的下一个节点（利用next）。
     * 6.将未添加的部分添加到pre.next
     *
     * @param l1
     * @param l2
     * @return
     */
    public static SingleLinkedNode<Integer> merge(SingleLinkedNode<Integer> l1, SingleLinkedNode<Integer> l2) {
        // 1.如果有任何一个链表为空，返回另一个不为空的链表
        if (l1 == null || l2 == null) {
            // 直接返回某一个不为null的链表
            return l1 != null ? l1 : l2;
        }
        
        // 2.选择一个头节点值较小的链表头作为新的head
        SingleLinkedNode<Integer> head = l1.getValue() <= l2.getValue() ? l1 : l2;
        // 3.选择两个链表指针，cur1指向头节点较小的链表值，cur2指向另一个链表
        SingleLinkedNode<Integer> cur1 = head == l1 ? l1 : l2;
        SingleLinkedNode<Integer> cur2 = head == l1 ? l2 : l1;
        
        // 4.新建cur1的pre节点，和cur2的next节点，用来处理数据
        SingleLinkedNode<Integer> pre = null;
        SingleLinkedNode<Integer> next = null;
        
        // 5.开始遍历，两个指针有一个为空，即终止遍历
        while (cur1 != null && cur2 != null) {
            // 我们始终认为cur1是小的节点
            if (cur1.getValue() <= cur2.getValue()) {
                pre = cur1;
                cur1 = cur1.getNext();
            } else {
                next = cur2.getNext();
                pre.setNext(cur2); // pre 的下一个节点是cur2
                cur2.setNext(cur1); // pre 的下一个节点的下一个节点是cur1
                pre = cur2;
                cur2 = next;
            }
        }
        
        // 追加上没有遍历的值
        pre.setNext(cur1 != null ? cur1 : cur2);
        
        return head;
    }
    
    public static SingleLinkedNode<Integer> merge2(SingleLinkedNode<Integer> l1, SingleLinkedNode<Integer> l2) {
        // 边界条件
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        // 要返回的头节点
        SingleLinkedNode<Integer> head = l1.getValue() <= l2.getValue() ? l1 : l2;
        
        SingleLinkedNode<Integer> cur1 = head == l1 ? l1 : l2;
        SingleLinkedNode<Integer> cur2 = head != l1 ? l1 : l2;
        
        SingleLinkedNode<Integer> pre = null;
        SingleLinkedNode<Integer> next = null;
        
        while (cur1 != null && cur2 != null) {
            if (cur1.getValue() <= cur2.getValue()) {
                pre = cur1;
                cur1 = cur1.getNext();
            } else {
                next = cur2.getNext();
                pre.setNext(cur2);
                cur2.setNext(cur1);
                pre = cur2;
                cur2 = next;
            }
        }
    
        pre.setNext(cur1 != null ? cur1 : cur2);
        
        return head;
    }
}
