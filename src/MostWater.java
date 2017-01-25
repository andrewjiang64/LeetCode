
public class MostWater {
	public static void main(String[] args)
	{
		int[] height = {1,2,4,3};
		int area = maxArea(height);
		System.out.println(area);
	}
	 public static int maxArea(int[] height) {
	        int x = 0;
	        int y = height.length - 1;
	        int max = 0;
	        while(x != y)
	        {
	            if(height[x] > height[y])
	            {
	                max = Math.max(max, (y - x) * height[y]);
	                y = y - 1;
	            }
	            else
	            {
	               max = Math.max(max, (y - x) * height[x]);
	               x = x + 1;
	            }
	        }
	        return max;
	    }
}
