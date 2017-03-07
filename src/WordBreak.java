import java.util.ArrayList;
import java.util.List;


public class WordBreak {
	public static void main(String[] args)
	{
	  List<String> wordDict = new ArrayList<String>();
	  wordDict.add("aaaa");
	  wordDict.add("aa");
	  String s = "aaaaaaa";

	  System.out.println(wordBreak(s, wordDict));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
	      boolean[] dp = new boolean[s.length() + 1];
	      dp[0] = true;
	      for(int i = 1; i <= s.length(); i++)
	      {
	          for(String str :  wordDict)
	          {
	              if(str.length() <= i)
	              {
	            	  if(dp[i - str.length()])
	            	  {
	            		  if(s.substring(i - str.length(), i).equals(str))
		                  {
		                      dp[i] = true;
		                      break;
		                  } 
	            	  }
	                 
	              }
	          }
	      }
	      return dp[s.length()];
	    }
}
