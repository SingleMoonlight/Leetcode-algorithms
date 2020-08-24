//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1229 👎 0

package com.cute.leetcode.editor.cn;

import javax.swing.*;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个头节点
        ListNode resultHead = new ListNode(0);
        //初始化哨兵节点cur为头节点
        ListNode cur = resultHead;
        //如果l1和l2链表均不为空
        while (l1 != null && l2 != null) {
            //若l1节点数值更小（或等于）
            if(l1.val <= l2.val){
                //就将该节点赋给cur.next
                cur.next = l1;
                //l1向后移动，准备下一次比较
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            //哨兵节点向后移动
            cur = cur.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
        //即若l1为空，只需将l2接在cur后面，若l2为空，将l1接在后面
        cur.next = l1 == null ? l2 : l1;
        //返回合并后的链表
        return resultHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}