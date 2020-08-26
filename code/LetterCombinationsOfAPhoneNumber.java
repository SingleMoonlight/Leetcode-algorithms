//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 853 👎 0

package com.cute.leetcode.editor.cn;
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        //DFS回溯

        //所有字母组合结果集
        List<String> res = new ArrayList<String>();
        //如果字符串长度为0直接返回空集
        if (digits.length() == 0) {
            return res;
        }
        //哈希表：每个数字对应的字母
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        //dfs
        dfs(res, phoneMap,0, digits, new StringBuffer());
        //返回结果集
        return res;
    }

        //List<String> res 为结果集
        //Map<Character, String> phoneMap 为电话数字对应字母哈希表
        //index 为正要遍历的数组元素索引（下标）
        //digits 为给定数组
        //resBuf 为临时字符串
        public void dfs(List<String> res, Map<Character, String> phoneMap, int index, String digits, StringBuffer resBuf){
            //当遍历的数组下标等于数组长度时
            if(index == digits.length()){
                //将临时字符串（满足条件的）加入结果集
                res.add(resBuf.toString());
            }
            else {
                //获取字符串中下标为index的元素（数字)
                char digit = digits.charAt(index);
                //获取数字digit代表的字母（从哈希表中可以找到对应关系）
                String letters = phoneMap.get(digit);
                //获取该数字按键上的字母个数
                int lettersCount = letters.length();
                //开始循环
                for (int i = 0; i < lettersCount; i++) {
                    //向resBuf后添加该数字上的第 i + 1 个字母
                    resBuf.append(letters.charAt(i));
                    //继续dfs
                    dfs(res, phoneMap, index + 1, digits, resBuf);
                    //删除当前（也即最后一个）元素，开始回溯
                    resBuf.deleteCharAt(index);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}