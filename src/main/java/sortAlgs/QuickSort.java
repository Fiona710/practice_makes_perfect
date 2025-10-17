package sortAlgs;


/**
 * 快速排序实现
 */
public class QuickSort {

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 获取分区位置
            int pivotIndex = partition(arr, left, right);
            // 递归排序左右两部分
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public int partition(int[] param, int left, int right){
        int pivot = param[left];

        int i = left;
        int j = right;

        while(i < j){
            while(i < j && param[j] > pivot){
                j--;
            }

            while(i < j && param[i] <= pivot){
                i++;
            }

            swap(param,i,j);
        }
        swap(param,i,left);
        return i;
    }

    public void swap(int[] param, int left, int right){
        int tmp = param[left];
        param[left] = param[right];
        param[right] = tmp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = {1};
        sort.quickSort(nums,0,nums.length-1);

        for(int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }

    }
}
