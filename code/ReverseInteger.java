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
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2115 👎 0

package com.cute.leetcode.editor.cn;
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        //初始化反转后的数
        int ans = 0;
        while(x != 0)
        {
            //取出x的最后一位
            int pop = x % 10;
            //去掉x的最后一位
            x = x / 10;
            //如果ans大于Integer.MAX_VALUE / 10或者ans == Integer.MAX_VALUE / 10 && pop > 7)时
            //ans * 10 + pop一定溢出了
            //7是2^31 - 1的个位数
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            //如果ans小于Integer.MIN_VALUE / 10或者ans == Integer.MIN_VALUE / 10 && pop < -8)时
            //ans * 10 + pop一定溢出了
            //8是-2^31的个位数
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            //累加
            ans = ans * 10 + pop;
        }
        return ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}