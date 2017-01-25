import java.util.ArrayList;
import java.util.List;


public class CountAndSay {
     public static void main(String[] args)
     {
    	 int number = 3;
    	 String s = countAndSay(number);
    	 System.out.println(s);
     }
     public static String countAndSay(int n) {
         if(n == 1)
        	 return "1";
         String number = 1 + "";
         for(int i = 1; i < n;i++)
         {
        	 number = getsay(number);
         }
          return number+ "";
         
     }
     
     private static String getsay(String n)
     {
    	   if(n.length() < 2)
    		   return 1 + n;
           List<Character> arrayList = new ArrayList<Character>();
           List<Integer> countList = new ArrayList<Integer>();
           StringBuilder stringbuilder = new StringBuilder();
           for(int i = 0; i < n.length(); i++)
           {
        	   if(arrayList.size() > 0)
        	   {
        		   if(arrayList.get(arrayList.size() - 1) == n.charAt(i))
                   {
                       countList.set(countList.size() - 1,countList.get(countList.size() - 1) + 1); 
                   }
                   else
                   {
                       arrayList.add(n.charAt(i));
                       countList.add(1);
                   }
        	   }
        	   else
        	   {
        		   arrayList.add(n.charAt(i));
                   countList.add(1);
        	   }
           }
           for(int i = 0; i < arrayList.size(); i++)
           {
               stringbuilder =  stringbuilder.append(countList.get(i)+ "" +arrayList.get(i));
           }
           return stringbuilder.toString();
         
     }
}
