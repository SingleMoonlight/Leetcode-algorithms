//给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家
//只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。 
//
// 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。 
//
// 
//
// 示例 1： 
//
// 输入：[1, 5, 2]
//输出：False
//解释：一开始，玩家1可以从1和2中进行选择。
//如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）
//可选。
//所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
//因此，玩家 1 永远不会成为赢家，返回 False 。
// 
//
// 示例 2： 
//
// 输入：[1, 5, 233, 7]
//输出：True
//解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
//     最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= 给定的数组长度 <= 20. 
// 数组里所有分数都为非负数且不会大于 10000000 。 
// 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。 
// 
// Related Topics 极小化极大 动态规划 
// 👍 243 👎 0

package com.cute.leetcode.editor.cn;
public class PredictTheWinner {
    public static void main(String[] args) {
        Solution solution = new PredictTheWinner().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        /*
        如果数组长度为偶数，先手必胜， 因为：先手可以提前观察数组的 偶数位置和 与 奇数位置和 哪个更大
        然后决定拿哪一个部分（逼迫另个玩家拿另一部分）
         */
        //if(nums.length % 2 == 0) return true;
        /*
        递归：自底向上
        让玩家每次取左边的数字或者右边的数字，然后先手环节加上该数字，对方环节减去该数字，
        最后得和为正说明玩家1赢
        当数组中剩下的数字多于 1 个时，当前玩家会选择最优的方案，使得自己的分数最大化，
        因此对两种方案分别计算当前玩家可以得到的分数，其中的最大值为当前玩家最多可以得到的分数
         */
        //赢过对手的得分大于等于0，玩家1就赢了
        //return total(nums, 0, nums.length - 1) >= 0;

        /*
        动态规划：
        用dp数组记录每次取数当前玩家能够赢过对手的分数
        其实就是记录了递归的每一步的结果，用空间换时间
        */

        //初始化dp数组
        //当i=j时，只有一个数字，当前玩家只能拿这个数字，所以dp[i][i] = nums[i]
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        //假如玩家1先取左端 nums[i]，那么玩家2能赢对方的差值是dp[i+1][j] ，如
        //果玩家1先取取右端 nums[j]，玩家2能赢对方的差值就是dp[i][j-1]
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
    /*
    计算每一步取数当前玩家赢过对手的分数
     */
        //数组当前剩下的部分为下标 start 到下标 end
        //当前玩家可以选择 nums[start] 或 nums[end]
        /*
        public int total(int[] nums, int start, int end) {
        //如果 start=end，则只剩一个数字，当前玩家只能拿这个数字，对手没得拿，就比对手多nums[start]分
            if (start == end) {
                return nums[start];
            }
            //选nums[start]当前先手得分与后手得分之差（当前玩家赢过对手的分数）
            int scoreStart = nums[start] - total(nums, start + 1, end);
            //选nums[End]当前先手得分与后手得分之差（当前玩家赢过对手的分数）
            int scoreEnd = nums[end] - total(nums, start, end - 1);
            //返回每次能赢过对手的最大值（两人都很聪明，每次选择肯定想赢得最大化）
            return Math.max(scoreStart, scoreEnd);
        }

         */
}
//leetcode submit region end(Prohibit modification and deletion)

}