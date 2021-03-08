package com.sumit;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        String comb = "";
        int len = s.length();
        
        if(s.length()==0 || s==null)
        {
            return result;
        }
        
        if(s.length()==4)
        {
            comb = s.charAt(0)+"."+s.charAt(1)+"."+s.charAt(2)+"."+s.charAt(3);
            result.add(comb);
            return result;
        }
        
       for(int i=1; i<len && i<4;i++) 
       {
    	   String firstString = s.substring(0,i);
    	   System.out.println("first string is : " + firstString);
    	   
    	   if(!isValid(firstString)) 
    	   {
    		   continue;
    	   }
    	   else 
    	   {
    		   for(int j = 1; i + j<len && j<4 ;j++) 
    		   {
    			   String secondString = s.substring(i,i+j);
    			   System.out.println("Second string is : " + secondString);
    	    	   
    	    	   if(!isValid(secondString)) 
    	    	   {
    	    		   continue;
    	    	   }
    	    	   else 
    	    	   {
    	                   for(int k = 1; i + j + k<len && k <4 ;k++) 
    	        		   {
    	        			   String thirdString = s.substring(i+j,i+j+k);
    	        			   System.out.println("Third string is : " + thirdString);
    	        	    	   
    	        			   String fourthString = s.substring(i+j+k);
    	        			   System.out.println("Fourth string is : " + fourthString);
    	        	    	   if(!isValid(thirdString) || !isValid(fourthString) ) 
    	        	    	   {
    	        	    		   continue;
    	        	    	   }
    	        	    	   result.add(firstString+"."+secondString+"."+thirdString+"."+fourthString);   
    	    	          }
    		       }
    	       }
          }	
	  }
       return result;
    }
	
	private static boolean isValid(String s) {
		if(s.length()>3) 
		{
			return false;
		}
		
		if(s.startsWith("0") && s.length()>1) {
			return false;
		}
		
		int value = Integer.parseInt(s);
		
		return value >=0 && value<=255;
	}

	public static void main(String[] args) {
		System.out.println(Solution.restoreIpAddresses("25525511135"));
	}

}
