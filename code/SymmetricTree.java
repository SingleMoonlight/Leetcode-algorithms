//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 995 👎 0

package com.cute.leetcode.editor.cn;
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
        /**
        递归：
        一棵二叉树为镜像的条件：
        1、根节点的左右孩子相同
        2、左孩子的左孩子与右孩子的右孩子相同
        3、左孩子的右孩子与右孩子的左孩子相同
         */

        //如果根节点为空，即该树为空树，返回true
        if(root == null) return true;
        //如果不为空，递归调用dfs进行判断
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right){
        /**              条件1             */
        //如果根节点的左右孩子都为空，返回true
        if(left == null && right == null) return true;
        //如果根节点的左右孩子一个为空一个不为空，返回false
        if(left == null || right == null) return false;
        //如果根节点的左右孩子都不空但是值不同，返回false
        if(left.val != right.val) return false;

        /**              条件2、3             */
        //左右孩子比较完了，再递归比较左右孩子的左右孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}
/*
迭代：
class Solution {
    public boolean isSymmetric(TreeNode root) {
    //若根节点为空，或者根节点的左右孩子都为空，返回true
    if(root==null || (root.left==null && root.right==null)) return true;
		//用队列保存节点
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		//将根节点的左右孩子放到队列中
		queue.add(root.left);
		queue.add(root.right);
		//只要当前队列中有元素，就进行比较
		while(queue.size()>0) {
			//从队列中取出两个节点进行比较
			TreeNode left = queue.removeFirst();
			TreeNode right = queue.removeFirst();
			//如果两个节点都为空就继续比较
			if(left==null && right==null) continue;
			//如果两个节点有一个为空就返回false
			if(left==null || right==null) return false;
            //如果两个节点都不为空但是值不同返回false
			if(left.val!=right.val) return false;

			//将左节点的左孩子， 右节点的右孩子放入队列
			queue.add(left.left);
			queue.add(right.right);
			//将左节点的右孩子，右节点的左孩子放入队列
			queue.add(left.right);
			queue.add(right.left);
        }
        //队列为空，直接返回true
        return true;
    }
}
 */
//leetcode submit region end(Prohibit modification and deletion)

}