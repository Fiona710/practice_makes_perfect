//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1718 👎 0

 
  package leetcode.editor.cn;
  import util.*;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

public class CombinationSumIi{
      public static void main(String[] args) {
           Solution solution = new CombinationSumIi().new Solution();
           int[] candidates = {10,1,2,7,6,1,5};
           int target = 8;
           solution.combinationSum2(candidates,target);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] vis = new boolean[candidates.length];
        backtrack(candidates,target,0,path,ans,vis);
        return ans;
    }

    public void backtrack(int[] candidates,int target,int start,List<Integer> path,List<List<Integer>> ans,boolean[] vis){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start;i < candidates.length;i++){
            if(i > 0 && candidates[i-1] == candidates[i] && !vis[i-1]){
                continue;
            }
            if(target - candidates[i] < 0){
                break;
            }

            path.add(candidates[i]);
            vis[i] = true;
            backtrack(candidates,target-candidates[i],i+1,path,ans,vis);
            vis[i] = false;
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }