import java.util.*;

public class ReverseInteger {

	 public static void main(String[] args)
	  {
		int s = reverse(-1000000003);
		System.out.println(s);
	}
	 public static int reverse(int x) {
		    if(x / 10 == 0)
		           return x;
		       
		         int reminder = x;
		         int times = 1;
		         int tmp = 0;
		         List<Integer> numberList = new LinkedList<Integer>();
		         while(x != 0)
		         {
		            reminder = x % 10;
		          
		            numberList.add(reminder);
		            x= x / 10;
		            if(x != 0)
		            times = times * 10;
		           
		         }
		         for(int i = 0; i < numberList.size(); i++)
		         {
		             tmp = tmp + numberList.get(i)*times;
		             times = times / 10;
		             if(i < numberList.size() - 1)
		             {
		            	 if(Integer.MAX_VALUE - tmp < numberList.get(i + 1)*times || Integer.MIN_VALUE - tmp < numberList.get(i + 1)*times)
		            		 return 0;
		             }
		         }
		         return tmp;
	         
	    }
}
