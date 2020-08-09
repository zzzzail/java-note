// 75-sort-colors
// 颜色分类
// 2020-08-08 21:38:26
// 
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] arr) {
        // 边界问题
        if (arr.length <= 1) return;
        
        /**
         * 把数组arr分为三个区间：红色区域、白色区域、蓝色区域
         * i指针始终指向要处理的元素
         * lr指针指向红色区域最后一个元素
         * fb指针指向蓝色区域的第一个元素
         * r指针指向数组中最后一个元素
         * [0...rl] 为红色区域
         * [rl+1...i-1] 为白色区域
         * [fb...r] 为蓝色区域
         */
    
        // 初始 [-1...0] 为红色区域（该区域不存在）
        // 假设n=10，初始 [10...9] 为蓝色区域（该区域不存在）
        int i = 0, lr = -1, fb = arr.length;
        // 循环
        while (i < fb) {
            if (arr[i] == 1) { // 如果arr[i] == 1为白色，i++
                i++;
            }
            else if (arr[i] == 0) { // 如果arr[i] == 0为红色，则arr[i]和arr[lr+1]交换位置，lr++
                swap(arr, i, lr + 1);
                lr++;
                i++;
            }
            else { // 如果arr[i] == 2为蓝色，则arr[i]和arr[fb-1]交换位置，fb--
                swap(arr, i, fb - 1);
                fb--;
            }
        }
    }
    
    // 交换位置的方法
    private static void swap(int[] arr, int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
