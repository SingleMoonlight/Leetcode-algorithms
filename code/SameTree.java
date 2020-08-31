//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 462 👎 0

package com.cute.leetcode.editor.cn;
public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){         //如果两棵树都为空
            return true;                    //则两棵树相等
        }else if(p == null || q == null){   //如果一棵为空，一棵不为空
            return false;                   //则两棵树不相等
        }else if(p.val != q.val){           //如果两棵树都不为空，但是根节点不同
            return false;                   //则两棵树不相等
        }else {                             //如果两棵树不为空且根节点相同，递归判断两棵树的左右子树是否相等
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}