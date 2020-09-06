//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 364 👎 0

package com.cute.leetcode.editor.cn;
public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**康托展开
     *
     * 如n=5,x=96时：
     *
     * 首先用96-1得到95，说明x之前有95个排列.(将此数本身减去1)
     * 用95去除4! 得到3余23，说明有3个数比第1位小，所以第一位是4.
     * 用23去除3! 得到3余5，说明有3个数比第2位小，所以是4，但是4已出现过，因此是5.
     * 用5去除2!得到2余1，类似地，这一位是3.
     * 用1去除1!得到1余0，这一位是2.
     * 最后一位只能是1.
     * 所以这个数是45321.
     *
     * */
class Solution {
    public String getPermutation(int n, int k) {
        //用数组保存阶乘结果
        int[] factorial = new int[n];
        //0的阶乘为1
        factorial[0] = 1;
        //计算阶乘
        for(int i = 1; i < n; i++){
            factorial[i] = factorial[i - 1] * i;
        }
        //k使用前需要减一
        k = k - 1;
        //结果缓冲字符串
        StringBuffer ans = new StringBuffer();
        //定义valid数组用来保存1到n数字的使用状态
        int[] valid = new int[n + 1];
        //初始化为1，均未使用
        Arrays.fill(valid, 1);
        //开始选择，从第一位开始
        for(int i = 1; i <= n; i++){

            int order = k / factorial[n - i] + 1;
            for(int j = 1; j <= n; j++){
                //此步是为了防止选择了已经用过的数字
                order -= valid[j];
                //当order为0时，就找到了该位需要放置的数字
                if(order == 0){
                    //选择该数字（即j），加入结果字符串
                    ans.append(j);
                    //将该数字的使用状态改为0（已使用）
                    valid[j] = 0;
                    //跳出循环，选择下一位数字
                    break;
                }
            }
            //更新k
            k %= factorial[n - i];
        }
        //返回结果
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}