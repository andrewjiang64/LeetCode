
public class ContainsNearbyAlmostDuplicate {

	public static void main(String[] args)
	{
		int[] nums = new int[]{-1,2147483647};
		System.out.println(containsNearbyAlmostDuplicate(nums,1,2147483647));
				
	}
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j <= i + k && j < nums.length; j++)
            {
            	 long diff = (long) nums[i] - nums[j];
                if(Math.abs(diff) <= t)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
