package org.teiba.java.dsa.linked_list;

/**
 * 删除链表倒数第n个节点
 *
 * @author zail
 * @date 2020/7/12
 */
public class DeleteTheLastNFromSingleLinkedListDemo {
    
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
        
        l1 = deleteLastN(l1, 3);
        System.out.println(l1);
    }
    
    /**
     * 删除倒数第n个节点
     * 暴力方法1：
     * 边界：如果n超过了链表的总节点数
     * 1. 统计链表有多少个节点
     * 2. index = total - n 的下一个节点就是要删除的节点
     * 3. 如果 index < 0 则直接返回链表
     * 4. 如果删除的是倒数第 total 个元素，也就是删除第一个元素，则直接返回l的下一个节点即可
     * 5. 否则，再次循环链表，并且记录i，当i遍历到index节点时，删除下一个节点，删除后直接返回该链表
     *
     * @param l 链表
     * @param n 倒数第n
     */
    public static SingleLinkedNode<Integer> deleteLastN(SingleLinkedNode<Integer> l, int n) {
        if (l == null) {
            return null;
        }
        
        if (n <= 0) {
            return l;
        }
        
        int total = 0;
        SingleLinkedNode<Integer> l1 = l;
        while (l1 != null) {
            ++total;
            l1 = l1.getNext();
        }
        
        int index = total - n;
        if (index < 0) {
            return l;
        }
        
        if (index == 0) {
            return l.getNext();
        }
        
        int i = 0;
        SingleLinkedNode<Integer> l2 = l;
        SingleLinkedNode<Integer> cur = l;
        SingleLinkedNode<Integer> next = l;
        SingleLinkedNode<Integer> head = cur;
        while (l2 != null) {
            ++i;
            if (i == index) {
                // 删除下一个节点
                next = l2.getNext().getNext();
                l2.setNext(next);
                cur = l2;
                l2 = next;
                return head;
            } else {
                cur = l2;
                l2 = l2.getNext();
            }
        }
        
        return head;
    }
    
}
