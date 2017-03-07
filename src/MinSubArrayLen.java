
public class MinSubArrayLen {
	public static void main(String[] args)
	{
		int[] nums = new int[]{2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s,nums));
	}
	   public static int minSubArrayLen(int s, int[] nums) {
	        if (nums == null || nums.length == 0)
	           return 0;
	      int min =Integer.MAX_VALUE;
	      int i = 0;
	      int j = 0;
	      int sum = 0;
	      while(j < nums.length)
	      {
	          sum = sum + nums[j];
	          j++;
	          while(sum >= s)
	          {
	              min = Math.min(min, j - i);
	              sum = sum - nums[i];
	              i++;
	          }
	      }
	      return min == Integer.MAX_VALUE ? 0 : min;
	      
	      
	    }
}
