import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CourseSchedule {
	public static void main(String[] args)
	{
		int[][] prerequisites = new int[][]{{1,0},{0,1}};
		findOrder(2,prerequisites);
		
	}
	  public static int[] findOrder(int numCourses, int[][] prerequisites) {
		  if(prerequisites.length == 0)
	         {
	             int[] intArray = new int[numCourses];
	             for(int i = 0; i < numCourses; i++)
	             {
	                 intArray[i] = i;
	             }
	             return intArray;
	         }
	         courseGraph[] courseArray = new courseGraph[numCourses];
	         for(int i = 0; i < numCourses; i++)
	         {
	             courseArray[i] = new courseGraph(0);
	             courseArray[i].next = null;
	         }
	         int width = prerequisites.length;
	         int length = prerequisites[0].length;
	         for(int i = 0; i < width; i++)
	         {
	              int courseId =  prerequisites[i][0];
	              int prerequisiteId = prerequisites[i][1];
	              courseGraph tmp = new courseGraph(courseId);
	              tmp.next =  courseArray[prerequisiteId].next;
	              courseArray[prerequisiteId].next =  tmp;
	         }
	         for(int i = 0; i < numCourses; i++)
	         {
	             List<Integer> ret = DFS(i, courseArray,numCourses);
	             if(ret.size() == numCourses)
	             {
	            	 return ret.stream().mapToInt(x->x).toArray();
	             }
	         }
	         return new int[]{};
	         
	    }
	    public static List<Integer> DFS(int startId, courseGraph[] courseArray, int coursenum)
	    {
	    	boolean[] visited = new boolean[coursenum];
	        Queue<Integer> qe=new LinkedList<Integer>();
	        qe.add(startId);
	        List<Integer> ret = new ArrayList<Integer>();
	        while(qe.peek() != null)
	        {
	          int startIndex = qe.poll();
	          if(visited[startIndex])
	          {
	        	  return new ArrayList<Integer>();
	        	
	          }
	          ret.add(startIndex);
	          visited[startIndex] = true;
	          courseGraph course = courseArray[startIndex].next;
	          while(course != null)
	          {
	              qe.add(course.courseId);
	              course = course.next;
	          }
	        }
	        return ret;
	    }
}

class courseGraph
{
     int courseId;
    courseGraph next;
    boolean visited;
   public courseGraph(int courseId1)
   {
       courseId = courseId1;
       visited = false;
   }
   
}
