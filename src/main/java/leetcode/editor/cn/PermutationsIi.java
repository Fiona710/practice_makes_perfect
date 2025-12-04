//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1752 👎 0

 
  package leetcode.editor.cn;
  import util.*;

  import java.util.*;

public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
           boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,res,0,perm);
        return res;
    }

    public void backtrack(int[] nums,List<List<Integer>> ans,int idx,List<Integer> perm){

        if(idx == nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums,ans,idx + 1,perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }