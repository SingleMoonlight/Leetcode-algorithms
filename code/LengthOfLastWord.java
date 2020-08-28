//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 238 👎 0

package com.cute.leetcode.editor.cn;
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        //该字符串的长度
        int length = s.length();
        //长度为0直接返回0
        if(length == 0) return 0;
        //计数
        int count = 0;
        //从右往左逐个遍历字符串（i可以为0）
        for(int i = length -1; i >= 0; i--){
            //入果最后的字符为空格就一直循环，直到找到第一个不为空格的字符
            //count开始计数，每找到一个不为空格的字符count加1
            //直到找到下一个为空格的字符，此时count即最后一个单词的长度
            if(s.charAt(i) != ' '){
                count++;
            }
            //如果统计出count不为0，即存在最后一个单词，直接返回count，不需要继续循环
            else if(count != 0){
                return count;
            }
        }
        //返回结果
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}