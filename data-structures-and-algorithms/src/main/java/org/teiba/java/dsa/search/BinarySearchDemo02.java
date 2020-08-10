package org.teiba.java.dsa.search;

/**
 * @author zail
 */
public class BinarySearchDemo02 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i1 = search(arr, 9);
        System.out.println(i1);
        
        int i2 = searchByRecursion(arr, 3);
        System.out.println(i2);
    }
    
    public static int search(int[] arr, int val) {
        // 非递归实现
        int l = 0;
        int r = arr.length - 1;
        
        // 结束条件是 l >= r
        while (l <= r) {
            int mid = l + ((r - l) >> 1); // 取中间值
            if (arr[mid] == val) {
                return mid;
            }
            else if (arr[mid] < val) {
                l = mid + 1;
            }
            else if (arr[mid] > val) {
                r = mid - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * 递归实现二分查找
     *
     * @param arr 要查找的数组
     * @param val 查找的元素
     * @return 查找元素所在数组中的下标位置，如果返回-1则说明元素在数组中不存在
     */
    public static int searchByRecursion(int[] arr, int val) {
        return searchByRecursion(arr, 0, arr.length - 1, val);
    }
    
    public static int searchByRecursion(int[] arr, int l, int r, int val) {
        // 递归的结束条件
        if (l > r) return -1;
        
        int mid = l + ((r - l) >> 1); // 计算中间值
        if (arr[mid] < val) {
            l = mid + 1;
            return searchByRecursion(arr, l, r, val);
        }
        else if (arr[mid] > val) {
            r = mid - 1;
            return searchByRecursion(arr, l, r, val);
        }
        else { // arr[mid] == val
            return mid;
        }
    }
    
}
