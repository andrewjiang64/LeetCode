import java.util.HashMap;
import java.util.HashSet;


public class FindPairs {
	  public static void main(String[] args)
	  {
		  int[] nums = new int[]{6,3,5,7,2,3,3,8,2,4};
		 
		  System.out.println(findPairs(nums,2));
	  }
	  public static int findPairs(int[] nums, int k) {
	        if(k < 0 || nums.length == 0)
	          return 0;
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int count = 0;
	        for(int i = 0; i < nums.length; i++)
	        {
	        	int num = nums[i];
	           if(k == 0 && (map.containsKey(num)&& map.get(num) == 1))
	           {
	        	   count++;
	           }
	           else if (!map.containsKey(num))
	           {
	        	   if(map.containsKey(num - k))
	        		   count++;
	        	   if(map.containsKey(num + k))
	        		   count++;
	        	    if(!map.containsKey(num))
	        			   map.put(num, 0);
	        	   
	           }
	           map.put(num, map.get(num) + 1);
	        }
	        return count;
	    }
}
