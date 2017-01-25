import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Sum3 {
	  public static void main(String[] args)
	  {
		  int[] nums = {-1,0,1,2,-1,-4};
		  List<List<Integer>> list = threeSum(nums);
		  String s = "abc";
		  String substring = s.substring(0, 2);
		  System.out.println(substring);
	  }
	  public static List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> list = new LinkedList<List<Integer>>();
	        HashMap<List<Integer>, Integer> hashMap = new HashMap<List<Integer>, Integer>();
	        int start = 0;
	        int end = nums.length - 1;
	        for (int i = 0; i < nums.length; i++) {
	               Integer key = nums[i];
	               start = i +1;
	               end = nums.length - 1;
	           while(start < end)
	           {
	               if(key + nums[start] + nums[end] == 0)
	               {
	                   LinkedList<Integer> Linkedlist = new LinkedList<Integer>();
	                   Linkedlist.add(key);
	                   Linkedlist.add(nums[start]);
	                   Linkedlist.add(nums[end]);
	                   if(!hashMap.containsKey(Linkedlist))
	                   {
	                     list.add(Linkedlist);  
	                     hashMap.put(Linkedlist, 1);
	                   }
	                 
	                   start++;
	                   end--;
	               }
	               else
	               {
	                   if(key + nums[start] + nums[end] > 0)
	                      end--;
	                    else
	                      start++;
	               }
	           }
	         }
	         return list;
	        
	    }
}
