//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 564 👎 0

package com.cute.leetcode.editor.cn;
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *回溯，根据条件枚举每一种不同的结果，将符合条件的结果保存并输出
     */
class Solution {
    /**     全局变量        */
    int N;                                                          //棋盘行、列数
    char[][] Board;                                                 //棋盘
    List<List<String>> solutions = new ArrayList<List<String>>();   //合法的摆放方法

    public List<List<String>> solveNQueens(int n) {
        //棋盘的行、列数等于皇后数
        N = n;
        //初始化棋盘
        Board = new char[N][N];
        //将棋盘的每一格填上 '.' （按行填）
        for(char[] line : Board){
            Arrays.fill(line, '.');
        }
        //从第一行（数组下标为0）开始放置皇后
        backtrack(0);
        //返回所有可能的放置结果
        return solutions;
    }

    /**         回溯算法            */
    //row为需要放置皇后的行
    void backtrack(int row){
        //摆放皇后之前进行回溯条件的判断
        //回溯结束的条件：当放置到最后一行的时候，摆放完毕
        if(row == N){
            //此时将合法的摆放方式加入结果集中
            List<String> solution = new ArrayList<String>();
            //将棋盘的每一行转化为字符串，添加到solution里
            for(char[] line : Board){
                solution.add(String.valueOf(line));
            }
            //将合法的solution添加到结果集里
            solutions.add(solution);
            //返回
            return;
        }
        //逐个位置摆放皇后（i代表列）
        for(int col = 0; col < N; col++){
            //如果（row, i) 位置合法
            if(isLegal(row, col)){
                //将该位置置 ‘Q’
                Board[row][col] = 'Q';
                //开始向下一行摆放皇后
                backtrack(row + 1);
                //关键：回溯的位置
                //回溯时，要将已经试过的或者说摆放过皇后的位置置为 '.' ，以便开始新的搜索
                Board[row][col] = '.';
            }
        }

    }

    /**         判断放置皇后的位置是否合法           */
    //row 为行，col 为列
    boolean isLegal(int row, int col){
        //如果一行中已经有皇后，非法
        for(int i = 0; i < col; i++){
            if(Board[row][i] == 'Q'){
                return false;
            }
        }
        //如果一列中已经有皇后，非法
        for(int i = 0; i < row; i++){
            if(Board[i][col] == 'Q'){
                return false;
            }
        }
        //如果一条主对角线中已经有皇后，非法
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(Board[i][j] == 'Q'){
                return false;
            }
        }
        //如果一条副对角线中已经有皇后，非法
        for(int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++){
            if(Board[i][j] == 'Q'){
                return false;
            }
        }
        //其他情况，合法
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}