//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 604 👎 0

package com.cute.leetcode.editor.cn;
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        插入排序，太慢

        //将nums2的数接在nums1后面
        int cur = 0;
        for(int k = m; k < m + n; k++){
            nums1[k] = nums2[cur++];
        }
        //插入排序
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < nums1.length; i++) {
            // 记录要插入的数据
            int tmp = nums1[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < nums1[j - 1]) {
                nums1[j] = nums1[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                nums1[j] = tmp;
            }
        }

         */
        //结果数组
        int[] res = new int[m + n];
        //i指向数组1
        int i = 0;
        //j指向数组2
        int j = 0;
        //j指向结果数组
        int k = 0;
        //从两个数组中逐次选择较小的数放在结果数组里
        //用指针指示已经选择到什么位置
        //直到其中一个数组里的元素被选择完
        while (i < m && j < n) {
            //选择较小的一个赋给结果数组
            if(nums1[i] <= nums2[j]){
                //数组1的数小
                res[k++] = nums1[i];
                i++;
            }
            else {
                //数组2里的数小
                res[k++] = nums2[j];
                j++;
            }
        }
        //将剩下的没有选择完的数组里的元素直接接在结果数组后面
        //数组1没选择完
        while (i < m){

            res[k++] = nums1[i];
            i++;
        }
        //数组2没选择完
        while (j < n){
            res[k++] = nums2[j];
            j++;
        }
        //将结果数组赋给原数组1
        System.arraycopy(res, 0, nums1, 0, m + n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}