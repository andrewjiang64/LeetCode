import java.util.HashMap;

public class LongestSubstring {
   
	public static void main(String[] args)
	{
		
		int length = lengthOfLongestSubstring("abcabcbb");
		System.out.println(length);
	}
	 public static int lengthOfLongestSubstring(String s) {
		 
		 HashMap<Character, Integer> hashmap = new HashMap<Character,Integer>();
			int maxlength = 0;
			int index = 0;
			 char[] charArray = s.toCharArray();
		     if(charArray.length == 0)
		    	 return 0;
		     else
		     {
		    	 while(index < charArray.length)
		    	 {
		    	     if(!hashmap.containsKey(charArray[index]))
		    	     {
		    			 hashmap.put(charArray[index], index);
		    			 index++;
		    	     }
		    	     else
		    	     {
		    	         int charIndex = hashmap.get(charArray[index]);
		    	         index = charIndex + 1;
		    	         if(maxlength < hashmap.size())
		    	              maxlength =hashmap.size();
		    	          hashmap = new HashMap<Character,Integer>();
		    	     }
		    	 }
		     }
		     return maxlength;
	    }
}
