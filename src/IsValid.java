
public class IsValid {
	  public static void main(String[] args)
	  {
		  String s = "[";
		  System.out.println(isValid(s));
	  }
	  public static boolean isValid(String s) {
	        int one = 0;
	        int two = 0;
	        int three = 0;
	        char[] charArray = s.toCharArray();
	        for(int i = 0; i < charArray.length; i++)
	        {
	            if(charArray[i] == '(')
	               one++;
	             if(charArray[i] == '{')
	               two++;
	              if(charArray[i] == '[')
	                three++;
	            if(charArray[i] == ')')
	            {
	                one = one - 1;
	                if(one < 0)
	                  return false;
	            }
	               
	             if(charArray[i] == '}')
	             {
	                    two =  two - 1;
	                if( two < 0)
	                  return false;
	             }
	              if(charArray[i] == '[')
	              {
	                   three = three - 1;
	                if( three < 0)
	                  return false; 
	              }
	              
	        }
	        if(one != 0 || two != 0 || three != 0)
	           return false;
	        return true;
	  }
}
