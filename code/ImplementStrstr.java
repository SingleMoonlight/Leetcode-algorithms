//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 542 👎 0

package com.cute.leetcode.editor.cn;
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        //双指针，i指向 haystack 字符串的每一个字符，j指向 needle 字符串的每一个字符
        //初始都指向第一个字符
        int i = 0;
        int j = 0;
        //当指针溢出时（超过最后一个字符）比较结束
        while(i < haystack.length() && j < needle.length()){
            //如果haystack中下标为i的元素与needle中下标为j的元素相同
            if(haystack.charAt(i) == needle.charAt(j)){
                //指针分别向后移动，继续进行比较
                //直到出现不同
                i++;
                j++;
            }
            //出现不同后
            else {
                //将指针i回退至haystack中还未比较的字符位置
                i = i - j + 1;
                //将指针j再次初始化，指向needle的第一个字符
                j = 0;
            }
        }
        //如果遍历完还未出现不同的情况，即找到了needle在haystack中的位置
        //当j指向needle最后一个字符时，遍历结束
        if (j == needle.length())
            //此时i指向haystack中与needle子串相同的最后一字符
            //i-j即表示needle子串在haystack中第一次出现的位置
            return i - j;
        else
            return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}