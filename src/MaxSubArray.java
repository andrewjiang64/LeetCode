
public class MaxSubArray {
     public static void main(String[] args)
     {
    	 int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    	 System.out.println(maxSubArray(nums));
    	 
     }
     public static int maxSubArray(int[] nums)
     {
    	 
    	   if(nums.length == 0)
    	          return 0;
    	        int currentmax = nums[0];
    	        int nextmax = nums[0];
    	        for(int i = 1; i < nums.length; i++)
    	        {
    	        	if(nextmax > 0)
    	        		nextmax = nextmax + nums[i];
    	        	else
    	        		nextmax = nums[i];
    	            currentmax = Math.max(nextmax,currentmax);
    	        }
    	        return currentmax;
     }
} 
