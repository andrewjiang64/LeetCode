
public class LongestPalindromicSubstring {
	  public static void main(String[] args)
	  {
		  
		  String s = longestPalindrome("babad");
	  }
	   public static String longestPalindrome(String s) {
		      
	        if(s.length() == 0)
	           return null;
	        if(s.length() == 1)
	           return s;
	        String longestString = s.substring(0,1);
	        String tmp;
	        for(int i = 0; i < s.length(); i++)
	        {
	            tmp = helper(s, i , i);
	            if(longestString.length() < tmp.length())
	            {
	                longestString = tmp;
	            }
	            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))
	            {
	                 tmp = helper(s, i , i + 1);
	                 if(longestString.length() < tmp.length())
	                 {
	                     longestString = tmp;
	                  }
	                 
	            }
	        }
	        return longestString;
	        
	    }
	    
	    public static String helper(String s, int begin, int end)
	    {
	        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end))
	        {
	            begin--;
	            end++;
	        }
	        return s.substring(begin + 1,end);
	        
	    }
}
