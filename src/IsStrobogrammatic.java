import java.util.HashMap;


public class IsStrobogrammatic {
	  public static void main(String[] args)
	  {
		  String num = "2";
		  System.out.println(isStrobogrammatic(num));
	  }
	   public static boolean  isStrobogrammatic(String num) {
	        char[] charArray = num.toCharArray();
	        HashMap<Character, Character> map = new HashMap<Character, Character>();
	        map.put('6','9');
	        map.put('9','6');
	        map.put('0','0');
	        map.put('1','1');
	        map.put('8','8');
	        int i = 0;
	        int j = charArray.length - 1;
	        while(i <= j)
	        {
	            if(!map.containsKey(charArray[i]) || !map.containsKey(charArray[j]))
	               return false;
	            if(map.get(charArray[i]) != charArray[j])
	              return false;
	        }
	        return true;
	        
	    }
}
