//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2348 👎 0

package com.cute.leetcode.editor.cn;
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //数组的长度
        int n = nums.length;
        //数组长度为0，直接返回
        if(n == 0) return 0;

        //存放 第一个数至当前位置 这个数组的最大子序和
        int[] temp = new int[n];
        /*暴力法：计算每一个数组元素从其开始累加到最后一个元素这个过程中的最大值，再求这些值里的最大值
        //存放从当前位置开始累加的值
        int[] sum = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
            for(int j = 0; j < i + 1; j++){
                    sum[j] += nums[i];
                if(sum[j] > temp[j]){
                    temp[j] = sum[j];
                }
            }
        }
         */
        //开始比较前，从第一个数开始累加的最大值就是数组的第一个数
        temp[0] = nums[0];
        //逐个遍历
        for(int i = 1; i < n; i++){
            //保持temp[i]一直是 数组前i+1个数中最大子序和 或者 第i+1个数 中较大的那个
            temp[i] = nums[i] > nums[i] + temp[i - 1] ? nums[i] : nums[i] + temp[i - 1];
        }

        //得每一个位置前的最大子序和，在求出其中最大的即为答案
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = max > temp[i] ? max : temp[i];
        }
        //返回结果
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}