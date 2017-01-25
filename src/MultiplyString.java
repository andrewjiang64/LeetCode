import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MultiplyString {
	public static String multString(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
			  return "0";
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> other = new ArrayList<Integer>();
		for(int i = num1.length() - 1; i >= 0; i--)
		{
			array.add(new Integer(num1.charAt(i)) - 48);
		}
		for(int i = num2.length() - 1; i >= 0; i--)
		{
			other.add(new Integer(num2.charAt(i)) - 48);
		}
	    int otherArraySize = other.size();
	    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i < otherArraySize; i++)
	    {
	    	int otherNumber = other.get(i);
	    	int index = i;
	    	ArrayList<Integer> temparray = new ArrayList<Integer>();
	    	
	        int addValue = 0;
	    	for(int j = 0 ; j < array.size(); j++)
	    	{
	    		if(addValue == 0)
	    		{
	    			int temp = otherNumber * array.get(j);
	    			if(temp >= 10)
	    			{
	    				int value = temp % 10;
	    				temparray.add(value);
	    				addValue = temp / 10;
	    			}
	    			else
	    			{
	    				int value = temp;
	    				temparray.add(value);
	    				addValue = 0;
	    				
	    			}
	    				
	    		}
	    		else
	    		{
	    			int temp = otherNumber * array.get(j) + addValue;
	    			if(temp >= 10)
	    			{
	    				int value = temp % 10;
	    				temparray.add(value);
	    				addValue = temp / 10;
	    			}
	    			else
	    			{
	    				int value = temp;
	    				temparray.add(value);
	    				addValue = 0;
	    				
	    			}
	    		}
	    		if(j == array.size() - 1 && addValue != 0)
	    		{
	    			temparray.add(addValue);
	    		}
	    	}
	    	while( index > 0)
	    	{
	    	  	temparray.add(0,0);
	    	  	index --;
	    	}
	        if(temparray.size() > 0)
	        {
	        	int lastValue = temparray.get(temparray.size() - 1);
	        	if(lastValue == 0)
	        	{
	        		temparray.remove(temparray.size() - 1);
	        		for(int k = temparray.size() - 2; k >= 0; k--)
	            	{
	        			if(temparray.size() == 1)
	        				break;
	            		if(temparray.get(k) == 0)
	            		{
	            			temparray.remove(k);
	            		}
	            		else
	            		{
	            			break;
	            		}
	            	}
	        	}
	        	
	        }
	    	
	    	arrayList.add(temparray);
	    }
	    array = new ArrayList<Integer>();
	    for(int i = 0; i < arrayList.size(); i++)
	    {
	    	array = addArrayInt(array,arrayList.get(i));
	    }
	    StringBuilder s = new StringBuilder();
	    for(int i = array.size() - 1; i >= 0; i--)
	    {
	    	s.append(array.get(i)+ "");
	    }
	    return s.toString();
	  }
	public static ArrayList<Integer> multArrayInt(ArrayList<Integer> array, ArrayList<Integer> other) {
	    int otherArraySize = other.size();
	    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i < otherArraySize; i++)
	    {
	    	int otherNumber = other.get(i);
	    	int index = i;
	    	ArrayList<Integer> temparray = new ArrayList<Integer>();
	    	
	        int addValue = 0;
	    	for(int j = 0 ; j < array.size(); j++)
	    	{
	    		if(addValue == 0)
	    		{
	    			int temp = otherNumber * array.get(j);
	    			if(temp >= 10)
	    			{
	    				int value = temp % 10;
	    				temparray.add(value);
	    				addValue = temp / 10;
	    			}
	    			else
	    			{
	    				int value = temp;
	    				temparray.add(value);
	    				addValue = 0;
	    				
	    			}
	    				
	    		}
	    		else
	    		{
	    			int temp = otherNumber * array.get(j) + addValue;
	    			if(temp >= 10)
	    			{
	    				int value = temp % 10;
	    				temparray.add(value);
	    				addValue = temp / 10;
	    			}
	    			else
	    			{
	    				int value = temp;
	    				temparray.add(value);
	    				addValue = 0;
	    				
	    			}
	    		}
	    		if(j == array.size() - 1 && addValue != 0)
	    		{
	    			temparray.add(addValue);
	    		}
	    	}
	    	while( index > 0)
	    	{
	    	  	temparray.add(0,0);
	    	  	index --;
	    	}
	        if(temparray.size() > 0)
	        {
	        	int lastValue = temparray.get(temparray.size() - 1);
	        	if(lastValue == 0)
	        	{
	        		temparray.remove(temparray.size() - 1);
	        		for(int k = temparray.size() - 2; k >= 0; k--)
	            	{
	        			if(temparray.size() == 1)
	        				break;
	            		if(temparray.get(k) == 0)
	            		{
	            			temparray.remove(k);
	            		}
	            		else
	            		{
	            			break;
	            		}
	            	}
	        	}
	        	
	        }
	    	
	    	arrayList.add(temparray);
	    }
	    array = new ArrayList<Integer>();
	    for(int i = 0; i < arrayList.size(); i++)
	    {
	    	array = addArrayInt(array,arrayList.get(i));
	    }
	    
	    return array;
	  }
	  public static ArrayList<Integer> addArrayInt(ArrayList<Integer> array, ArrayList<Integer> other) {
	      ArrayList<Integer> newArray = new ArrayList<Integer>();
		  int arraySize = array.size();
	      int otherarraySize = other.size();
	      boolean addone = false;
	      int size = 0;
	      if(arraySize >= otherarraySize)
	      {
	    	  size = arraySize;
	      }
	      else
	      {
	    	  size = otherarraySize;
	      }
	      for(int i =  0; i <  size; i++)
	    	  {
	    		  if(i <= arraySize - 1 && i <= otherarraySize - 1)
	    		  {
	    			  if(addone == true)
	    			  {
	    				  int temp = array.get(i) + other.get(i) + 1;
	    				  if(temp >= 10)
	    				  {
	    					  addone = true;
	    					  int value = temp % 10;
	    					  newArray.add(value);
	    				  }
	    				  else
	    				  {
	    					  addone = false;
	    					  int value = temp;
	    					  newArray.add(value);
	    				  }
	    			  }
	    			  else
	    			  {
	    				  int temp = array.get(i) + other.get(i);
	    				  if(temp >= 10)
	    				  {
	    					  addone = true;
	    					  int value = temp % 10;
	    					  newArray.add(value);
	    				  }
	    				  else
	    				  {
	    					  addone = false;
	    					  int value = temp;
	    					  newArray.add(value);
	    				  }
	    				  
	    			  }  
	    		  }
	    		  else
	    		  {
	    			  if(addone == true)
	    			  {
	    				  if(i <= arraySize - 1)
	        			  {
	    					  int tmp = array.get(i) + 1;
	    					  if(tmp >= 10)
	    					  {
	    						  addone = true;
	        					  int value = tmp % 10;
	        					  newArray.add(value);
	    					  }
	    					  else
	    					  {
	    						  addone = false;
	        					  int value = tmp;
	        					  newArray.add(value);
	    					  }
	        			  }
	        			  else
	        			  {

	    					  int tmp = other.get(i) + 1;
	    					  if(tmp >= 10)
	    					  {
	    						  addone = true;
	        					  int value = tmp % 10;
	        					  newArray.add(value);
	    					  }
	    					  else
	    					  {
	    						  addone = false;
	        					  int value = tmp;
	        					  newArray.add(value);
	    					  }
	        				 
	        			  }
	    				  
	    			  }
	    			  else
	    			  {
	    				  if(i <= arraySize - 1)
	        			  {
	        				  newArray.add(array.get(i));
	        			  }
	        			  else
	        			  {
	        				  newArray.add(other.get(i));
	        			  }
	    				  
	    			  }
	    			 
	    			 
	    		  }
	    			
	    		  
	    		  if(i == size - 1 && addone == true)
	    		  {
	    			  newArray.add(1);
	    		  }
	    		  
	    	  }
		  
		  
		  return newArray;
	  }


	/*************************************************************************
	* DO NOT EDIT - this is used in our automatic assessment.                *
	* Changing or altering this in any way will void your application.       *
	*************************************************************************/
	  public static void printAnswer(ArrayList<Integer> answer) {
	    // MSD is at the end. Print backwards.
	    for (int i = answer.size() - 1; i >= 0; i--) {
	      System.out.print(answer.get(i));
	    }
	    System.out.println("");
	  }

	  /*********************
	  * It is highly recommended you
	  * DO NOT change the main function.
	  *********************/
	  public static void main (String[] args) throws java.lang.Exception {
	  
	       String num1 = "35879";
	       String num2 = "38";
	       System.out.println(multString(num1, num2));
	      // END - DO NOT EDIT
	    }
	  
}
