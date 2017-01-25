import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeInterval {
    public static void main(String[] args)
    {
    	List<Interval> intervals = new ArrayList<Interval>();
    	Interval interval = new Interval(1,3);
    	intervals.add(interval);
    	interval = new Interval(15,18);
    	intervals.add(interval);
    	interval = new Interval(8,10);
    	intervals.add(interval);
    	interval = new Interval(2,6);
    	intervals.add(interval);
    	interval = new Interval(2,5);
    	intervals.add(interval);
    	merge(intervals);
    	
    }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
             @Override
             public int compare(Interval it1, Interval it2) {
                 if(it1.start == it2.start)
                 {
                     if(it1.end > it2.end)
                        return 1;
                      else if(it1.end < it2.end)
                         return -1;
                         else
                           return 0;
                 }
                 else
                 {
              	   if(it1.start > it2.start)
              		     return 1;
              	   else
              		   return -1;
                 }
             }
         });
         List<Interval> ret = new ArrayList<Interval>();
         for(Interval interval : intervals)
         {
             if(ret.size() == 0)
             {
                 ret.add(interval);
             }
             else
             {
                 if(interval.start <= ret.get(ret.size() - 1).end)
                 {
                     if(ret.get(ret.size() - 1).end < interval.end)
                     {
                        ret.get(ret.size() - 1).end =  interval.end;
                     }
                 }
                 else
                 {
                       ret.add(interval);
                 }
                 
             }
         }
         return ret;
  }
}
 class Interval {
	     int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  } 
