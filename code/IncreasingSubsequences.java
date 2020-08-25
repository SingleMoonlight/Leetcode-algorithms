//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 137 👎 0

package com.cute.leetcode.editor.cn;
public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //最终所有满足条件的子序列集合
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    //临时保存的子序列
    List<Integer> temp = new ArrayList<Integer>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        //从第1个数组元素开始遍历，初始上一个遍历的元素（此时并没有开始遍历）为最小整数值
        dfs(0, Integer.MIN_VALUE, nums);
        //返回结果集合
        return res;
    }

        //递归遍历
        //cur为正要遍历的数组元素索引（下标）
        //last为上一个遍历过的数组元素
        public void dfs(int cur, int last, int[] nums) {
        //当遍历的数组下标等于数组长度时，遍历结束（准确来说是下标加1等于数组长度，因为遍历结束时
            // 也就是递归进入最后一层时，cur = cur + 1）
            if (cur == nums.length) {
                //临时子序列长度大于2
                if (temp.size() >= 2) {
                    //就加入结果集合中
                    res.add(new ArrayList<Integer>(temp));
                }
                //遍历结束，返回
                return;
            }
            //如果当前元素（下标为cur）大于等于上一个遍历的元素（题目要求：等于也视为递增）
            if (nums[cur] >= last) {
                //将该元素加入临时子序列
                temp.add(nums[cur]);
                //接着递归遍历下一个数组元素，下标变为cur+1，num[cur]则变成上一个遍历过的元素
                dfs(cur + 1, nums[cur], nums);
                //执行上一句程序的时候，遍历会沿着数组从前往后，找到所有以当前元素为第一个元素的子序列
                //直到遍历到最后一个元素（此时temp临时序列达到满足条件下的最长情况，cur+1等于数组长度）
                //开始逐层回溯
                //每次回溯删除当前（也即最后一个）元素（元素下标为temp.size() - 1）
                temp.remove(temp.size() - 1);
            }
            //如果当前元素（下标为cur）不等于上一个遍历的元素
            if (nums[cur] != last) {
                //不将该元素加入临时序列，直接继续遍历，过程同上（去重）
                dfs(cur + 1, last, nums);
            }
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}