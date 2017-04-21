
public class SearchMatrix {
	  public static void main(String[] args)
	  {
		  int[][] matrix = new int[][]{{-5}};
		  int target = -10;
		  System.out.println(searchMatrix(matrix, target));
	  }
	  public static boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length == 0)
	        {
	           return false;   
	        }
	        int row = 0;
	        int col = matrix[0].length - 1;
	        while(row < matrix.length && col>= 0)
	        {
	            if(matrix[row][col] == target)
	               return true;
	            else if(matrix[row][col] > target)
	                 col = col - 1;
	                else
	                  row = row + 1;
	        }
	        return false;
	    }
}
