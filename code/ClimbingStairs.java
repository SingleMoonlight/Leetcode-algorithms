//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1207 👎 0

package com.cute.leetcode.editor.cn;
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        /*
        到达当前台阶有两种方法，要么从上一级台阶走一步过来，要么从上上级台阶走两步过来
        设到达当前台阶的方法有a(n)种，那么a(n) = a(n-1) + a(n-2)

        结果就是斐波拉契数列
        n = 0, 1, 2, 3, 4, 5, 6, 7, 8,......
        结果 1, 1, 2, 3, 5, 8,13,21,34, ......

        递推公式：
        a(n) = a(n-1) + a(n-2)
        通项公式：
        double k = Math.sqrt(5); n = n + 1;
        return (int) ((Math.pow((1 + k) / 2, n) - Math.pow((1 - k) / 2, n)) / k + 0.5);
         */

        //斐波拉契数列的前一项和后一项，初始为第一、二项
        int fst = 1, scd = 1;
        //临时的后一项，初始为第一项
        int temp = 1;
        //从第二项开始，至第n项
        for(int i = 2; i <= n; i++){
            //后一项等于前两项相加
            temp = fst + scd;
            //更新，a(n-2) 变成 a(n-1)
            fst = scd;
            //更新，a(n-1) 变成现在的最后一项
            scd = temp;
        }
        //返回第n项
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}