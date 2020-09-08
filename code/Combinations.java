//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 374 👎 0

package com.cute.leetcode.editor.cn;
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //结果集
        List<List<Integer>> results = new ArrayList<>();
        //一个组合
        List<Integer> result = new ArrayList<>();
        //回溯
        backtrack(results, n, k, 1, result);
        //返回结果集
        return results;
    }
        /**
         *  回溯算法
         *
         *  results为最终结果，
         *  result为每一个合法的组合，
         *  index为正在添加的数字
         *
         */

    void backtrack(List<List<Integer>> results, int n, int k, int index, List<Integer> result){
        //回溯终止（一个组合里已经有k个元素）
        if(k == 0){
            //添加到结果集
            results.add(new ArrayList<>(result));
            return;
        }
        //如果组合里的数字还不足k个
        if(k > 0){
            for(int i = index; i <= n; i++){
                //将i添加到组合里
                result.add(i);
                //继续向下回溯
                //还能添加的元素个数变为k-1，选择区间变成i+1到n
                backtrack(results, n, k - 1, i + 1, result);
                //回溯时，删除最后一个元素
                result.remove(result.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}