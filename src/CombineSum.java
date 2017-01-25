import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CombineSum {
	
	public static void main(String[] args)
	{
		int[] candidates = new int[]{2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		System.out.println(res);
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> combine = new LinkedList<Integer>();
        backTracking(candidates,ret,combine ,target,  0);
        return ret;
    }
    
    public static void backTracking(int[] nums,List<List<Integer>> ret,LinkedList<Integer> combine ,int key,  int begin)
    {
        if(key > 0)
        {
        	   for(int i = begin; i < nums.length && key >= nums[i]; i++)
               {
                   combine.add(nums[i]);
                   backTracking(nums,ret,combine ,key - nums[i],  i +1);
                   combine.remove(combine.size() - 1);
               }
        }
       
        else if(key == 0)
          {
              ret.add(new ArrayList<Integer>(combine));
          }
    }
    

}
