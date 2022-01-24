package helloworld;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;

public class HelloWorld {
	
	 public boolean isPalindrome(int x) {
	        String num1 = String.valueOf(x);
	        char ch;
	        String reversenum = "";
	         for (int i=0; i<num1.length(); i++){
	            ch= num1.charAt(i); //extracts each character
	            reversenum+= ch; //adds each character in front of the existing string
	        }
	       if(num1.equals(reversenum)){
	           return true;
	       }else{
	           return false;
	       }
	        
	    }
	 public static void main(String[] args) {
		 String s = "()";
		       if(s.indexOf("(]" ) != 0 || s.indexOf("(]") == 0){
		            System.out.println("False");
		        }else if(s.indexOf("(}") != 0 || s.indexOf("(}") == 0){
		            System.out.println("False");
		        }else if(s.indexOf("[)") != 0 || s.indexOf("[)") == 0){
		            System.out.println("False");
		        }else if(s.indexOf("[}") != 0 || s.indexOf("[}") == 0){
		            System.out.println("False");
		        }else if(s.indexOf("{)") != 0 || s.indexOf("{)") == 0){
		            System.out.println("False");
		        }else if(s.indexOf("{]") != 0 || s.indexOf("{]") == 0){
		            System.out.println("False");
		        }else{
		            System.out.println("True");
		        }
	 }//end of main
	 
	 public static int romanToInt(String s) {
	        Map<Character, Integer> romanNumerals = new HashMap<>();
	        int answer = 0;
	        String s2 = "";
	        romanNumerals.put('I', 1);
		    romanNumerals.put('V', 5);
		    romanNumerals.put('X', 10);
		    romanNumerals.put('L', 50);
		    romanNumerals.put('C', 100);
		    romanNumerals.put('D', 500);
		    romanNumerals.put('M', 1000);
	        Set<Entry<Character, Integer>> romanNumeralsSet = romanNumerals.entrySet();
	        
		    for(int i = 0; i < s.length(); i++){
		    	for(Entry<Character, Integer> entryset : romanNumeralsSet) {
		    		 if(i == s.length()-1){
	                        s2 = "";
	                    }else{
	                        s2 = new StringBuilder().append(s.charAt(i)).append(s.charAt(i+1)).toString();
	                    }
	                    if(s2.equals("IV")){
	                        answer += 4;
	                        i++;
	                    }else if(s2.equals("IX")){
	                        answer += 9;
	                        i++;
	                    }else if(s2.equals("XL")){
	                        answer += 40;
	                        i++;
	                    }else if(s2.equals("XC")){
	                        answer += 90;
	                        i++;
	                    }else if(s2.equals("CD")){
	                        answer += 400;
	                        i++;
	                    }else if(s2.equals("CM")){
	                        answer += 900;
	                        i++;
	                    }else if(s.charAt(i) == entryset.getKey()){
	                        answer += entryset.getValue();
	                        break;
	                    }
		    	}
		    }
	        return answer;
	    }//end of method
	 
	 public static String longestCommonPrefix(String[] strs) {
	        String prefix = strs[0];
	        for(int i =1; i<strs.length; i++){
	           while(strs[i].indexOf(prefix) != 0)
	               prefix = prefix.substring(0, prefix.length()-1);
	               
	           if(prefix.length() == 0){
	               return "";
	           }
	        }
	        return prefix;
	    }
	 	
	

}
