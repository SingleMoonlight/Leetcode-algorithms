//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 620 👎 0

package com.cute.leetcode.editor.cn;
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集合
        List<List<Integer>> results = new ArrayList<>();
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
            //保存单层节点
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
            //单层节点遍历完成，将得到的一层节点加入结果集
            results.add(result);
        }
        //返回结果集
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}