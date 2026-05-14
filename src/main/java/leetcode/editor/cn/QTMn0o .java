//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2： 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode.cn/problems/subarray-sum-equals-k/ 
//
// Related Topics 数组 哈希表 前缀和 👍 204 👎 0

 
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class QTMn0o{
    public static void main(String[] args) {
         Solution solution = new QTMn0o().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //解法一
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for(int i = 0;i < nums.length;i++){
//            int sum = 0;
//            for(int j = i;j < nums.length;j++){
//                sum += nums[j];
//                if(sum == k){
//                    count++;
//                }
//            }
//        }
//        return count;
//
//    }
        //解法二：解法一和解法二都是遍历所有的子序列，都能通过测试，但是耗时是比较久的
//        public int subarraySum(int[] nums, int k) { int count = 0; for (int start = 0; start < nums.length; ++start) { int sum = 0; for (int end = start; end >= 0; --end) { sum += nums[end]; if (sum == k) { count++; } } } return count; }


        //解法三：前缀和+哈希表
        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> preSum = new HashMap<Integer,Integer>();

            int tmpSum = 0;
            preSum.put(0,1);
            int count = 0;

            for(int i = 0;i < nums.length;i++){
                tmpSum += nums[i];

                if(preSum.containsKey(tmpSum - k)){
                    count += preSum.get(tmpSum - k);
                }


                if(preSum.containsKey(tmpSum)){
                   preSum.put(tmpSum,preSum.get(tmpSum)+1);
                }else{
                    preSum.put(tmpSum,1);
                }

            }
            return count;


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}