
public class CanJump {
   
	 public static void main(String[] args)
	 {
		 int[] nums = new int[]{2,5,0,0};
		 System.out.println(canJump(nums));
	 }
	  public static boolean canJump(int[] nums) {
	         if(nums.length == 1)
	           return true;
	int last_jump_max = 0;
	int current_jump_max = 0;
	int sumjump = 0;
	for(int i=0; i<nums.length-1; i++) {
	    current_jump_max = Math.max(current_jump_max, i+nums[i]);
	    if( i == last_jump_max ) {
	       
	        sumjump = sumjump + nums[i];
	        last_jump_max = current_jump_max;
	    } 
	}
	if(sumjump >= nums.length - 1)
	   return true;
	 return false;
	    }
}
