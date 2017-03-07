
public class Candy {
	public static void main(String[] args)
	{
		int[] candy = new int[]{4,2,3,4,1};
		System.out.println(candy(candy));
	}
	 public static int candy(int[] ratings) {
	        int[] sum = new int[ratings.length];
	        sum[0] = 1;
	        int total = 0;
	        for(int i = 1; i < ratings.length; i++)
	        {
	            if(ratings[i] > ratings[i - 1])
	               sum[i] = sum[i - 1] + 1;
	            else
	               sum[i] = 1;
	        }
	        for(int i = ratings.length - 1; i > 0; i--)
	        {
	             if(ratings[i - 1] > ratings[i] && sum[i - 1] <= sum[i])
	               sum[i - 1] = sum[i] + 1;
	        }
	        for(int i = 0; i < sum.length; i++)
	           total = total + sum[i];
	        return total;
	        
	    }
}
