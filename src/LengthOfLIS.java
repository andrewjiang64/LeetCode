
public class LengthOfLIS {

	 public static void main(String[] args)
	 {
		 int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
		 System.out.println(lengthOfLIS(nums));
	 }
	 public static int lengthOfLIS(int[] nums) {
	       if(nums.length == 0)
	          return 0;
	       int ret = 0;
	       int[] length = new int[nums.length];
	       for(int i = 0; i < nums.length; i++)
	       {
	           length[i] = 1;
	       }
	       for(int i = 1; i < nums.length; i++)
	       {
	           for(int j = 0; j < i; j++)
	           {
	               if(nums[j] < nums[i])
	               {
	                   length[i] = Math.max(length[i],length[j] + 1);
	               }
	           }
	       }
	       for(int i = 0; i < length.length; i++)
	       {
	           ret = Math.max(ret, length[i]);
	       }
	       return ret;
	       
	    }
}
