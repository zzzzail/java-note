package com.fsocity.learn.java.data_structure;

/**
 * @author zail
 * @since 2018-07-14
 */
public class ListLinked<T> {
  
  // 头节点
  private ListLinkedNode<T> head;
  
  public ListLinked() {
    head = new ListLinkedNode<T>();
    head.setData(null);
    head.setNext(null);
  }
  
  public ListLinkedNode<T> getHead() {
    return head;
  }
  
  // 头插法插入链表中
  public void addFromHead(T data) {
    ListLinkedNode<T> node = new ListLinkedNode<>();
    node.setData(data);
    node.setNext(head.getNext()); // 设置新插入数据的下一节点为头结点的下一个节点(也就是第一个元素)
    head.setNext(node); // 设置头结点中的下一个节点为新插入的数据
  }
  
  /**
   *
   * @param i
   * @param e
   * @return
   */
  public boolean insertAt(int i, T e) {
    ListLinkedNode<T> q = head;
    int index = 0;
    while (q != null) {
      if (index == i - 1)
        break;
      
      q = q.getNext();
      
      index++;
    }
    
    if (index == i - 1) {
      ListLinkedNode<T> data = new ListLinkedNode<>();
      data.setData(e);
      // 把新节点设置下一个节点为 i 指针的节点的下一个节点,
      // 这时候新节点和 i 指针节点 q 的下一个节点是同一个
      data.setNext(q.getNext());
      // 设置 i 指针节点 q 的下一个节点为新节点, 这样就把节点连起来了
      q.setNext(data);
      return true;
    }
    return false;
  }
  
  public T search(T e) {
    ListLinkedNode<T> p = head.getNext();
    while (p != null && !p.getData().equals(e)) {
      p = p.getNext();
    }
    return p.getData();
  }
  
  // 删除节点
  public boolean remove(T e) {
    ListLinkedNode<T> q = head; // 查找到的节点
    ListLinkedNode<T> p = head.getNext(); // 下一个节点
    while ((p != null) && (!p.getData().equals(e))) { // 循环查找节点
      q = p; // 找到节点后, 把节点赋给 q
      p = p.getNext();
    }
    
    if (p == null)
      return false;
    
    q.setNext(p.getNext());
    return true;
  }
  
  public boolean remove(int i) {
    if (i < 0)
      return false;
    
    ListLinkedNode<T> q = head; // 查找到的节点
    ListLinkedNode<T> p = head.getNext(); // 下一个节点
    int index = 0;
    while ((p != null) && (index < i)) {
      q = p;
      p = p.getNext();
      index++;
    }
    if (index == i) {
      q.setNext(p.getNext());
      return true;
    }
    return false;
  }
  
  /**
   * 打印联表中所有的数据
   * 时间复杂度为 T(n) = O(n)
   */
  public void printAll() {
    ListLinkedNode<T> next = head.getNext();
    if (next == null) // 如果联表中为空, 则退出
      return;
    
    while (next != null) { // 直到下一个节点数据为 null 时, 停止循环
      System.out.println(next.getData().toString());
      
      next = next.getNext(); // link 到下一个节点继续循环
    }
  }
}
