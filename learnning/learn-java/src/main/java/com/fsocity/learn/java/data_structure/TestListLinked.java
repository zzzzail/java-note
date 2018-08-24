package com.fsocity.learn.java.data_structure;

import java.util.Random;

/**
 * @author zail
 * @since 2018-07-14
 */
public class TestListLinked {
  
  public static void main(String[] args) {
    // ListLinked<Integer> l = new ListLinked<>();
    //
    // Random random = new Random();
    // for (int i = 0; i < 100; i++) {
    //   l.addFromHead(random.nextInt());
    // }
    //
    // l.printAll();
  
    addFromTail();
  }
  
  // 尾插法插入链表中
  public static void addFromTail() {
    ListLinked<Integer> listLinked = new ListLinked<>();
    ListLinkedNode<Integer> tail = listLinked.getHead(); // tail 为尾指针
    Random random = new Random();
  
    for (int i = 0; i < 100; i++) {
      ListLinkedNode<Integer> node = new ListLinkedNode<>();
      node.setData(i);
      node.setNext(null);
      tail.setNext(node);
      tail = node;
    }
  
    listLinked.printAll();
    
    Integer s = listLinked.search(99);
    System.out.printf("搜索到 %d", s);
  }
}
