
public class RotateSearch {

	public static void main(String[] args)
	{
		search(new int[]{3,1},1);
	}
	 public static int search(int[] nums, int target) {
		  if(nums.length == 0)
	           return -1;
	          int left = 0;
		        int right = nums.length - 1;
		        while(left < right)
		        {
		            int middle = left + (right - left)/2;
		            int pivot = nums[middle];
		            if(pivot == target)
		               return middle;
		            else
		            {
		                if(nums[left] < pivot)
		                {
		                    if(nums[left] <= target && target < pivot)
		                    {
		                        right = middle - 1;
		                    }
		                    else
		                    {
		                        left = middle + 1; 
		                    }
		                }
		                else if(nums[left] > pivot)
		                {
		                     if(pivot < target && target <= nums[right])
		                    {
		                       left = middle + 1;
		                    }
		                    else
		                    {
		                        right = middle - 1;
		                    }
		                }
		                else
		                	left++;
		            }
		        }
		        return nums[left] == target ? left : -1;
	    }
}
