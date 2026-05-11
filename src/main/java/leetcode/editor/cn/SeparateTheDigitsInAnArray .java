//给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案
//数组中。 
//
// 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。 
//
// 
// 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [13,25,83,77]
//输出：[1,3,2,5,8,3,7,7]
//解释：
//- 分割 13 得到 [1,3] 。
//- 分割 25 得到 [2,5] 。
//- 分割 83 得到 [8,3] 。
//- 分割 77 得到 [7,7] 。
//answer = [1,3,2,5,8,3,7,7] 。answer 中的数字分割结果按照原数字在数组中的相同顺序排列。
// 
//
// 示例 2： 
//
// 输入：nums = [7,1,3,9]
//输出：[7,1,3,9]
//解释：nums 中每个整数的分割是它自己。
//answer = [7,1,3,9] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 模拟 👍 26 👎 0

 
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray{
    public static void main(String[] args) {
         Solution solution = new SeparateTheDigitsInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >=0; i--) {
            List<Integer> tmp = getSubNums(nums[i]);
            res.addAll(tmp);
        }

        int[] resArr = new int[res.size()];
        int len = res.size();
        for(int i = len-1;i>=0;i--){
            resArr[len-1-i] = res.get(i);
        }
        return resArr;

    }

    public List<Integer> getSubNums(int num){
        List<Integer> res = new ArrayList<>();
        int multi = 10;
        while(true){
            res.add(num %10);
            if(num / multi == 0){
                break;
            }else{
                num = num / multi;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}