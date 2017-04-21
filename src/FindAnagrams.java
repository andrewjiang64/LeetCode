import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindAnagrams {
	public static void main(String[] args)
	{
		String s = "abaaababab";
		String p = "aab";
		List<Integer> list = findAnagrams(s,p);
		System.out.println(list);
		
	}
	  public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    
	    int[] hash = new int[26]; //character hash
	    
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	    	int value = c - 'a';
	        hash[value]++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	    	int value = s.charAt(right) - 'a';
	        if (hash[value] >= 1) {
	            count--;
	        }
	        hash[value]--;
	        right++;
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) {
	            list.add(left);
	        }
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() ) {
	           value = s.charAt(left) - 'a';
	            if (hash[value] >= 0) {
	                count++;
	            }
	            hash[value]++;
	            left++;
	        
	        }

	        
	    }
	        return list;
	    }
}
