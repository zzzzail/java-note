package org.teiba.java.dsa.sort;

/**
 * @author zail
 */
public class InsertionSortDemo03 {
    
    public static void main(String[] args) {
        int N = 10_00_000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort(InsertionSortDemo03.class, "sort", Integer[].class, arr);
        // System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 插入排序
     * 把数组分为两块区域，前面部分是排序好的区域，后面部分是为排序的区域。
     * 排序好的区域每次向后扩充一位，也就是说把未排序的区域第一位放到排序好的区域中对应的位置。
     * 依次类推直到数组排序完成
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        
        for (int i = 1; i < arr.length; i++) {
            
            int val = arr[i];
            int j = i - 1;
            
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j]; // 数据向后移动一位
                } else {
                    break;
                }
            }
            
            arr[j + 1] = val;
            
            // System.out.println("i=" + i + ":" + Arrays.toString(arr));
        }
        
    }
    
}
