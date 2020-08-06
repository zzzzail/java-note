package org.teiba.java.dsa.queue;

/**
 * 顺序队列
 *
 * @author zail
 * @date 2020/7/13
 */
public class ArrayQueue<T> {
    
    // 用数组实现的队列
    // 数组：items，数组大小：n
    private T[] items;
    
    private int n;
    
    // head表示队头下标，tail表示队尾下标
    private int head;
    
    private int tail;
    
    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        n = capacity;
    }
    
    // 入队
    public boolean enqueue(T item) {
        // 如果tail == n则表示队列已经满了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) {
                return false;
            }
            // 数据迁移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
            return false;
        }
        
        items[tail] = item;
        ++tail;
        return true;
    }
    
    // 出队
    public T dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        
        T ret = items[head];
        ++head;
        return ret;
    }
    
}
