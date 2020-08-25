// 7-reverse-integer
// 整数反转
// 2020-08-23 20:01:14
// 
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学 
// 👍 2120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        /**
         * reverse integer
         * 尾数为0的数字，反转后消除0。例如：1920 -> 291
         * 负数保留符号。李荣：-123 -> -321
         * 超出范围返回0。超出Integer规定的范围[-2^31, 2^31-1]，反转后返回0。
         *
         * x % 10 = x的最后一位数
         * x / 10 = x取余10后剩下的数字
         * 1. n作为转换后的数字，初始化为0
         * 2. 每次循环取出x的最后一个数字，例如123取出3
         * 3. n = n*10 + x%10。
         * n=0时，计算得出0*10+123%10=3；
         * n=2时，计算得出3*10+12%10=32；
         * n=1时，计算得出32*10+1%10=321；
         * 当x不等于0的时候就继续计算，当x小于10的时候，x/10=0
         * 由于全部都是数字计算，所以符号保留
         */
        long n = 0; // 因为要存储大于int范围的值，所以使用long存储
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)