//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4780 👎 0

package com.cute.leetcode.editor.cn;
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置一个头节点
        ListNode resultHead = new ListNode(0);
        //初始化哨兵节点cur为头节点
        ListNode p = l1 , q = l2 , cur = resultHead;
        //初始化进位位为0
        int temp = 0;
        //如果p或者q不为空
        while (p != null || q != null) {
            //令x等于p.val（p不为空，否则x=0）
            int x = (p != null) ? p.val : 0;
            //令y等于q.val（q不为空，否则y=0）
            int y = (q != null) ? q.val : 0;
            //当前位计算和为x+y+temp（进位）
            int sum = temp + x + y;
            //进位位
            temp = sum / 10;
            //当前位
            cur.next = new ListNode(sum % 10);
            //哨兵节点向后移动，进行下一位的计算
            cur = cur.next;
            //如果p、q不为空，分别向后移动
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        //最后进行进位位的判断，若大于零，还需要再最终的链表后添加进位位
        if (temp > 0) {
            cur.next = new ListNode(temp);
        }
        //返回计算完成的链表
        return resultHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}