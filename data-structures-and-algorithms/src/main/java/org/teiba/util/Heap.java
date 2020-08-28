package org.teiba.util;

/**
 * 堆数据结构的接口
 *
 * @author zail
 */
public interface Heap<T extends Comparable<T>> {
    
    /**
     * 入堆
     *
     * @param data 入堆中的新数据
     */
    void insert(T data);
    
    /**
     * 获取堆顶的第一个元素
     *
     * @return 堆顶的第一个元素
     */
    T get();
    
    /**
     * 取出栈顶中的第一个元素，并删除
     *
     * @return 取出的元素
     */
    T extract();
    
    /**
     * 堆化方法
     */
    void heapify();
    
    /**
     * 堆的大小
     *
     * @return 堆的大小
     */
    int size();
    
    /**
     * 返回堆是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();
}
