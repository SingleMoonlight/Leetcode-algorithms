//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 294 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //结果集合（使用LinkedList是因为最终的层序遍历结果是倒序输出的，向LinkedList头部加入元素不需要移动元素，速度更快）
        List<List<Integer>> results = new LinkedList<>();
        //如果该树为空树，返回空集
        if(root == null) return results;
        //使用队列临时保存一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点入队
        queue.offer(root);
        //入果队列不为空
        while (!queue.isEmpty()){
            //队列元素个数
            int num = queue.size();
            //保存单层节点（每层的数据插入是在数组尾部，使用ArrayList更快）
            //这一层的节点是queue保存的各个节点的左右孩子
            List<Integer> result = new ArrayList<>();
            //遍历单层节点
            for(int i = 0; i < num; i++){
                //从队列中取出一个节点并删除
                TreeNode node = queue.poll();
                //将该节点保存到单层节点数组里
                result.add(node.val);
                //如果该节点的左孩子不为空，将其加入到队列中
                if(node.left != null){
                    queue.offer(node.left);
                }
                //如果该节点的右孩子不为空，将其加入到队列中
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            //单层节点遍历完成，将得到的一层节点加入结果集（加在头部，头部索引为0）
            results.add(0, result);
            //使用这个也可以
            //results.addFirst(result);
        }
        //返回结果集
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}