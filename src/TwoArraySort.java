import java.util.Arrays;


public class TwoArraySort {
	public static void sort(int[] a, int[] b)
	{
		int aindex = 0;
        int bindex = 0;
        int total = 0;
        while(total < a.length)
        {
                if(a[aindex] <= b[bindex])
                {
                        a[total++] = a[aindex++];
                }
                else
                {
                        int tmp = a[aindex];
                        a[total++] = b[bindex];
                        b[bindex] = tmp;
                        bindex++;
                        aindex++;
                }
        }
	           Arrays.sort(b);
	        
	}
	public static void main(String[] args)
	{
		int[] a = new int[]{1,4,5,9};
		int[] b = new int[]{2,6,8};
		sort(a, b);
	}
}
