package org.teiba.java.dsa.search;

/**
 * @author zail
 */
public class BinarySearchDemo05 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int i = search(arr, 16);
        System.out.println(i);
    }
    
    public static int search(int[] nums, int target) {
        // 边界问题
        if (nums == null || nums.length == 0)
            return -1;
        
        // 二分查找，l指向查找区域的左侧，r指向查找区域的右侧
        int l = 0, r = nums.length - 1;
        // 开始查找
        while (l <= r) {
            // 先取中间值
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
    
}
