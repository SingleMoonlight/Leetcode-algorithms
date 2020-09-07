//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 477 👎 0

package com.cute.leetcode.editor.cn;

import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //使用哈希表记录每个元素出现的次数
        Map<Integer, Integer> hashMap = new HashMap<>();
        //遍历
        for(int num : nums){
            //如果哈希表里没有num则将其加入哈希表，出现次数value置为1，如果已经出现过，value+1
            //count.put(num, count.getOrDefult(num, 0) + 1);
            if(hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }
            else {
                hashMap.put(num, 1);
            }
        }

        /**
         * 现在已经得到每个元素出现的次数，然后可以通过排序筛选出前 k大的即可
         * 但是很多排序算法的时间复杂度不能达到题目的要求
         *
         * 利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
         *
         * 如果堆的元素个数小于 k，就可以直接插入堆中。
         * 如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。
         * 如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；
         * 否则，就弹出堆顶，并将当前值插入堆中。
         *
         */

        //Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示
        //int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //构造一个比较器函数，题中意思是把元素值和它出现的次数放到一个大小为 2 的数组 array 中，
            //array[0] 存放元素值，array[1] 存放出现的次数。这里的比较器函数就是根据出现次数来构造堆，
            //出现次数小的在堆顶位置，即小顶堆。
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        /**
         * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
         * 它表示Map中的一个实体（一个key-value对）。接口中有getKey(), getValue方法。
         */
        //遍历哈希表
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            //取出元素以及其出现的次数
            int num = entry.getKey(), count = entry.getValue();
            //如果堆的元素个数等于k
            if (queue.size() == k) {
                //如果堆顶的元素出现次数小于当前遍历的元素
                if (queue.peek()[1] < count) {
                    //弹出堆顶
                    queue.poll();
                    //加入新的元素（更大）
                    queue.offer(new int[]{num, count});
                }
            }
            //如果堆里的元素还不足k个，直接添加当前元素
            else {
                queue.offer(new int[]{num, count});
            }
        }
        //结果数组
        int[] ans = new int[k];
        //遍历队列
        for (int i = 0; i < k; ++i) {
            //依次出队
            ans[i] = queue.poll()[0];
        }
        //返回结果
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}