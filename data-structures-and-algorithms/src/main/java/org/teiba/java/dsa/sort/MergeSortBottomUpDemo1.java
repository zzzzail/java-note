package org.teiba.java.dsa.sort;

/**
 * 自底向上的归并排序
 *
 * @author zail
 * @date 2020/7/14
 */
public class MergeSortBottomUpDemo1 {
    
    public static void main(String[] args) {
        int total = 10_000_000;
        Integer[] arr = SortTestHelper.generateRandomArray(total, 0, total);
        SortTestHelper.testSort(MergeSortBottomUpDemo1.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 排序方法
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        
        int n = arr.length;
        
        // 对进行merge元素个数进行遍历
        for (int size = 1; size <= n; size += size) { // 1,2,4,8,16,32,...
            // 具体的在每一轮归并过程中，起始元素的位置
            // 0->size-1, size->2size-1; 2size->3size-1, 3size->4size-1; ...
            for (int i = 0; i + size < n; i += size + size) { // 0,2,4,6,8,...
                // 对arr[i...i+size-1]和arr[i+size...i+2*size-1]进行归并
                int l = i;
                int mid = i + size - 1;
                int r = Math.min(i + size + size - 1, n - 1);
                MergeSortDemo04.merge(arr, l, mid, r);
            }
        }
    }
    
}
