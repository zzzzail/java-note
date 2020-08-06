package org.teiba.java.dsa.heap;

/**
 * @author zail
 * @date 2020/7/14
 */
public class MaxHeapDemo {
    
    public static void main(String[] args) {
        
        MaxHeapItem<Integer> item = new MaxHeapItem(10);
        System.out.println(item.size());
        
    }
    
    
    static class MaxHeapItem<T> {
        
        // 存储数据
        private T[] data;
        
        // 总数
        private int count;
        
        public MaxHeapItem(int capacity) {
            // 因为数组存储堆数据，是从下标1开始的，所以这里要加1
            data = (T[]) new Object[capacity + 1];
            this.count = 0;
        }
        
        /**
         * 返回堆的大小
         *
         * @return
         */
        public int size() {
            return count;
        }
        
        /**
         * 判断堆是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }
        
    }
    
}
