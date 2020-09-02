//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 687 👎 0

package com.cute.leetcode.editor.cn;
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //如果根节点为空，返回0
        if(root == null) return 0;
        //如果根节点不为空，但根节点的左右孩子为空，返回1
        if(root.left == null && root.right == null) return 1;
        //初始化最大深度
        int maxdepth = Integer.MIN_VALUE;
        //如果左孩子不为空
        if(root.left != null){
            maxdepth =  Math.max(maxdepth, maxDepth(root.left));
        }
        //如果右孩子不为空
        if(root.right != null){
            maxdepth =  Math.max(maxdepth, maxDepth(root.right));
        }
        //返回最大深度加1（加1 是根节点）
        return maxdepth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}