package org.teiba.java.dsa.linkedlist;

/**
 * 求链表的中间节点
 *
 * @author zail
 * @date 2020/7/12
 */
public class FindCentralNodeFromSingleLinkedListDemo {
    
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
        
        l1 = getCentralNode2(l1);
        System.out.println(l1);
    }
    
    /**
     * 返回链表的中间节点
     * 1. 统计链表有多少个节点
     * 2. c = total >> 1
     * 3. 循环链表返回第c个节点
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     *
     * @param head
     * @return
     */
    public static SingleLinkedNode<Integer> getCentralNode(SingleLinkedNode<Integer> head) {
        if (head == null) {
            return null;
        }
        
        int total = 0;
        SingleLinkedNode<Integer> l1 = head;
        while (l1 != null) {
            ++total;
            l1 = l1.getNext();
        }
        
        int c = total >> 1;
        System.out.println(c);
        int i = 0;
        SingleLinkedNode<Integer> l2 = head;
        while (l2 != null) {
            if (i == c) {
                return l2;
            }
            l2 = l2.getNext();
            ++i;
        }
        
        return head;
    }
    
    
    /**
     * 方法2：快慢指针法
     * fast为快指针，每次前进两步
     * slow为满指针，每次前进一步
     * 当fast指针循环完成的时候，slow刚好是中间值
     * <p>
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     */
    public static SingleLinkedNode<Integer> getCentralNode2(SingleLinkedNode<Integer> l) {
        if (l == null) {
            return null;
        }
        
        SingleLinkedNode<Integer> fast = l;
        SingleLinkedNode<Integer> slow = l;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        
        return slow;
    }
}
