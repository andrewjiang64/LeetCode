import java.util.HashMap;
import java.util.Map;


public class FindTargetSumWays {
	public static void main(String[] args)
	{
		int[] nums = new int[]{1, 1, 1, 1, 1};
		System.out.println(findTargetSumWays(nums,3));	
	}
	 public static int findTargetSumWays(int[] nums, int S) {
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    map.put(0,1);
	        for(int i = 0; i < nums.length; i++)
	        {
	        	 HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
	        		  for(Map.Entry<Integer, Integer> entry : map.entrySet())
	  	            {
	  	                int addvalue = entry.getKey() + nums[i];
	  	                int minvalue = entry.getKey() - nums[i];
	  	                if(tmp.containsKey(addvalue))
	  	                {
	  	                	tmp.put(addvalue, tmp.get(addvalue) + map.get(entry.getKey()));
	  	                }
	  	                else
	  	                {
	  	                	tmp.put(addvalue, map.get(entry.getKey()));
	  	                }
	  	              if(tmp.containsKey(minvalue))
	  	                {
	  	                	tmp.put(minvalue, tmp.get(minvalue) + map.get(entry.getKey()));
	  	                }
	  	                else
	  	                {
	  	                	tmp.put(minvalue, map.get(entry.getKey()));
	  	                }
	  	                
	  	            }
	        		  map = new HashMap<Integer, Integer>();
	        		  map = tmp;
	        	
	          
	        }
	        if(map.containsKey(S))
	        {
	            return map.get(S);
	        }
	        else
	          return 0;
	 }
}
