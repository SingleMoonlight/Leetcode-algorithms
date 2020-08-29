//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串 
// 👍 223 👎 0

package com.cute.leetcode.editor.cn;
public class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new ShortestPalindrome().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {
        /*暴力法，会超时
        int len = s.length();
        int i = len;
        //将s转换为StringBuffer
        StringBuffer stringBuffer = new StringBuffer(s);
        //再逆序
        stringBuffer.reverse();
        while (i >= 0){
            stringBuffer.append(s.substring(i));
            if(isPalindrome(stringBuffer.toString())){
                return stringBuffer.toString();
            }
            else {
                stringBuffer.delete(len, len + len - i);
            }
            i--;
        }
        return "";
    }
    private boolean isPalindrome(String s){
        int len = s.length();
        int i = 0;
        while (i < len / 2){
            if(s.charAt(i) != s.charAt(len - 1 - i)){
                return false;
            }
            i++;
        }
        return true;

         */

        /*将原字符串翻转后接在原字符串前面一定会构成回文，但不是最短的，
        因为原字符串前有可能已经是回文的翻转后还是回文的，因此没有必要全部翻转
        只需找出原字符串最长的前缀回文子串，将剩余的字符串反转后接在原字符串的前面即可

        将原字符串翻转后接在原字符串后得到一个新字符串，而原字符串最长的前缀回文子串
        是这个新字符串的前缀和后缀(因为前缀回文的话，翻转是不变的)，而且是最长公共前后缀
        因此可以使用KMP算法求next[]数组，进而求出最长公共前后缀

        比如，假设原字符串为 ababc , 翻转接在原字符串后为 ababc#cbaba
        其最长公共前后缀为aba，同时也是原字符串的最长前缀回文子串
         */


        //将s转换为StringBuffer
        StringBuffer stringBuffer = new StringBuffer(s);
        //如果不加 #，'aaa'+'aaa'得到'aaaaaa'，求出的最长公共前后缀是 6，但其实是 3
        String str = s + '#' + stringBuffer.reverse().toString();
        //将s转化为字符数组（其实可以不用转，这里我偷懒套用了之前写的KMP算法，接口就是数组，就没改）
        char[] pattern = str.toCharArray();

        //用KMP算法求next数组(没有将首元素设为-1，再后移一位)
        int[] next = new int[pattern.length];
        //前缀表的第一个元素为0
        next[0] = 0;
        //已比较的字符串长度（最长公共前后缀）
        int len = 0;
        //正在比较的字符索引（下标）
        int i = 1;
        //当i等于字符串长度时循环结束
        while(i < next.length){
            //如果正在比较的元素与已经比较过的前缀的下一个字母相同
            if(pattern[i] == pattern[len]){
                //最长公共前后缀长度加1
                len++;
                //前缀表第i个元素即为最长公共前后缀长度
                next[i] = len;
                //继续比较
                i++;
            }
            //如果正在比较的元素与已经比较过的前缀的下一个字母不同
            //分两种情况
            else{
                //如果最长公共前后缀长度大于0，即已经比较到字符串中间了
                if(len > 0){
                    //回到 当前 最长公共前后缀的最后一个字符 的 最长公共前后缀的最后一个字符 处
                    len = next[len - 1];
                }
                //在字符串开始处
                else{
                    //即没有公共前缀，相应的前缀表元素为0（此时len = 0 ）
                    next[i] = len;
                    //继续比较
                    i++;
                }
            }
        }

        //得到最长公共前缀的长度（next数组的最后一个元素）
        int maxPre = next[next.length - 1];
        //截取非公共前缀部分
        String add = s.substring(maxPre);
        //反转
        StringBuffer ans = new StringBuffer(add).reverse();
        //接在s前面
        ans.append(s);
        //转换成字符串返回结果
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}