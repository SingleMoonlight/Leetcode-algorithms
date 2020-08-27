//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 660 👎 0

package com.cute.leetcode.editor.cn;
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
        暴力法, 时间复杂度O(n)
        if(nums.length == 0) return 0;
        int i = 0;
        while (i < nums.length){
            if(nums[i] < target){
                i++;
            }
            else break;
        }
        return i;
        */

        //二分法, 时间复杂度O(log n)
        //数组左右元素下标
        int left = 0, right = nums.length -1;
        //当左边元素下标小于等于右边元素下标时，继续循环
        while (left <= right){
            //定义中间元素下标
            int mid = left + (right - left) / 2;
            //如果中间数字大于等于目标数字，即目标数字处于数组的左半边
            if(nums[mid] >= target){
                //更新数组比较区间
                right = mid - 1;
            }
            else {
                //更新数组比较区间
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}