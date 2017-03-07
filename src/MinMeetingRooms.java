import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinMeetingRooms {
	public static void main(String[] args)
	{
		Interval[] intervals = new Interval[5];
		intervals[0] = new Interval(20,45);
		intervals[1] = new Interval(12,13);
		intervals[2] = new Interval(2,50);
		intervals[3] = new Interval(14,20);
		intervals[4] = new Interval(3,5);
		System.out.println(minMeetingRooms(intervals));
	}
	public static int minMeetingRooms(Interval[] intervals) {
		  int[] starts = new int[intervals.length];
		  int[] ends = new int[intervals.length];
		  for(int i = 0; i < intervals.length; i++)
		  {
			  starts[i] = intervals[i].start;
		  }
		  for(int i = 0; i < intervals.length; i++)
		  {
			  ends[i] = intervals[i].end;
		  }
		  Arrays.sort(starts);
		  Arrays.sort(ends);
		  int room = 0;
		  int endIndx = 0;
		  for(int i = 0; i < starts.length; i++)
		  {
			  if(starts[i] < ends[endIndx])
			  {
				  room ++;
			  }
			  else
				  endIndx++;
		  }
		  return room;
    }
}

