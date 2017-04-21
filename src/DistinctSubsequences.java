
public class DistinctSubsequences {

	 public static void main(String[] args)
	 {
		 System.out.println(numDistinct("rabbbit","rabbit"));
	 }
	  public static int numDistinct(String s, String t) {
		  int n = s.length(), m = t.length();
	        int[] dp = new int[n + 1];
	        char[] scharArray = s.toCharArray();
	        char[] tcharArray = t.toCharArray();
	        for(int i = 0; i <= n; i++)
	        	dp[i] = 1;
	        for(int i=1; i<=m; i++) {
	            int upLeft = dp[0];
	            dp[0] = 0;
	            for(int j=1; j<=n; j++) {
	                int temp = dp[j];
	                dp[j] = dp[j-1];
	                if(scharArray[j-1]==tcharArray[i-1]) dp[j] += upLeft;
	                upLeft = temp;
	            }
	        }
	        
	        return dp[n];
	        
	    }
}
