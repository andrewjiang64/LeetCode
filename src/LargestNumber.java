import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class LargestNumber {

	 public static String largestNumber(int[] nums) {
		  Comparator<String> localeComparator = new Comparator<String>() {
				public int compare(String a, String b) {
					StringBuilder ab = new StringBuilder(a);
					ab.append(b);
					StringBuilder ba = new StringBuilder(b);
					ba.append(a);
		            return ba.toString().compareTo(ab.toString());
				}
			};
			String[] sArray = new String[nums.length];
			for(int i = 0; i < nums.length; i++)
			{
				sArray[i] = Integer.toString(nums[i]);
			}
	        Arrays.sort(sArray,localeComparator);
	          if(sArray[0].charAt(0) == '0')
                  return "0";
	        StringBuilder st = new StringBuilder();
	        for(int i = 0; i < sArray.length; i++)
	        {
	            st = st.append(sArray[i]);
	        }
	        return st.toString();
	    }
}
