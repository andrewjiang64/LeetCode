import java.util.LinkedList;


public class CheckSubarraySum {
	public static void main(String[] args)
	{
		int[] nums = new int[]{23, 2, 4, 2, 7};
		int k = 6;
		System.out.println(checkSubarraySum(nums,k));
	}
	   public static boolean checkSubarraySum(int[] nums, int k) {
	        int sum = 0;
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        for(int i = 0; i < nums.length; i++)
	        {
	            list.add(nums[i]);
	            sum = sum + nums[i];
	        }
	        return helper(k, sum, list);
	    }
	    public static boolean helper(int k, int sum,LinkedList<Integer> list )
	    {
	        if(list.size() >= 2 && sum >= k && sum % k == 0)
	          return true;
	        if(list.size() >= 2)
	        	helper(k, sum - list.poll(), list );
	        if(list.size() >= 2)
	        	helper(k, sum - list.pollLast(), list);
	        return false;
	    }
}
