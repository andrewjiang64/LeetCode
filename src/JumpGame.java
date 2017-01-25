
public class JumpGame {
    public static void main(String[] args)
    {
    	int [] A = new int[]{2,3,1,1,4};
    	System.out.println(jump(A));
    }
	public static int jump(int[] A) {
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;
		for(int i=0; i<A.length-1; i++) {
		    current_jump_max = Math.max(current_jump_max, i+A[i]);
		    if( i == last_jump_max ) {
		        step_count++;
		        last_jump_max = current_jump_max;
		    } 
		}
		return step_count;
	}
}
