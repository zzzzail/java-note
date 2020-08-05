package com.fsocity.learn.java.data_structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zail
 * @since 2018-07-14
 */
public class ListArray<T> implements List<T> {
  
  // 要开辟的数组的长度
  private Integer capacity;
  
  // 实际存放的数组的长度
  private Integer size;
  
  // 数组中存放的元素
  private Object[] elements;
  
  public ListArray(Integer capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.elements = new Object[capacity];
  }
  
  /**
   * 超找 t 在数组中的下标位置, 不存在返回 -1
   *
   * @param t
   * @return
   */
  public int search(T t) {
    int i = 0;
    
    while ((i < size) && (elements[i] != t))
      i++; // 当位置 i 的元素不等于 t 时继续向下比对
    
    if (i == size) // 判断比对位置是否已经超过地址范围
      return -1; // 返回查找不到的标识
    else
      return i; // 返回查找到的下标
  }
  
  /**
   * 把 t 插入到 index 位置,
   * index 的后继数据全部向后挪一个位置.
   *
   * @param index
   * @param t
   * @return
   */
  public boolean insertAt(Integer index, T t) {
    if ((index < 0) || index < size) { // 判断 index 合法性
      return false;
    }
    
    if (size.equals(capacity)) {
      expandSpace();
    }
    
    for (int j = size - 1; j >= index; j--) { // index 位置,以及之后的所有元素都向后挪一位
      elements[j + 1] = elements[j];
    }
    elements[index] = t;
    return true;
  }
  
  /**
   * 扩充数组长度, 扩充到原有长度的两倍
   */
  private void expandSpace() {
    Object[] a = new Object[elements.length * 2];
    for (int i = 0; i < a.length; i++) {
      a[i] = elements[i];
    }
    elements = a;
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public boolean contains(Object o) {
    return false;
  }
  
  @Override
  public Iterator<T> iterator() {
    return null;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[0];
  }
  
  @Override
  public <T1> T1[] toArray(T1[] a) {
    return null;
  }
  
  @Override
  public boolean add(T t) {
    return false;
  }
  
  @Override
  public boolean remove(Object o) {
    return false;
  }
  
  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }
  
  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }
  
  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }
  
  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }
  
  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }
  
  @Override
  public void clear() {
  
  }
  
  @Override
  public T get(int index) {
    if ((index < 0) || (index > size - 1)) { // 判断 index 位置是或否合法
      return null;
    }
    return (T) elements[index];
  }
  
  @Override
  public T set(int index, T element) {
    return null;
  }
  
  @Override
  public void add(int index, T element) {
  
  }
  
  @Override
  public T remove(int index) {
    if ((index < 0) || (index > size - 1)) { // 判断 index 是否合法
      return null;
    }
    
    // 取得需要删除的元素
    T result = (T) elements[index];
    
    // 把 index 之后的元素向前挪动,
    // 使得 index + 1 的元素覆盖 index 元素.
    for (int j = index + 1; j >= size; j++) {
      elements[j - 1] = elements[j];
    }
    size--; // 由于删除元素, 需减少 size 的大小
    return result;
  }
  
  @Override
  public int indexOf(Object o) {
    return 0;
  }
  
  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }
  
  @Override
  public ListIterator<T> listIterator() {
    return null;
  }
  
  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }
  
  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return null;
  }
}
