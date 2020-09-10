//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 378 👎 0

package com.cute.leetcode.editor.cn;
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //结果集
        List<List<Integer>> results = new ArrayList<>();
        //一个可能的结果
        List<Integer> result = new ArrayList<>();
        //升序排序，便于去重
        Arrays.sort(candidates);
        //回溯求解
        backtrack(results, result, candidates, target,0, 0);
        //返回结果
        return results;
    }
        /**
         * 回溯算法
         *
         * result为结果集
         * result为一个合法的结果
         * index为正在遍历的数组元素下标
         * sum为已选元素累加和
         *
         */

        void backtrack(List<List<Integer>> results, List<Integer> result, int[] candidates, int target, int index, int sum){
            //回溯终止条件
            //当sum等于目标值，将该数组加入结果集
            if(sum == target){
                results.add(new ArrayList<>(result));
                return;
            }
            //如果已选数字累加和大于目标值，直接返回
            if(sum > target){
                return;
            }
            //遍历数组
            for(int i = index; i < candidates.length; i++){
                //初始已经将数组进行了升序排序，在遍历时，遇到相同的数可以直接跳过
                //因为上一个数字已经包含了当前所有合法的结果，再遍历该相同的数字就会产生重复
                if(i > index && candidates[i] == candidates[i -1]){
                    continue;
                }
                //将当前数字加入result
                result.add(candidates[i]);
                //继续向下回溯
                backtrack(results, result, candidates, target, i + 1, sum + candidates[i]);
                //回溯时，删除最后一个元素
                result.remove(result.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}