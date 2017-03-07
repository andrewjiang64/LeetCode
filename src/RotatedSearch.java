
public class RotatedSearch {

	public static void main(String[] args)
	{
		int[] nums = new int[]{1,3};
		int target = 3;
		System.out.println(search(nums, target));
	}
	public static boolean search(int[] nums, int target) {
		  int len = nums.length;
		    int start = 0, end = len - 1;
		    while (start <= end){
		        int mid = start + (end - start)/2;
		        if (nums[mid] == target) return true;
		        if (nums[mid] > nums[start]){
		            if (nums[mid] > target && nums[start] <= target) end = mid;
		            else start = mid + 1;
		        }else if (nums[mid] < nums[start]){
		            if (nums[mid] < target && nums[end] >= target) start = mid + 1;
		            else end = mid;
		        }else start ++;
		    }
		    return false;
            
        }
}
