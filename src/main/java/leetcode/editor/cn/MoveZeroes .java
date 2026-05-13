//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2911 👎 0

 
package leetcode.editor.cn;
public class MoveZeroes{
    public static void main(String[] args) {
         Solution solution = new MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void moveZeroes(int[] nums) {

            /*******一种解法
             int zeroIndex = nums[0] == 0 ? 0 : -1;
             int len = nums.length;

             for(int i = 0;i < len;i++){
             if(nums[i] == 0){
             if(zeroIndex == -1){
             zeroIndex = i;
             }
             }else{
             if(zeroIndex >= 0){
             nums[zeroIndex] =nums[i];
             nums[i] = 0;
             while(nums[zeroIndex] != 0){
             zeroIndex++;
             }
             }
             }
             }
             ****/

            /****solution给的实现比较简洁，可以背一下**
             *
             */
            int len = nums.length;
            int left = 0;
            int right = 0;

            while (right < len) {
                if (nums[right] != 0) {
                    swapNums(nums,left,right);
                    left++;
                }
                right++;//理解：开始的时候，left和right是一样，只有出现了0的时候，left留在了0的索引位置上，right继续找非0的元素
            }
        }

        public void swapNums(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}