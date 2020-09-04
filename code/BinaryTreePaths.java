//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 335 👎 0

package com.cute.leetcode.editor.cn;

import java.util.ArrayList;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        //路径集合
        List<String> results = new ArrayList<>();
        //如果根节点为空，返回空集
        if(root == null) return results;
        //深度遍历
        dfs(root, "", results);
        //返回结果
        return results;
    }
    //深度优先搜索
    void dfs(TreeNode root, String path, List<String> results){
        //如果根节点不为空
        if(root != null){
            //临时保存一条路径
            StringBuffer pathBuf = new StringBuffer(path);
            //将当前节点加入临时路径中
            pathBuf.append(Integer.toString(root.val));
            //当当前节点的左右孩子都为空，递归结束
            if(root.left == null && root.right == null){
                //将一条路径加入路径集合中
                results.add(pathBuf.toString());
                return;
            }
            //只要当前节点的左右孩子有一个不为空，则继续深搜
            else {
                pathBuf.append("->");
                //深搜左孩子
                dfs(root.left, pathBuf.toString(), results);
                //深搜右孩子
                dfs(root.right, pathBuf.toString(), results);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}