//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 356 👎 0

package com.cute.leetcode.editor.cn;
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
        //结果集
        List<Integer> result = new ArrayList<>();
        //遍历
        helper(root, result);
        //返回结果
        return result;
    }
    /**     前序遍历：根结点---> 左子树 ---> 右子树       */
    //辅助方法
    void helper(TreeNode root, List<Integer> result){
        //如果根节点不为空
        if(root != null) {
            //将根节点加入结果集
            result.add(root.val);
            //如果左子树不为空
            if(root.left != null){
                //前序遍历左子树
                helper(root.left, result);
            }
            //如果右子树不为空
            if(root.right != null){
                //前序遍历右子树
                helper(root.right, result);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}