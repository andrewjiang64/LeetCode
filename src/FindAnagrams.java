import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindAnagrams {
	public static void main(String[] args)
	{
		String s = "ababababab";
		String p = "aab";
		List<Integer> list = findAnagrams(s,p);
		System.out.println(list);
		
	}
	  public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i = 0; i < s.length(); i++)
	        {
	            if(i + p.length() <= s.length())
	            {
	                if(isAnagrams(s.substring(i, i + p.length()), p))
	                {
	                    list.add(i);
	                }
	            }
	            else
	            {
	                break;
	            }
	        }
	        return list;
	        
	    }
	    
	    public static boolean isAnagrams(String org, String compare)
	    {
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        char[] charArray = compare.toCharArray();
	        for(int i = 0; i < charArray.length; i++)
	        {
	        	if(map.containsKey(charArray[i]))
	        	{
	        		 map.put(charArray[i], map.get(charArray[i]) + 1);
	        	}
	        	else
	        	{
	        		map.put(charArray[i], 1);
	        	}
	           
	        }
	        char[] orgcharArray = org.toCharArray();
	        for(int i = 0; i < orgcharArray.length; i++)
	        {
	            if(!map.containsKey(orgcharArray[i]))
	            {
	                return false;
	            }
	            else
	            {
	            	  map.put(orgcharArray[i], map.get(orgcharArray[i]) - 1);
	            }
	          
	        }
	        for(Map.Entry<Character,Integer> entry : map.entrySet())
	        {
	        	Integer value = entry.getValue();
	        	if(value != 0)
	        	{
	        		return false;
	        	}
	        }
	        return true;
	    }
}
