package org.teiba.java.dsa.queue;

/**
 * 环型队列
 *
 * @author zail
 * @date 2020/7/13
 */
public class CircularQueue {
    
    /**
     * 数组：items，数组大小：n
     */
    private String[] items;
    
    private int n = 0;
    
    /**
     * head表示队头下标，tail表示队尾下标
     */
    private int head = 0;
    
    private int tail = 0;
    
    /**
     * 申请一个大小为capacity的数组
     *
     * @param capacity
     */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    
    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满了 (tail+1)%n=head
        if ((tail + 1) % n == head) {
            return false;
        }
        
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }
    
    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
