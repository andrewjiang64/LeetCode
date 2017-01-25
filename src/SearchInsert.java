
public class SearchInsert {

	public static void main(String[] args)
	{
		int[] nums = new int[]{1,3};
		int target = 3;
		int index = searchInsert(nums, target);
		System.out.println(index);
	}
	public static int searchInsert(int[] nums, int target)
	{
		 int begin = 0;
	        int end = nums.length - 1;
	      
	        if(begin == end)
	        {
	        	  if(nums[begin] > target)
	 	        	 return begin;
	        	  else
	        	  {
	        		  if(nums[begin] == target)
	       	           return begin;
	        		  else
	        			  return begin + 1;
	        	  }
	        }
	        if(nums[begin] > target)
	        	 return begin;
	        if(nums[begin] == target)
	           return begin;
	        if(nums[end] == target)
	        	 return end;
	        while(begin < end)
	        {
	            int middle = begin + (end - begin) / 2;
	            if(nums[middle] == target)
	            	return middle;
	            else
	            {
	            	 if(nums[middle] > target)
	                 {
	                     end = middle;
	                 }
	                 else
	                 {
	                     begin = middle + 1;
	                 }
	            }
	            if(nums[begin] == target)
	 	           return begin;
	 	        if(nums[end] == target)
	 	        	 return end;
	            if(nums[begin] > target)
	            	return begin;
	            if(begin < nums.length - 1)
	            {
	            	 if(nums[begin] < target && nums[begin + 1] > target)
	 	            {
	 	            	return begin + 1;
	 	            }
	 	           
	            }
	            else
	            	return begin + 1;
	           
	        }
	        return -1;
	}
	

}
