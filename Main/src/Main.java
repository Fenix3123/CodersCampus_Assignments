import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	
	public static void main (String[] args) {
		 String str = "shshs";
		 
		Set <Integer> list = new HashSet<Integer>();
		list.add(73);
		list.add(67);
		list.add(38);
		list.add(33);
		System.out.println(list);
											  
	}
	
	public static List<Integer> gradingStudents(List<Integer> grades) {
	    // Write your code here
	        List<Integer> ceil = new ArrayList<Integer>();
	        
	        for(int i = 0; i < grades.size(); i++){
	        	double roundup = Math.ceil((double)grades.get(i)/5)*5;
	            if( roundup - grades.get(i) < 3){
	                //double dub = Math.ceil(grades.get(i)/5)*5;
	                Double dubble = new Double(roundup);
	                ceil.add(dubble.intValue());
	            }else{
	                ceil.add(grades.get(i));
	            }
	        }
	        return ceil;
	    }
	
	public static int diagonalDifference(List<List<Integer>> arr) {
	    // Write your code here
	        int dd = 0;
	        int du = 0;
	        int j = 0;
	        int ans = 0;
	        
	        for(int i = 0; i < arr.get(0).size(); i++){
	            dd += arr.get(i).get(i);
	        }
	        
	        for(int i = arr.get(0).size()-1; i > 0; i++){
	            du += arr.get(i).get(j);
	            j++;
	        }
	        return du;
	    }
	
	public static void staircase(int n) {
        char[] chars = new char[n];
    // Write your code here
      
      for(int i = 0; i < n; i++){
           chars[i] = '#';
      }
      System.out.println(chars);
      
      for(int i = n-1; i >= 0; i--){
           char [] chars2 = chars.clone();
           for(int j = 0; j < i; j++){
               chars2[j] = ' ';
           }
           System.out.println(chars2);
      }

    }
	
	public static String toCamelCase(String s){
		 String[] word;
		    int number = 0;
		    if(s.contains("-")){
		      word = s.split("-");
		    }else{
		      word = s.split("_");
		    }
		    String answer = "";
		    
		    if(Character.isLowerCase(word[0].charAt(0))){
		      number = 1;
		    }
		    
		    for(int i = number; i < word.length; i++){
		        word[i] = word[i].substring(0, 1).toUpperCase() + word[i].substring(1);
		    }//for loop
		    
		    for(int i = 0; i < word.length; i++){
		      answer += word[i];
		    }
		    return answer;
	  }
	
	public static int solution(int number) {
	    //TODO: Code stuff here
	    int answer = 0;
	    for(int i = 0; i < number; i++){
	      if(i % 3 == 0 && i % 5 == 0){
	        answer += i;
	      }else if(i % 3 == 0) {
	    	answer += i;
	      }else if(i % 5 == 0) {
	    	answer += i;
	      }
	    }//for loop
	    return answer;
	  }
	
	public static int removeElement(int[] nums, int val) {
        int [] n = new int[nums.length];
        int zero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                n[zero] = nums[i];
                zero++;
            }
        }
        nums = n;
        return nums.length;
    }
	
	public static int singleValue(int[] nums) {
		Arrays.sort(nums);
		
		for(int i =0; i < nums.length; i++) {
			if(i != nums.length-1) {
				if(nums[i] == nums[i+1]){
					i++;
				}else {
					return nums[i];
				}
			}
			
		}
		return nums[nums.length-1];
		
	}
	
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
	
	public static int maxSubArray(int[] nums) {
        Set<Integer> setnum = new LinkedHashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            setnum.add(nums[i]);
        }
        
        Integer sum = setnum.stream().collect(Collectors.summingInt(Integer::intValue));
        
        return sum;
    }

}
