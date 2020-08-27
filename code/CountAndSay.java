//给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。 
//
// 注意：整数序列中的每一项将表示为一个字符串。 
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 第一项是数字 1 
//
// 描述前一项，这个数是 1 即 “一个 1 ”，记作 11 
//
// 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21 
//
// 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211 
//
// 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。 
// Related Topics 字符串 
// 👍 530 👎 0

package com.cute.leetcode.editor.cn;
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        //「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述
        //所以要求第n个外观数列就得先求出第n-1个外观数列才能进行描述
        //故采用递归方式求解

        //基本样例，当n=1时，输出1
        if(n == 1) return "1";

        //定义第n-1个外观数列为str
        String str = countAndSay(n-1);
        //第n个外观数列
        StringBuffer res = new StringBuffer();
        //求解该数列则采用双指针的方法
        //字符串长度
        int len = str.length();
        //慢指针
        int i = 0;
        //快指针
        for (int j = 1; j <= len; j++) {
            // 在j所指元素与i所指元素相同时，无需执行任何操作
            //在for循环中j一直向前，i不动，j-i即记录了相同元素重复的次数

            //当j指向字符串的最后一个元素时，该字符串遍历结束
            if (j == len) {
                //j-i为相同元素重复的次数，str.charAt(i)为该重复的元素
                res.append(j - i).append(str.charAt(i));
            }
            //遍历数组，快指针在前，找到不重复的元素
            else if (str.charAt(j) != str.charAt(i) ) {
                //j-i为相同元素重复的次数，str.charAt(i)为该重复的元素
                res.append(j - i).append(str.charAt(i));
                //更新慢指针的位置，指向下一个不与当前元素重复的元素
                i = j;
            }
        }
        //返回结果
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}