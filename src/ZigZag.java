
public class ZigZag {
	 public String convert(String s, int numRows) {
	        if(numRows == 0 || numRows == 1 || numRows > s.length())
	           return s;
	        StringBuilder string = new StringBuilder();
	        int rowNumber = 1;
	        while(rowNumber <= numRows)
	        {
	           int startIndex = rowNumber - 1;
	           string.append(s.charAt(startIndex));
	           if(rowNumber == 1 || rowNumber == numRows)
	           {
	               startIndex = 2*numRows - 2 + startIndex;
	                while(startIndex < s.length())
	                {
	                    string.append(s.charAt(startIndex));
	                     startIndex = 2*numRows - 2 + startIndex;
	                }
	           }
	           else
	           {
	                boolean flag = true;
	                startIndex = 2*numRows - 2*rowNumber + startIndex;
	                while(startIndex < s.length())
	                {
	                    string.append(s.charAt(startIndex));
	                    if(flag)
	                       startIndex = 2*(rowNumber - 1) + startIndex;
	                    else
	                        startIndex = 2*numRows - 2*rowNumber + startIndex;
	                    flag = !flag;
	                       
	                }
	               
	           }
	           rowNumber++;
	            
	        }
	        return string.toString();
	    }

}
