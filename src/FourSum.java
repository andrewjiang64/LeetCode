import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FourSum {
	 public static void main(String[] args)
	 {
		 int[] nums = {1, 0, -1, 0, -2, 2};
		 List<List<Integer>> s = fourSum(nums, 0);
		 System.out.println("aaa");
	 }
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
	        int length = nums.length;
	        int size = (length * (length - 1)) / 2 ;
	        PairIndex[] PairIndexArray = new PairIndex[size]; 
	        for(int i = 0; i < size; i++)
	        {
	        	PairIndexArray[i] = new PairIndex();
	        }
	        int k = 0;
	        for(int i = 0; i < nums.length - 1; i++)
	        {
	        	for(int j = i + 1; j < nums.length; j++)
	        	{
	        		int sum = nums[i] + nums[j];
	        		PairIndexArray[k].sum = sum;
	        		PairIndexArray[k].i = i;
	        		PairIndexArray[k].j = j;
	        		k++;
	        	}
	        }
	        Arrays.sort(PairIndexArray, new PairIndexComparator ());
	         
	        int start = 0;
	        int end = size - 1;
	        while(start < size && end >= 0)
	        {
	        	if((PairIndexArray[start].sum + PairIndexArray[end].sum == target) &&  Nocommmon(PairIndexArray[start], PairIndexArray[end]))
	        	{
	        		ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
	        		arrayInteger.add(nums[PairIndexArray[start].i]);
	        		arrayInteger.add(nums[PairIndexArray[start].j]);
	        		arrayInteger.add(nums[PairIndexArray[end].i]);
	        		arrayInteger.add(nums[PairIndexArray[end].j]);
	        		arrayList.add(arrayInteger);
	        	}
	        	if(PairIndexArray[start].sum + PairIndexArray[end].sum < target)
	        		start++;
	        	else
	        		end--;
	        }
	        
	        return arrayList;
	    }
	 public static boolean Nocommmon(PairIndex a, PairIndex b)
	 {
		 if(a.i == b.i || a.j == b.i || a.i == b.j || a.j == b.j)
		 {
			 return false;
		 }
		 return true;
	 }
}


class PairIndexComparator implements Comparator<PairIndex> {
    @Override
    public int compare(PairIndex a, PairIndex b) {
        return a.sum - b.sum;
    }
}
class PairIndex
{
	int sum;
   int i;
   int j;
}
