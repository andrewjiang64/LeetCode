
public class ReverseString {
 public static void main(String[] args)
 {
	 String s = "abcdef";
	 ReverseString rs = new ReverseString();
	 String ret = rs.reverseString(s);
	 System.out.println(ret);
 }
  public String reverseString(String s)
  {
	  char c = s.charAt(s.length()-1);
      if(s.length() == 1) return Character.toString(c);   

      return c + reverseString(s.substring(0,s.length()-1));
  }
}
