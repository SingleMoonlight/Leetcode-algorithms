//有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。 
//
// 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 
//N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。 
//
// 最初，除 0 号房间外的其余所有房间都被锁住。 
//
// 你可以自由地在房间之间来回走动。 
//
// 如果能进入每个房间返回 true，否则返回 false。 
//
// 
// 
//
// 示例 1： 
//
// 输入: [[1],[2],[3],[]]
//输出: true
//解释:  
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
// 
//
// 示例 2： 
//
// 输入：[[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
// 
//
// 提示： 
//
// 
// 1 <= rooms.length <= 1000 
// 0 <= rooms[i].length <= 1000 
// 所有房间中的钥匙数量总计不超过 3000。 
// 
// Related Topics 深度优先搜索 图 
// 👍 121 👎 0

package com.cute.leetcode.editor.cn;
public class KeysAndRooms {
    public static void main(String[] args) {
        Solution solution = new KeysAndRooms().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //记录房间状态，1为开，0为关
    int[] status;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //房间的数量
        int num_of_rooms = rooms.size();
        status = new int[num_of_rooms];
        //从0号房间开始深搜
        dfs(0, rooms);
        //深搜结束，查看每个房间的状态
        for(int i = 0; i < num_of_rooms; i++){
            //如果有没开的，返回false
            if(status[i] == 0) return false;
        }
        //没有没开的，返回true
        return true;
    }

    //深度优先搜索
    public void dfs(int number, List<List<Integer>> rooms) {
        //将该房间改成开
        status[number] = 1;
        //号码为number的房间里的钥匙数量
        int num_of_keys = rooms.get(number).size();
        //用该房间里的每一把钥匙去开对应的门
        for(int i = 0; i < num_of_keys; i++){
            //该房间里的第i把钥匙能开的门
            int num = rooms.get(number).get(i);
            //如果这个房间还没开，就遍历
            if(status[num] == 0){
                dfs(num, rooms);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}