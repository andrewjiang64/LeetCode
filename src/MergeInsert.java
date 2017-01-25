import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeInsert {
	public static void main(String[] args)
	{
		List<Interval> intervals = new ArrayList<Interval>();
		
		intervals.add(new Interval(2,7));
		
		intervals.add(new Interval(8,8));
		intervals.add(new Interval(10,10));
		intervals.add(new Interval(12,13));
		intervals.add(new Interval(16,19));
		Interval newInterval = new Interval(9,17);
		List<Interval> ret = insertinterval(intervals, newInterval);
		System.out.println(ret);
	}
	
	public static List<Interval> insertinterval(List<Interval> intervals, Interval newInterval) {
		   List<Interval> ret = new ArrayList<Interval>();
	        boolean hasnewstart = false;
	        boolean hasnewend = false;
	        boolean hasvalue = false;
	        boolean hascontain = false;
	        Interval tmpinterval = new Interval();
	        int index = 0;
	        for(Interval interval : intervals)
	        {
	            if((interval.start <= newInterval.start && interval.end > newInterval.start) || interval.end == newInterval.start)
	            {
	                hasnewstart = true;
	               
	                   tmpinterval.start = interval.start;
	            
	            }
	            if((interval.end >= newInterval.end && interval.start < newInterval.end) || interval.start == newInterval.end )
	            {
	                hasnewend = true;
	                
	               tmpinterval.end = interval.end;
	               
	            }
	            if(interval.start > newInterval.start && interval.end < newInterval.end && !hasnewstart)
	            {
	            	tmpinterval.start = newInterval.start;
	            	hascontain = true;
	            	 hasnewstart = true;
	            }
	            if(hascontain && !hasnewend)
	            {
	            	if(index < intervals.size() - 1)
	            	{
	            		if((interval.start > newInterval.start && interval.end < newInterval.end) && intervals.get(index + 1).start > newInterval.end)
		            	{
		            		tmpinterval.end = newInterval.end;
			            	
			            	hasnewend = true;
		            	}
	            	}
	            	else
	            	{
	            		tmpinterval.end = newInterval.end;
	            	}
	            	
	            }
	            if((hasnewstart == false && hasnewend == false) || hasvalue || interval.start > newInterval.end)
	            {
	                ret.add(interval);
	            }
	            else if(hasnewstart == true && hasnewend == true)
	            {
	                ret.add(tmpinterval);
	                hasvalue = true;
	            }
	            index++;
	        }
	        if(hasnewstart == false)
	        {
	            tmpinterval.start = newInterval.start;
	        }
	        if(hasnewend == false)
	        {
	            tmpinterval.end = newInterval.end;
	        }
	        if(hasnewstart == false || hasnewend == false)
	            ret.add(tmpinterval);
	        Collections.sort(ret, new Comparator<Interval>() {
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
	        return ret;
    }
}
