package org.teiba.java.dsa.linked_list;

/**
 * 单链表
 *
 * @author zail
 * @date 2020/7/12
 */
public class SingleLinkedNode<T> {
    
    private T value;
    
    private SingleLinkedNode<T> next;
    
    public SingleLinkedNode() {
    }
    
    public SingleLinkedNode(T value, SingleLinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public SingleLinkedNode<T> getNext() {
        return next;
    }
    
    public void setNext(SingleLinkedNode<T> next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        SingleLinkedNode<T> p = this;
        boolean flag = true;
        while (flag) {
            str.append(p.getValue());
            p = p.getNext();
            if (p != null) {
                str.append(",");
            } else {
                flag = false;
            }
        }
        
        return "SingleLinkedNode{" + str.toString() + '}';
    }
}
