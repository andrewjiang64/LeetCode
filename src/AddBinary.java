import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AddBinary {
   
	public static void main(String[] args)
	{
		String a = "11";
		String b = "110";
		System.out.println(addBinary(a,b));
	}
	
	 public static String addBinary(String a, String b) {
	        List<Character> charList = new ArrayList<Character>();
	          int indexa = a.length() - 1;
	         int indexb = b.length() - 1;
	         int add = 0;
	         while(indexa >= 0 && indexb >= 0)
	         {
	              int aint = a.charAt(indexa)-'0';
	             int bint = b.charAt(indexb) - '0';
	              int num = aint + bint + add;
	              if(num >= 2)
	              {
	                  int addednum = num % 2;
	                  charList.add(0,(char)(addednum + '0'));
	                  add = 1;
	              }
	              else
	              {
	                  charList.add(0,(char)(num + '0'));
	                  add = 0;
	              }
	              indexa --;
	              indexb --;
	         }
	         if(indexa >= 0)
	         {
	             while(indexa >= 0)
	             {
	                  int aint = a.charAt(indexa)-'0';
	                 int num = aint  + add;
	              if(num >= 2)
	              {
	                  int addednum = num % 2;
	                  charList.add(0,(char)(addednum + '0'));
	                  add = 1;
	              }
	              else
	              {
	                  charList.add(0,(char)(num + '0'));
	                  add = 0;
	              }
	              indexa --;
	             }
	         }
	         if(indexb >= 0)
	         {
	              while(indexb >= 0)
	             {
	                  int bint = b.charAt(indexb)-'0';
	                 int num = bint  + add;
	              if(num >= 2)
	              {
	                  int addednum = num % 2;
	                  charList.add(0,(char)(addednum + '0'));
	                  add = 1;
	              }
	              else
	              {
	                  charList.add(0,(char)(num + '0'));
	                  add = 0;
	              }
	              indexb --;
	             }
	             
	         }
	         if(add != 0)
	         {
	        	 charList.add(0,(char)(add + '0'));
	         }
	      return charList.stream().map(e->e.toString()).collect(Collectors.joining());
	    }
}
