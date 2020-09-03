//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 654 👎 0

package com.cute.leetcode.editor.cn;

import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        //结果集
        List<Integer> result = new ArrayList<>();
        //遍历
        helper(root, result);
        //返回结果
        return result;
    }
    /**     中序遍历：左子树---> 根结点 ---> 右子树       */
    //辅助方法
    void helper(TreeNode root, List<Integer> result){
        //如果根节点不为空
        if(root != null) {
            //如果左子树不为空
            if(root.left != null){
                //中序遍历左子树
                helper(root.left, result);
            }
            //将根节点加入结果集
            result.add(root.val);
            //如果右子树不为空
            if(root.right != null){
                //中序遍历右子树
                helper(root.right, result);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}