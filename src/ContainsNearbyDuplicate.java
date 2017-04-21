import java.util.HashMap;


public class ContainsNearbyDuplicate {
   public static void main(String[] args)
   {
	   int[] nums = new int[]{1,0,1,1};
	   System.out.println(containsNearbyDuplicate(nums,1));
   }
   public static  boolean containsNearbyDuplicate(int[] nums, int k) {
       if(k == 0)
           return false;
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i = 0; i < nums.length; i++)
       {
           if(!map.containsKey(nums[i]))
           {
               map.put(nums[i], i);
           }
           else
           {
               int preindex = map.get(nums[i]);
               if(Math.abs(i - preindex) <= k)
                  return true;
               map.put(nums[i], i);
           }
       }
       return false;
   }
}
