//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 208 👎 0

package com.cute.leetcode.editor.cn;
public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //哈希表中String为图的顶点（机场代码），PriorityQueue<String>为保存该顶点所有出度的优先队列
        //PriorityQueue优先队列出队时并不按照先进先出的普通队列规则，而是会出当前优先级最高的元素
        //优先队列中元素的存储通常采用堆数据结构来实现
        //优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        //满足条件的结果集合
        List<String> res = new LinkedList<String>();

        public List<String> findItinerary(List<List<String>> tickets) {
            //将tickets里的每一个元素分别赋给ticket
            //for循环结束，完成对map的初始化
            for (List<String> ticket : tickets) {
                //src为出发点，dst为目的地
                String src = ticket.get(0), dst = ticket.get(1);
                //初始化map
                //如果当前顶点还未加入map
                if (!map.containsKey(src)) {
                    //将其加入map，当前顶点（src）以及为当前顶点的出度优先队列分配内存空间
                    map.put(src, new PriorityQueue<String>());
                }
                //将当前顶点（src）的出度加入优先队列（队首位置）
                map.get(src).offer(dst);
            }
            //开始搜索
            dfs("JFK");
            //将倒序加入res里的顶点反转
            Collections.reverse(res);
            //正序输出
            return res;
        }

        //深度优先搜索
        public void dfs(String cur) {
            //如果当前图中包含cur顶点且该顶点的出度大于0
            while (map.containsKey(cur) && map.get(cur).size() > 0) {
                //将该顶点的出度优先队列里的队头（字典序最小）取出并删除
                String tmp = map.get(cur).poll();
                //从这个字典序最小的顶点开始继续搜索
                dfs(tmp);
            }
            //当该顶点出度为0时，将其加入结果集
            //这个加入的过程是在dfs递归返回时加入的
            //故加入的顶点顺序是与题目要求相反的
            res.add(cur);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}