package arraySort.medium;

/**
 * 寻找第k个最大的数
 */
public class kthNum {


    public void swap(int[] param, int left, int right){
        int tmp = param[left];
        param[left] = param[right];
        param[right] = tmp;
    }

    int quickSelect(int[] nums, int l, int r,int k){

        int left = l;
        int right = r;
        int povit = nums[left];

        while(l < r){

            while(l < r && nums[r] > povit){
                r--;
            }

            while(l < r && nums[l] <= povit){
                l++;
            }

            swap(nums,l,r);
        }
        swap(nums,l,left);

        if(l == k){
            return nums[l];
        }else if(l < k){
            return quickSelect(nums,l + 1,right,k);
        }else{
            return quickSelect(nums,left,l -1,k);
        }

    }

    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickSelect(_nums, 0, n - 1, n - k);
    }

    public static void main(String[] args) {
        kthNum kthNum = new kthNum();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int rst = kthNum.findKthLargest(nums,k);
        System.out.println("res="+rst);


    }


}



