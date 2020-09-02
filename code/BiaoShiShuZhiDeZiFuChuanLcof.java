//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 77 👎 0

package com.cute.leetcode.editor.cn;
public class BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        /*
        注：原码来自
        作者：dwqe
        链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/shi-yong-que-ding-you-xian-zi-dong-ji-dfashi-bie-s/
        看了大佬的题解才弄明白

        确定有限状态自动机：
        9种状态：
        1、前空格状态(初始状态)：识别全部前置(0个或多个)空格
        2、数值正负号状态：识别数字的正负号
        3、可接受整型数状态：识别并接受全部整型数
        4、无前缀小数状态：已识别小数点，之后必须紧跟数字
        5、可接受小数状态：识别并接受全部不包含幂次的小数
        6、幂次符号状态：识别幂次符号e或E
        7、幂正负号状态：识别幂的正负号
        8、可接受含幂小数状态：识别并接受整型的幂
        9、可接受后缀空格状态：识别并接受后缀空格
        其中初始状态为1，接受状态为3、5、8、9
         */
        Set<Integer> acceptSet = new HashSet<>();
        //将可以判定字符串为数字的状态（接受状态）加入set集合
        acceptSet.add(3);
        acceptSet.add(5);
        acceptSet.add(8);
        acceptSet.add(9);
        //初始状态为1
        int state = 1;
        //遍历每个字符，根据当前状态进行适当转移
        for (char ch : s.toCharArray()) {
            if (state == 1) {
                if (ch == ' ') {
                    state = 1;
                }
                else if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '+' || ch == '-') {
                    state = 2;
                }
                else if (ch == '.') {
                    state = 4;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 2) {
                if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '.') {
                    state = 4;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 3) {
                if (ch >= '0' && ch <= '9') {
                    state = 3;
                }
                else if (ch == '.') {
                    state = 5;
                }
                else if (ch == 'e' || ch == 'E') {
                    state = 6;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 4) {
                if (ch >= '0' && ch <= '9') {
                    state = 5;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 5) {
                if (ch >= '0' && ch <= '9') {
                    state = 5;
                }
                else if (ch == 'e' || ch == 'E') {
                    state = 6;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 6) {
                if (ch >= '0' && ch <= '9') {
                    state = 8;
                }
                else if (ch == '+' || ch == '-') {
                    state = 7;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 7) {
                if (ch >= '0' && ch <= '9') {
                    state = 8;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 8) {
                if (ch >= '0' && ch <= '9') {
                    state = 8;
                }
                else if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
            else if (state == 9) {
                if (ch == ' ') {
                    state = 9;
                }
                else {
                    state = -1;
                    break;
                }
            }
        }
        //若最终的状态在接受状态中，则返回true，否则返回false
        return acceptSet.contains(state);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}