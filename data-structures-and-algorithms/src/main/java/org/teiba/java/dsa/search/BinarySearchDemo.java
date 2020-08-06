package org.teiba.java.dsa.search;

/**
 * @author zail
 * @date 2020/7/15
 */
public class BinarySearchDemo {
    
    /**
     * 二分查找法
     *
     * @param arr
     * @return
     */
    public int binarySearch(int[] arr, int val) {
        
        int n = arr.length;
        
        int l = 0;
        int r = n - 1;
        
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            
            if (arr[mid] >= val) {
                r = mid - 1;
            } else if (arr[mid] < val) {
                l = mid + 1;
            }
        }
        
        if (l <= n && arr[l] == val) {
            return l;
        } else {
            return -1;
        }
    }
    
}
