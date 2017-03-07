import java.util.HashMap;


public class SubArrayMaxLength {
	public static void main(String[] args)
	{
		int[] nums = new int[]{1,0,-1};
		int num = -1;
		System.out.println(maxSubArrayLen(nums,num));
	}
	public static int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];
            if(sum == k)
            {
                maxLength = i + 1;
            }
            else if(hashMap.containsKey(sum - k))
            {
                maxLength = Math.max(maxLength,i - hashMap.get(sum - k));
            }
            hashMap.putIfAbsent(sum, i);
        }
        return  maxLength;
    }
}
