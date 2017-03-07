
public class RemoveDuplicates {
	public static void main(String[] args)
	{
		int[] nums = new int[]{1,1,2,2,2,3,3};
		System.out.println(removeDuplicates(nums));
	}
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int size = length;
        if(length == 0)
           return 0;
         if(length == 1)
            return 1;
        int index = 1;
        int num = nums[0];
        int insertIndex = 1;
        boolean hasSame = false;
        while(index < length)
        {
            if(num != nums[index])
            {
              nums[insertIndex] = nums[index];
              insertIndex++;
              num = nums[index];
            }
            else{
               hasSame = true;
                size = size - 1;
            }
            index++;
        }
        return size ;
    }
}
