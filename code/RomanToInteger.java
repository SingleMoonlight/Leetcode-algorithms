//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 999 👎 0

package com.cute.leetcode.editor.cn;
public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        //初始化最后结果
        int ans = 0;
        //获得前一个字母的数值（在此即是第一个）
        int fstNum = getValue(s.charAt(0));
        //遍历每一个字母
        for(int i = 1; i < s.length(); i++){
            //获取后一个字母的数值
            int sedNum = getValue(s.charAt(i));
            //如果第一个字母的数值小于第二个字母的数值
            if(fstNum < sedNum) {
                //那么在该位的数值需要被总和减去
                ans -= fstNum;
            }
            //否则就加上
            else {
                ans += fstNum;
            }
            //将后一个字母代表的数值赋给fstNum（下一次比较的前一个）
            fstNum = sedNum;
        }
        //由于最后一个字母不需要比较，最终结果需要直接加上最后一个字母的数值
        //在循环结束时已经将sedNum赋给了fstNum，此时fstNum即为最后一个字母的数值
        ans += fstNum;
        return ans;
    }
    //用于获得罗马数字对应的数值
        private int getValue(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}