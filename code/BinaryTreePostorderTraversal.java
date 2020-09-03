//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 386 👎 0

package com.cute.leetcode.editor.cn;
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        //结果集
        List<Integer> result = new ArrayList<>();
        //遍历
        helper(root, result);
        //返回结果
        return result;
    }
    /**     后序遍历：左子树 ---> 右子树 ---> 根结点       */
    //辅助方法
    void helper(TreeNode root, List<Integer> result){
        //如果根节点不为空
        if(root != null) {
            //如果左子树不为空
            if(root.left != null){
                //后序遍历左子树
                helper(root.left, result);
            }
            //如果右子树不为空
            if(root.right != null){
                //后序遍历右子树
                helper(root.right, result);
            }
            //将根节点加入结果集
            result.add(root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * 只需要移动 list.add(root.val);语句，就可以实现二叉树的前中后序遍历
 * 本代码为后序遍历
 class Solution {
 ArrayList<Integer> list = new ArrayList<>();
 public List<Integer> postorderTraversal(TreeNode root) {
 if(root == null)
 return list;

 if(root.left != null)//左
 postorderTraversal(root.left);
 if(root.right != null)//右
 postorderTraversal(root.right);
 list.add(root.val);中

 return list;
 }
 }

 作者：novice2master
 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/di-gui-die-dai-qu-qiao-san-chong-fang-fa-quan-jie-/
*/