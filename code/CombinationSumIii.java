//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 185 👎 0

package com.cute.leetcode.editor.cn;
public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //结果集
        List<List<Integer>> results = new ArrayList<>();
        //符合要求的一条结果
        List<Integer> result = new ArrayList<>();
        //回溯，从1开始
        backtrack(results, result, k, n, 0, 1);
        //返回结果
        return results;
    }
        /**
         * 回溯算法
         *
         * results为结果集
         * result为一个合法的结果
         * k为合法结果的元素个数
         * n为合法结果的元素累加和
         * sum为当前一个结果里的元素累加和
         * num为正在遍历的数字
         *
         */
        void backtrack(List<List<Integer>> results, List<Integer> result, int k, int n, int sum, int num){
            //回溯终止条件i
            //当sum等于目标值，且结果长度满足要求，将该数组加入结果集
            if(sum == n && result.size() == k){
                results.add(new ArrayList<>(result));
                return;
            }
            //
            for(int i = num; i <= 9; i++){
                //将当前数字加入result
                result.add(i);
                //继续回溯
                backtrack(results, result, k, n, sum + i,  i + 1);
                //回溯时，删除最后一个元素
                result.remove(result.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}