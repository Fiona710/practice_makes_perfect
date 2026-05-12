//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 输入保证数组中一定有一个多数元素。 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2693 👎 0

 
package leetcode.editor.cn;
public class MajorityElement{
    public static void main(String[] args) {
         Solution solution = new MajorityElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int target = 0;
        if(len % 2 ==0){
            target = len/2 -1;
        }else{
            target = len/2;
        }

        return subFun(nums,0,len-1,target);

    }

    public int subFun(int[] nums,int left,int right,int target){
        int i = partition(nums,left,right);
        if(i == target){
            return nums[i];
        }else if(i < target){
            return subFun(nums,i+1,right,target);
        }else{
            return subFun(nums,left,i-1,target);
        }
    }

    public int partition(int[] nums,int left,int right){

        int pivot = nums[left];
        int i = left;
        int j = right;

        while(i < j){

            while(i < j && nums[j] >= pivot){
                j--;
            }

            while(i < j && nums[i] <= pivot){
                i++;
            }

            if(i < j){
                swap(nums,i,j);
            }
        }
        swap(nums,i,left);

        return i;

    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}