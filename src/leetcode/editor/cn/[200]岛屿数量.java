//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2878 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {


        //难点1：如何判断是否构成岛屿的条件
        //难点2：如何计算岛屿的数量，执行深度优先搜索的次数=岛屿的数量
        //难点3: 需要将已经遍历过的节点表示为‘0’，这样才能实现每次开始深度遍历，作为一个新的岛屿的开始

        int cn = grid.length;
        int rn = grid[0].length;
        int count =0;

        for(int i = 0;i < cn;i++){
            for(int j = 0;j < rn;j++){
                if(grid[i][j] =='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid,int i,int j){

        if(i >= 0 && i < grid.length && j >= 0  && j < grid[0].length){
            if(grid[i][j] == '1'){
                grid[i][j] = '0';

                dfs(grid,i,j+1);
                dfs(grid,i,j-1);
                dfs(grid,i-1,j);
                dfs(grid,i+1,j);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
