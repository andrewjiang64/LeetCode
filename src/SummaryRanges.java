import java.util.ArrayList;
import java.util.List;


public class SummaryRanges {

	  public static void main(String[] args)
	  {
		  summaryRanges(new int[]{1,2,3,8,10,11,12});
	  }
	  public static List<String> summaryRanges(int[] nums) {
	        StringBuilder stringbuilder = new StringBuilder();
	        ArrayList<Integer> arrayList = new ArrayList<Integer>();
	        List<String> stringList = new ArrayList<String>();
	        for(int i = 0; i < nums.length; i++)
	        {
	        	if(arrayList.size() == 0)
	        	{
	        		arrayList.add(nums[i]);
	        	}
	        	else
	        	{
	        		if((nums[i] - arrayList.get(arrayList.size() - 1)) == 1)
	        		{
	        			arrayList.add(nums[i]);
	        		}
	        		else
	        		{
	        			if(arrayList.size() == 1)
						{
							stringList.add(arrayList.get(0) + "");
							arrayList = new ArrayList<Integer>();
							arrayList.add(nums[i]);
						}
						else
						{
							stringbuilder.append(arrayList.get(0));
							stringbuilder.append("->");
							stringbuilder.append(arrayList.get(arrayList.size() - 1));
							stringList.add(stringbuilder.toString());
							stringbuilder = new StringBuilder();
							arrayList = new ArrayList<Integer>();
							arrayList.add(nums[i]);
						}
	        		}
	        	}
	        }
	        if(arrayList.size() == 1)
	        {
	            stringbuilder.append(arrayList.get(0));
	            stringList.add(stringbuilder.toString());
	        }
	        if(arrayList.size() > 1)
	        {
	             stringbuilder.append(arrayList.get(0));
	                    stringbuilder.append("->");
	                    stringbuilder.append(arrayList.get(arrayList.size() - 1));
	                    stringList.add(stringbuilder.toString());
	        }
	        return stringList;
	    }
}
