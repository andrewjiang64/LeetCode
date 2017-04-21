import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TopKFreqency {
	public static void main(String[] args)
	{
		int[] nums = new int[]{1,1,1,2,2,3};
		int k = 2;
		System.out.println(topKFrequent(nums,k));
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
       for(int n: nums){
           map.put(n, map.getOrDefault(n,0)+1);
       }
          
       PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                        new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           maxHeap.add(entry);
       }
       
       List<Integer> res = new ArrayList<>();
       while(res.size()<k){
           Map.Entry<Integer, Integer> entry = maxHeap.poll();
           res.add(entry.getKey());
       }
       return res;
   }
}
