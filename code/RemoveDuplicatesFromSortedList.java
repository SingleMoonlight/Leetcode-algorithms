//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 385 👎 0

package com.cute.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //设置一个头节点
        ListNode resultHead = new ListNode(0);
        //初始化哨兵cur为头节点
        ListNode cur = resultHead;
        //如果头节点不为空，令哨兵指向头节点，否则直接返回空
        if(head != null) {
            cur.next = head;
            cur = cur.next;
        }
        else return null;
        //如果链表只有一个头节点，返回直接头节点
        if(head.next == null) return head;
        //如果头节点不为空（链表至少有两个节点）
        while (head != null){
            //head向后移动，指向下一个节点，遍历链表
            head = head.next;
            //找到不重复的节点值
            if(head.val != cur.val){
                //让哨兵指向该节点
                cur.next = head;
                cur = cur.next;
            }
            //若哨兵所指节点与当前节点值相等，且head已经遍历到链表最后了（即从cur到最后全是相同的值）
            if(cur.val == head.val && head.next == null){
                //将哨兵直接指向null，后面相同的节点不再考虑，跳出循环
                cur.next = null;
                break;
            }
            //如果哨兵遍历到链表最后了，跳出循环
            if(cur.next == null) break;
        }
        //返回 结果
        return resultHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}