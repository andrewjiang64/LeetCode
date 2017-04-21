
public class ProductExceptSelf {
	 public static void main(String[] args)
	 {
		 System.out.println(productExceptSelf(new int[]{1,2,3,4}));
	 }
	 public static int[] productExceptSelf(int[] nums) {
	          int[] results = new int[nums.length];
	          int tmp = 1;
	          for(int i = 0; i < nums.length; i++)
	          {
	        	  results[i] = tmp;
	        	  tmp = tmp * nums[i];
	          }
	          tmp = 1;
	          for(int i = nums.length - 1; i >= 0; i--)
	          {
	        	  results[i] = results[i] * tmp;
	        	  tmp = tmp * nums[i];
	          }
	          return results;
	}
}
