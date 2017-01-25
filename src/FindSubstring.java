import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FindSubstring {
	public static void main(String[] args)
	{
		String s = "a";
		String[] words = new String[]{"a"};
		List<Integer> list = findSubstring(s, words);
		System.out.println("abc");
	}
	public static List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || words == null)
           return null;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++)
        {
            if(!hashMap.containsKey(words[i]))
            {
                hashMap.put(words[i], 1);
            }
            else
            {
                hashMap.put(words[i], hashMap.get(words[i]) + 1);
            }
        }
        int wordlength = words[0].length();
        for(int i = 0; i < s.length();)
        {
               HashMap<String, Integer> tmpHashMap = new HashMap<String, Integer>();
               String tmp = "";
               if(i + wordlength <= s.length())
                 tmp = s.substring(i, i + wordlength);
               else
            	   break;
            int index = i + wordlength;
            int maxIndex = i + (words.length * wordlength); 
            if(maxIndex > s.length())
            	 break;
            if(hashMap.containsKey(tmp))
            {
            	if(tmpHashMap.containsKey(tmp))
            	{
            		 tmpHashMap.put(tmp, tmpHashMap.get(tmp) + 1);
            	}
            	else
            	{
            		tmpHashMap.put(tmp, 1);
            	}
            	if(tmpHashMap.get(tmp) > hashMap.get(tmp))
            		continue;
                while(index < maxIndex)
                {
                    tmp = s.substring(index, index + wordlength);
                    if(hashMap.containsKey(tmp))
                    {
                    	if(tmpHashMap.containsKey(tmp))
                    	{
                    		 tmpHashMap.put(tmp, tmpHashMap.get(tmp) + 1);
                    	}
                    	else
                    	{
                    		tmpHashMap.put(tmp, 1);
                    	}
                    	if(tmpHashMap.get(tmp) > hashMap.get(tmp))
                    		break;
                    }
                    else
                      break;
                    index = index + wordlength;
                }
                if(index == maxIndex)
                {
                    arrayList.add(i);
                    i = i + (words.length * wordlength);
                }
                else
                	i = index;
            }
            else
            	i++;
        }
        return arrayList;
    }
}
