//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1228 👎 0

package com.cute.leetcode.editor.cn;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //如果字符串数组为空或者长度为0，直接返回""
        if (strs == null || strs.length == 0) {
            return "";
        }
        //由于最长公共前缀一定不会超过任意一个字符串的长度，故可以使用str[0]的长度来
        //做横向遍历的临界条件
        for(int i = 0; i < strs[0].length(); i++){
            //另字符c等于str[0]的每一个字符
            char c = strs[0].charAt(i);
            //遍历每一个字符串，将每一个字符串的第i个字符都与str[0]的第i个字符进行比较
            for(int j = 0; j < strs.length; j++){
                //如果str[j]的长度等于i（说明这个字符串太短了，等不了str[0]的每一位比
                //较完或者str[j]的第i个字符与c不相同
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //返回str[0]的前i个字符（即最大公共前缀）
                    return strs[0].substring(0, i);
                }

            }
        }
        //如果每个字符串均以str[0]为前缀，那么最大公共前缀就是str[0]
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}