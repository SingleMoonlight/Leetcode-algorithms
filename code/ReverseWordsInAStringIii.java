//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 227 👎 0

package com.cute.leetcode.editor.cn;
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        //结果缓冲字符串
        StringBuffer res = new StringBuffer();
        //字符串的长度
        int len = s.length();
        //慢指针
        int i = 0;
        //快指针
        int j = 0;
        //由于题目明确指定字符串没有多余的空格，且每两个单词之间只有一个空格
        //所以可以取出每个单词并反转，添加到结果缓冲字符串里（其实还可以用Java自带的库函数 spilt() 来分割）
        while (j < len){
            if(s.charAt(j) == ' '){
                //取出独立的单词、翻转、添加
                res.append(new StringBuffer(s.substring(i, j)).reverse()).append(" ");
                //更新慢指针，准备取下一个单词
                i = j + 1;
            }
            //当遍历到最后一个字符时，肯定不是空格，所以要将最后一个单词单独取出
            if(j == len -1){
                //取出最后一个单词、翻转、添加
                res.append(new StringBuffer(s.substring(i)).reverse());
            }
            //快指针加1，比较下一个字符
            j++;
        }
        //返回结果字符串
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}