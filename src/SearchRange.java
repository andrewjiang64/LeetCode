
public class SearchRange {
	public static void main(String[] args)
	{
		int[] values = new int[]{0,0,1,2,3,3,42};
		int target = 2;
		int[] indexes = searchRange(values, target);
		System.out.println("abc");
	}
	  public static int[] searchRange(int[] nums, int target) {
		    if(nums[0] == target && nums[nums.length - 1] == target)
		    	return new int[] {0, nums.length - 1};
	        int startIndex = findTargetBeginIndex(nums, target);
	        int endValue = 0;
	        
	        if(startIndex == -1)
	           return new int[]{-1, - 1};
	         int begin = startIndex;
	         int end = nums.length - 1;
	         if(begin == end)
	        	  return new int[] {startIndex, end};
	         while(begin < end)
	         {
	            int middle = begin + (end - begin) / 2;
	           if(nums[middle] == target)
	           {
	        	   begin = middle + 1;
	           }
	           else
	           {
	        	   if(nums[middle] > target)
	        	   {
	        		   end = middle - 1;
	        	   }
	           }
	           if(nums[begin] > target)
	           {
	        	   endValue = begin - 1;
	        	   break;
	           }
	           if(nums[end] == target)
	           {
	        	   endValue = end;
	        	   break;
	           }
	         }
	        
	         return new int[] {startIndex, endValue};
	    }
	    
	    public static int findTargetBeginIndex(int[] nums, int target)
	    {
	        int begin = 0;
	        int end = nums.length - 1;
	        if(nums[begin] == target)
	           return begin;
	        while(begin < end)
	        {
	            int middle = begin + (end - begin) / 2;
	            if(nums[middle] >= target)
	            {
	                end = middle;
	            }
	            else
	            {
	                begin = middle + 1;
	            }
	        }
	        if(nums[begin] == nums[end] && nums[begin] == target)
	        {
	            return begin;
	        }
	        return -1;
	    }
}
