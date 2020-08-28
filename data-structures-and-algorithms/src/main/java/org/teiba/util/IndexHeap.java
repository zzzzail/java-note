package org.teiba.util;

/**
 * 带有索引的堆
 *
 * @author zail
 */
public interface IndexHeap<T extends Comparable<T>> extends Heap<T> {
    
    /**
     * 插入
     *
     * @param index
     * @param data
     */
    void insert(int index, T data);
    
    /**
     * 通过索引获取元素
     *
     * @param index 索引下标
     * @return 获取堆中的元素
     */
    T getByIndex(int index);
    
    /**
     * 获取堆顶元素的下标索引
     *
     * @return
     */
    int extractIndex();
    
    /**
     * 改变堆中下标为index的值
     *
     * @param index   下标
     * @param newData 新值
     */
    void change(int index, T newData);
    
    /**
     * 判断该索引是否有值
     *
     * @return 是否有值
     */
    boolean contain(int index);
    
}
