//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 291 👎 0

package com.cute.leetcode.editor.cn;
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //字符串的长度
        int n = s.length();
        //若s可由重复子串构成，最少需要重复两次，故遍历字符串的一半即可
        //i即为尝试枚举的子串长度，初始为1即第一个字符
        for (int i = 1; i <= n / 2; i++) {
            //如果字符个数能够整除子串长度
            //不能整除原字符串一定不能由该长度的子串重复构成
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    //类似周期函数，判断第j-i个字符是否与第j个字符相同
                    //出现不同就不能构成重复字符串，直接跳出循环
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}