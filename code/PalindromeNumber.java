//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1191 👎 0

package com.cute.leetcode.editor.cn;
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        //小于0的数一定不是回文数
        if(x < 0) return false;
        //初始化ans保存翻转后的数，num保存原来的数
        int ans = 0, num = x;
        while(x != 0){
            //每次取出x的最后一位
            int pop = x % 10;
            //去掉x的最后一位
            x = x / 10;
            //累加
            ans = ans * 10 + pop;
        }
        //如果翻转后与原数相等即为回文数
        if(ans == num) return true;
        else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}