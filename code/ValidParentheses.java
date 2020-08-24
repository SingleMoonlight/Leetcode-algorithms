//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1811 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        //如果字符为奇数个，直接返回false
        if(s.length() % 2 == 1) return false;
        //如果字符串长度为0，直接返回true
        if(s.length() == 0) return true;
        //将字符串s转化为字符数组ch
        char[] ch = s.toCharArray();
        //创建栈stack
        Stack<Character> stack = new Stack<Character>();
        //向栈中加入任意一个元素，防止空栈（在后续进行括号比较的时候取栈顶元素非法（栈空））
        stack.push('>');
        //第一个数组元素进栈
        stack.push(ch[0]);
        for(int i = 1; i < s.length(); i++){
            //将栈顶元素与待进栈元素比较
            if((stack.peek() == '(' && ch[i] == ')') ||
               (stack.peek() == '[' && ch[i] == ']') ||
               (stack.peek() == '{' && ch[i] == '}'))
                //匹配则弹出栈顶元素
                stack.pop();
            //否则待比较元素进栈
            else stack.push(ch[i]);
        }
        //将防止空栈的元素">"出栈
        stack.pop();
        //判断栈是否为空，若为空返回true，否则返回false
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}