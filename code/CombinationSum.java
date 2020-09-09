//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 853 👎 0

package com.cute.leetcode.editor.cn;
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //结果集
        List<List<Integer>> results = new ArrayList<>();
        //一个可能的结果
        List<Integer> result = new ArrayList<>();
        //回溯求解
        backtrack(results, result, candidates, target,0);
        //返回结果
        return results;
    }
        /**
         * 回溯算法
         *
         * result为结果集
         * result为一个合法的结果
         * index为正在遍历的数组元素下标
         *
         * 每次选取数组里的一个数字，用target减去它，直到减为0，说明找到了一个合法的数组
         *
         */

        void backtrack(List<List<Integer>> results, List<Integer> result, int[] candidates, int target, int index){
            //回溯终止条件
            //当所有数字遍历完
            if(index == candidates.length){
                return;
            }
            //当target减为0，将该数组加入结果集
            if(target == 0){
                results.add(new ArrayList<>(result));
                return;
            }
            //直接跳过
            backtrack(results, result, candidates, target, index + 1);
            //target还未减为0
            if(target - candidates[index] >= 0){
                //将该数添加到result
                result.add(candidates[index]);
                //继续回溯
                //每个数字可以被无限制重复选取，因此搜索的下标不变
                backtrack(results, result, candidates, target - candidates[index], index);
                //回溯时，删除最后一个元素
                result.remove(result.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}