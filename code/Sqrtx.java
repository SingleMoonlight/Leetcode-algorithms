//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 485 👎 0

package com.cute.leetcode.editor.cn;
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {

        /*投机取巧做法
        return (int)(Math.sqrt(x));
        return (int)(Math.pow(x, 0.5));
         */

        //不使用库函数 之 二分法

        //初始区间[0 , x] , 结果赋初值-1
        int left = 0, right = x, res = -1;
        while(left <= right){
            //区间中值
            int mid = (right + left) / 2;
            //开始判断（防止mid * mid 溢出，将其转换为long型）
            if((long)mid * mid <= x){
                res = mid;
                //更新区间
                left = mid +1;
            }
            else {
                //更新区间
                right = mid - 1;
            }
        }
        //返回结果
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}