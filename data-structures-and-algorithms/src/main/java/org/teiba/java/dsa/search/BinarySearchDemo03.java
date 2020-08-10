package org.teiba.java.dsa.search;

/**
 * @author zail
 */
public class BinarySearchDemo03 {
    
    /**
     * 二分查找
     * 查找第一个等于给定值的元素
     *
     * @param arr 给定的数组
     * @param val 查找的元素
     * @return 查找元素所在数组中的下标，若数组中不存在该元素则返回-1
     */
    public static int binarySearch(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            // 取中间值
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > val) {
                r = mid - 1;
            }
            else if (arr[mid] < val) {
                l = mid + 1;
            }
            else {
                /**
                 * 如果mid=0，往前看就越界了（肯定是要找的第一个元素了）
                 * 如果a[mid]前面的一个元素a[mid-1]也等于val，那说明此时的a[mid]
                 * 肯定不是要查找的第一个值为val的元素。要查找的元素肯定会出现在下标l...mid-1之中
                 */
                if (mid == 0 || arr[mid - 1] != val)
                    return mid;
                else
                    r = mid - 1;
            }
        }
        
        return -1;
    }
}
