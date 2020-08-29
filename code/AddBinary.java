//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 461 👎 0

package com.cute.leetcode.editor.cn;
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        //n为a字符串的长度，m为b字符串的长度
        int n = a.length();
        int m = b.length();
        //结果缓冲字符串（按位相加得到的结果顺序是反的，最后需要反转）
        StringBuffer res = new StringBuffer();
        //进位位
        int carry = 0;
        //遍历逐个相加对齐的部分
        for(int i = n - 1, j = m - 1; i >= 0 && j >= 0; i-- , j--){
            //将字符转化为数字再相加
            // - '0' - '0' 就是为了让字符串a,b中的字符 ‘1’ 或 ‘0’ 的相加就是看起来的数字相加一样
            int num = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            //当前位计算结果
            res.append(num % 2);
            //进位位
            carry = num / 2;
        }
        //不对齐的部分单独添加
        if(n > m){
            for(int i = n - m - 1; i >= 0; i--){
                //将字符转化为数字再相加
                int num = a.charAt(i) - '0' + carry;
                //当前位计算结果
                res.append(num % 2);
                //进位位
                carry = num / 2;
            }
        }
        if(n < m){
            for(int i = m - n - 1; i >= 0; i--){
                //将字符转化为数字再相加
                int num = b.charAt(i)  - '0' + carry;
                //当前位计算结果
                res.append(num % 2);
                //进位位
                carry = num / 2;
            }
        }
        //如果最后进位位为1
        if(carry == 1){
            //添1补足即可
            res.append(carry);
        }
        //先反转，再转化为字符串，最后返回结果
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}