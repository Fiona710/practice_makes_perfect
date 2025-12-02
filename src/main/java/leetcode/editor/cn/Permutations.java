//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3216 👎 0

 
  package leetcode.editor.cn;
  import util.*;

  import java.util.ArrayList;
  import java.util.List;

public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0,nums,res);

        return res;

    }

    public void dfs(int i,int[] nums,List<List<Integer>> res){
        if(i == nums.length - 1){
           List<Integer> list = new ArrayList<>();
           for(int num : nums){
               list.add(num);
           }
           res.add(list);
           return;
        }

        for(int m = i;m < nums.length;m++){
            swap(nums,i,m);
            dfs(i + 1,nums,res);
            swap(nums,i,m);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }