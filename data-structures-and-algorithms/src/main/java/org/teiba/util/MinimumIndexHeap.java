package org.teiba.util;

/**
 * 最小索引堆的标准实现
 *
 * @author zail
 */
public class MinimumIndexHeap<T extends Comparable<T>> implements IndexHeap<T> {
    
    // 最小索引堆中的数据
    private T[] elementData;
    // 最小索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    private int[] indexes;
    // 最小索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    private int[] reverse;
    // 统计堆中元素的数量
    private int count;
    // 堆的大小
    private int capacity;
    
    /**
     * 构造函数，构造一个可以容纳capacity个元素的最小索引堆
     *
     * @param capacity 容量大小
     */
    public MinimumIndexHeap(int capacity) {
        elementData = (T[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++)
            reverse[i] = 0;
        
        count = 0;
        this.capacity = capacity;
    }
    
    @Override
    public void insert(int index, T data) {
        assert count + 1 <= capacity;
        assert index + 1 >= 1 && index + 1 <= capacity;
        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(index);
        
        index += 1;
        elementData[index] = data;
        indexes[count + 1] = index;
        reverse[index] = count + 1;
        count++;
    }
    
    @Override
    public void insert(T data) {
        insert(count, data);
    }
    
    @Override
    public T get() {
        assert count > 0;
        return elementData[indexes[1]];
    }
    
    @Override
    public T getByIndex(int index) {
        assert contain(index);
        return elementData[index + 1];
    }
    
    @Override
    public T extract() {
        assert count > 0;
        
        T result = elementData[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return result;
    }
    
    @Override
    public int extractIndex() {
        assert count > 0;
        
        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }
    
    @Override
    public void change(int index, T newData) {
        assert contain(index);
        index += 1;
        elementData[index] = newData;
        
        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp(reverse[index]);
        shiftDown(reverse[index]);
    }
    
    @Override
    public boolean contain(int index) {
        assert index + 1 >= 1 && index + 1 <= capacity;
        return reverse[index + 1] != 0;
    }
    
    @Override
    public void heapify() {
        shiftUp(count);
    }
    
    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftUp(int k) {
        while (k > 1 && elementData[indexes[k / 2]].compareTo(elementData[indexes[k]]) > 0) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }
    
    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && elementData[indexes[j + 1]].compareTo(elementData[indexes[j]]) < 0)
                j++;
            if (elementData[indexes[k]].compareTo(elementData[indexes[j]]) <= 0)
                break;
            swapIndexes(k, j);
            k = j;
        }
    }
    
    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }
    
    @Override
    public int size() {
        return count;
    }
    
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
}
