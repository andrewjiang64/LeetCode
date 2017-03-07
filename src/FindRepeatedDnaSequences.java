import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class FindRepeatedDnaSequences {

	public static void main(String[] args)
	{
		String s = "AAAAAAAAAAAA";
		List<String> stringList = findRepeatedDnaSequences(s);
	}
	 public static List<String> findRepeatedDnaSequences(String s) {
	        HashSet<String> set = new HashSet<String>();
	        HashSet<String> ret = new HashSet<String>();
	        for(int i = 0; i < s.length(); i++)
	        {
	            if(i + 10 > s.length())
	            {
	                break;
	            }
	            String subString = s.substring(i, i + 10);
	            if(!set.add(subString))
	            {
	               ret.add(subString);
	            }
	        }
	        return new ArrayList<String>(ret);
	    }
}
