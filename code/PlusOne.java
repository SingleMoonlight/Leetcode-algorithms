//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 529 👎 0

package com.cute.leetcode.editor.cn;
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        //获取数组的长度
        int len = digits.length;
        //进位（初始代表要加的 1）
        int carry = 1;
        for(int i = len - 1; i >= 0; i--){
            //保存当前位加进位
            int n = digits[i] + carry;
            //更新数组当前位，n除以十取余
            digits[i] = n % 10;
            //更新进位，n除以十
            carry = n / 10;
        }
        //如果最后的进位位为1，说明原数组数字全为9，加1后溢出
        if(carry == 1) {
            //重新定义一个数组，长度比原数组大1
            int[] res = new int[len + 1];
            //第一个数字一定是1，其他默认为0
            res[0] = 1;
            //直接返回
            return res;
        }
        //返回结果
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}