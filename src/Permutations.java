import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Permutations {
    
	public static void main(String[] args)
	{
		int[] nums = new int[]{1,2,3};
		System.out.println(permute(nums));
		
	}
	
	  public static List<List<Integer>> permute(int[] nums) {
		  List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, 0);
		    return list;
	    }
	  private static void backtrack(List<List<Integer>> list, List<Integer> currentList, int [] nums, int index){
		    if(currentList.size() == nums.length)
		    {
		    	list.add(new ArrayList<Integer>(currentList));
		    	return;
		    }
		    int n = nums[index];
		    for (int i = 0; i <= currentList.size(); i++) {
		        List<Integer> copy = new ArrayList<Integer>(currentList);
		        copy.add(i, n);
		        backtrack(list, copy,nums, index + 1);
		    }
		} 
}
