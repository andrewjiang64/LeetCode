import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class ThreeSumClosest {
	
public static void main(String[] args)
{
	int[] nums = {1,1,1,0};
	int target = -100;
	int closet = threeSumClosest(nums, target);
    System.out.println(closet);			
}
   
public static int threeSumClosest(int[] nums, int target) {
	 Arrays.sort(nums);
     int closet = Integer.MAX_VALUE;
     int value = 0;
     int start = 0;
     int end = nums.length - 1;
     for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            start = i +1;
            end = nums.length - 1;
        while(start < end)
        {
            if(Math.abs(key + nums[start] + nums[end] - target) < closet)
            {
                value =  key + nums[start] + nums[end];
                closet = Math.abs(key + nums[start] + nums[end] - target);
              
            }
           
                if(key + nums[start] + nums[end] > target)
                   end--;
                 else
                   start++;
            
        }
      }
      return value;
    }
}
