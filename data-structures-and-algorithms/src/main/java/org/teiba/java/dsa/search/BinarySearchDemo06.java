package org.teiba.java.dsa.search;

/**
 * @author zail
 */
public class BinarySearchDemo06 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int i = binarySearch(arr, 16);
        System.out.println(i);
    }
    
    /**
     * 二分查找
     *
     * @param arr    数组
     * @param target 查找的对象
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        // 边界问题
        if (arr == null || arr.length == 0)
            return -1;
        
        // l指向数组开始的位置，r指向数组结束的位置
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 在arr[l...mid-1]中查找target
            if (arr[mid] > target) {
                r = mid - 1;
            }
            // 在arr[mid+1...r]中查找target
            else if (arr[mid] < target) {
                l = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
