package org.teiba.java.dsa.search;

import javax.xml.bind.annotation.XmlMimeType;

/**
 * @author zail
 */
public class BinarySearchDemo04 {
    
    /**
     * 二分查找
     * 查找最后一个给定的元素
     *
     * @param arr 数组
     * @param val 要查找的值
     * @return 要查找的值所在数组中的下标位置
     */
    public static int binarySearch(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        // 查找
        while (l <= r) {
            // 取中间值
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < val) {
                l = mid + 1;
            }
            else if (arr[mid] > val) {
                r = mid - 1;
            }
            else { // arr[mid] == val
                /**
                 * 想要查找最后一个给定的元素
                 * 判断是否是数组的最后一个元素，如果是则说明是要查找的最后一个元素
                 * 如果不是，则看一下mid后面一个元素是不是还等于val，如果不等于则说明mid就是最后一个给定的元素。
                 * 如果mid后面一个元素还等于val，则继续往后查找，直到查找到最后一个元素的位置为止。
                 */
                if (mid == arr.length - 1 || arr[mid + 1] != val)
                    return mid;
                else
                    l = mid + 1;
            }
        }
        
        return -1;
    }
}
