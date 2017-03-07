
public class NumDecode {

	public static void main(String[] args)
	{
		System.out.println(numDecodings("1"));
	}
	 public static int numDecodings(String s) {
	        int length = s.length();
	        if(length == 0)
	           return 0;
	        int[] dp = new int[length + 1];
	        dp[0] = 1;
	        if (s.charAt(0) > '0' && s.charAt(0) <='9') {
	            dp[1] = 1;
	        }else{
	            dp[1] = 0;
	        }
	        
	     
	        for(int i = 2; i <= length; i++)
	        {
	           
	            	String substring1 =s.substring(i - 1, i);
	                String substring2 = s.substring(i - 2 , i);
	                
	                if(10 <= Integer.parseInt(substring2) && Integer.parseInt(substring2) <= 26)
	                {
	                    dp[i] = dp[i - 2] + dp[i];
	                }
	                if(1 <= Integer.parseInt(substring1) && Integer.parseInt(substring1) <= 9)          
	                {
	                    dp[i] = dp[i] + dp[i - 1];
	                }
	            
	        }
	        return dp[length];
	    }
}
