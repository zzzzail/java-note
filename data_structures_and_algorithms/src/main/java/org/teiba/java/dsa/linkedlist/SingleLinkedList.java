package org.teiba.java.dsa.linkedlist;

/**
 * @author zail
 * @date 2020/7/11
 */
public class SingleLinkedList<T> {
    
    // 头节点
    private SingleLinkedNode<T> head;
    
    // 插入操作
    public void add(T t) {
        if (t == null) {
            return;
        }
        
        SingleLinkedNode<T> node = new SingleLinkedNode<>(t, null);
        if (head == null) {
            head = node;
            return;
        }
        
        SingleLinkedNode<T> next = head;
        SingleLinkedNode<T> last = head;
        while (next != null) {
            last = next;
            next = last.getNext();
        }
        
        last.setNext(node);
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        SingleLinkedNode<T> pointer = head;
        boolean flag = true;
        while (flag) {
            s.append(pointer.getValue());
            pointer = pointer.getNext();
            if (pointer != null) {
                s.append(",");
            } else {
                flag = false;
            }
        }
        
        return "SingleLinkedList{" +
                s.toString() +
                '}';
    }
    
}
