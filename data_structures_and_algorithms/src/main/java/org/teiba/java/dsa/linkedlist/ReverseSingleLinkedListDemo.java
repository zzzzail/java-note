package org.teiba.java.dsa.linkedlist;

/**
 * @author zail
 * @date 2020/7/12
 */
public class ReverseSingleLinkedListDemo {
    
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
        
        l1 = reverse(l1);
        System.out.println(l1);
    }
    
    /**
     * 单链表反转
     *
     * @param l
     * @return
     */
    public static SingleLinkedNode<Integer> reverse(SingleLinkedNode<Integer> l) {
        if (l == null || l.getNext() == null) {
            return l;
        }
        
        // 顺序循环，拼接成一个新的已反转的链表
        SingleLinkedNode<Integer> pointer = l;
        SingleLinkedNode<Integer> result = null;
        while (pointer != null) {
            SingleLinkedNode<Integer> next = pointer.getNext();
            pointer.setNext(result);
            result = pointer;
            pointer = next;
        }
        
        return result;
    }
    
}
