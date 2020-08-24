//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1448 👎 0

package com.cute.leetcode.editor.cn;
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        //初始化结果为0
        int target = 0;
        for(int i = 0 ; i < nums.length ; i++){
            //相同数字异或得0，与0异或不变
            //将每一个数字按位异或，最终结果就是只出现一次的数字
            target ^= nums[i] ;
        }
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}