
public class WordsTyping {
	public static void main(String[] args)
	{
		String[] sentence = new String[]{"a", "b","c"};
		int rows = 3;
		int cols = 1;
		System.out.println(wordsTyping(sentence,rows,cols));
	}
	 public static int wordsTyping(String[] sentence, int rows, int cols) {
	        int wordIndex = 0;
	        int rowIndex = 0;
	        int colsIndex = 0;
	        int ret = 0;
	        while(rowIndex < rows)
	        {
	            if(cols < sentence[wordIndex].length())
	            {
	                break;
	            }
	            int wordcolsIndex = colsIndex + sentence[wordIndex].length();
	            if(wordcolsIndex > cols)
	            {
	                rowIndex = rowIndex + 1;
	                if(rowIndex < rows)
	                {
	                	 colsIndex = sentence[wordIndex].length() + 1;
	                }
	                else
	                	break;
	               
	            }
	            else
	            {
	            	if(wordcolsIndex == cols)
	            	{
	            		 rowIndex = rowIndex + 1;
	            		
	            			 colsIndex = 0;
	            		 
	            	}
	            	else
	            		colsIndex = wordcolsIndex + 1;
	            }
	            if(wordIndex < sentence.length - 1 )
	            {
	                wordIndex++;
	            }
	            else
	            {
	                wordIndex = 0;
	                ret++;
	            }
	            
	        }
	        return ret;
	    }
}
