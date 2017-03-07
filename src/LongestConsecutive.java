import java.util.HashMap;


public class LongestConsecutive {
    public static void main(String[] args)
    {
    	int[] nums = new int[]{1,2,0,1};
    	System.out.println(longestConsecutive(nums));
    }
	
    public static int longestConsecutive(int[] nums) {
        
        boolean[] flags = new boolean[nums.length];
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                int right = 0;
                if(map.containsKey(nums[i] + 1))
                {
                    right = map.get(nums[i] + 1);
                }
                int left = 0;
                 if(map.containsKey(nums[i] - 1))
                {
                    left = map.get(nums[i] - 1);
                }
                int sum = left + right + 1;
                max  = Math.max(max, sum);
                map.put(nums[i], sum);
                map.put(nums[i] - left, sum);
                map.put(nums[i] + right, sum);
            }
            else
            {
                continue;
            }
        }
        return max;
    }
}
