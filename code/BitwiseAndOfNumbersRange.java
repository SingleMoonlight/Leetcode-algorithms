//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 212 👎 0

package com.cute.leetcode.editor.cn;
public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /*
        原理：对于一系列的位，只要有一个零值的位，那么这一系列位的按位与运算结果都将为零
        从m到n得所有整数转换为二进制后，将每个二进制字符串的位置对齐，可以发现，对所有数
        字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位

        例如：m=9, n=12
        9       0 0 0 0 1 | 0 0 1
        10      0 0 0 0 1 | 0 1 0
        11      0 0 0 0 1 | 0 1 1
        12      0 0 0 0 1 | 1 0 0
        按位与  0 0 0 0 1 | 0 0 0
         */
        //记录移位
        int shift = 0;
        //将m和n右移一位，直到m=n
        while(m < n){
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        //将m左移移shift位得到结果
        return m << shift;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}