import java.util.ArrayList;
import java.util.List;


public class FindLongestWord {
	public static void main(String[] args)
	{
		String s = "aaa";
		List<String> d = new ArrayList<String>();
		d.add("aaa");
				
		d.add("aa");
		d.add("a");
		
		System.out.println(findLongestWord(s,d));
	}
	 public static String findLongestWord(String s, List<String> d) {
	        char[] charArray = s.toCharArray();
	        int[] list = new int[d.size()];
	        String ret = "";
	        for(int j = 0; j < d.size(); j++)
	        {
	           list[j] = -1;
	        }
	        for(int i = 0; i < charArray.length; i++)
	        {
	            char c = charArray[i];
	            for(int j = 0; j < list.length; j++)
	            {
	                int index = list[j] + 1;
	                String st = d.get(j);
	                if(index < st.length())
	                {
	                    if(c == st.charAt(index))
	                    {
	                        list[j] = index;
	                    }
	                }
	            }
	        }
	        for(int j = 0; j < list.length; j++)
	        {
	            if(list[j] == d.get(j).length() - 1)
	            {
	                if(ret.equals(""))
	                {
	                    ret = d.get(j);
	                }
	                else
	                {
	                	if(ret.length() < d.get(j).length())
	                	{
	                		ret = d.get(j);
	                	}
	                	else
	                	{
	                		if(ret.length() == d.get(j).length())
	                		{
	                			if(ret.compareTo(d.get(j)) > 0)
		 	                    {
		 	                        ret = d.get(j);
		 	                    }	
	                		}
	                		 
	                	}
	                   
	                }
	            }
	        }
	        return ret;
	    }
}
