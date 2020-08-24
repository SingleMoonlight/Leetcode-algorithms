//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 345 👎 0

package com.cute.leetcode.editor.cn;
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
    public int minDepth(TreeNode root) {
        //如果是一棵空树，返回0
        if(root == null) return 0;
        //如果只有根节点，返回1
        if(root.left == null && root.right == null) return 1;
        //初始化最小深度
        int mindepth = Integer.MAX_VALUE;
        //递归
        //如果左子树不为空
        if(root.left != null)
        {
            mindepth = Math.min(minDepth(root.left), mindepth);
        }
        //如果右子树不为空
        if(root.right != null)
        {
            mindepth = Math.min(minDepth(root.right), mindepth);
        }
        //返回最小深度（最小子树深度加根节点）
        return mindepth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}