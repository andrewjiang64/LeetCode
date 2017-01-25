import java.util.ArrayList;
import java.util.List;


public class Combine {
    
	 public static void main(String[] args)
	 {
		 combine(4,2);
	 }
	  public static List<List<Integer>> combine(int n, int k) {
	        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
	        backTrack(ret, new ArrayList<Integer>(), 1, k, n);
	        return ret;
	    }
	    
	    public static void backTrack(ArrayList<List<Integer>> ret, ArrayList<Integer> array, int start, int k, int n)
	    {
	        if(k == 0)
	        {
	            ret.add(new ArrayList<Integer>(array));
	            return;
	        }
	        for(int i = start; i <= n; i++)
	        {
	            array.add(i);
	            backTrack(ret, array,i + 1,k - 1,n);
	            array.remove(array.size() - 1);
	        }
	    }
}
