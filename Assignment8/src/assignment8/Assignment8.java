package assignment8;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class Assignment8 implements Callable<List<Integer>>{
	private List<Integer> numbers = null;
	private Integer i=0;
	private AtomicInteger num = new AtomicInteger(0);
	
	public static void main(String[] args) {
		Assignment8 assign = new Assignment8();
		assign.getData();
		
	}
	
	public Assignment8 () {
		try {
			// Make sure you download the output.txt file for Assignment 8
			//  and place the file in the root of your Java project
			numbers = Files.readAllLines(Paths.get("src/output.txt"))
						   .stream()
						   .map(n -> Integer.parseInt(n))
						   .collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end of assignment 8
	
	/**
	 * This method will return the numbers that you'll need to process from the
	 *   list of Integers. However, it can only return 1000 records at a time.
	 *   You will need to call this method 1,000 times in order to retrieve all
	 *   1,000,000 numbers from the list
	 * @return Integers from the parsed txt file, 1,000 numbers at a time
	 */
	public List<Integer> getNumbers () {
		int start, end;
		synchronized (i) {
			start = i;
			end = i+1000;
			i += 1000;
			System.out.println("Starting to fetch records " + start + " to " + (end));
		}
		// force thread to pause for half a second to simulate actual Http / API traffic delay
		try { Thread.sleep(500); } catch (InterruptedException e) { }
		
		List<Integer> newList = new ArrayList<>();
		IntStream.range(start, end)
				 .forEach(n -> {
					 newList.add(numbers.get(n));
				 });
		System.out.println("Done Fetching records " + start + " to " + (end));
		return newList;
	}
	
	
	public void getData () {
		//long zero = 0;
		
        //Assignment8 assignment = new Assignment8();
        List <CompletableFuture<Void>> tasks = new ArrayList<>();
        List <AtomicInteger> num0 = new ArrayList<>();
        List <AtomicInteger> num1 = new ArrayList<>();
        List <AtomicInteger> num2 = new ArrayList<>();
        List <AtomicInteger> num3 = new ArrayList<>();
        List <AtomicInteger> num4 = new ArrayList<>();
        List <AtomicInteger> num5 = new ArrayList<>();
        List <AtomicInteger> num6 = new ArrayList<>();
        List <AtomicInteger> num7 = new ArrayList<>();
        List <AtomicInteger> num8 = new ArrayList<>();
        List <AtomicInteger> num9 = new ArrayList<>();
        List <AtomicInteger> num10 = new ArrayList<>();
        List <AtomicInteger> num11 = new ArrayList<>();
        List <AtomicInteger> num12 = new ArrayList<>();
        List <AtomicInteger> num13 = new ArrayList<>();
        List <AtomicInteger> num14 = new ArrayList<>();
        
        Assignment8 info = new Assignment8();
        for (int i=0; i<1000; i++) {
        	CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> info)
        					 							.thenApply(numbers -> numbers.call())
        					 							.thenAccept(list -> {
        					 								adding(num0, list, 0);
        					 								adding(num1, list, 1);
        					 								adding(num2, list, 2);
        					 								adding(num3, list, 3);
        					 								adding(num4, list, 4);
        					 								adding(num5, list, 5);
        					 								adding(num6, list, 6);
        					 								adding(num7, list, 7);
        					 								adding(num8, list, 8);
        					 								adding(num9, list, 9);
        					 								adding(num10, list, 10);
        					 								adding(num11, list, 11);
        					 								adding(num12, list, 12);
        					 								adding(num13, list, 13);
        					 								adding(num14, list, 14);	 								
        					 							});
        	
        	tasks.add(task);
 

        }
        
       
        while(tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
        	
        }
        
        //print values
        int sum0 = num0.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("0: "+sum0);
        int sum1 = num1.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("1: "+sum1);
    	int sum2 = num2.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("2: "+sum2);
    	int sum3 = num3.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("3: "+sum3);
    	int sum4 = num3.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("4: "+sum4);
    	int sum5 = num5.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("5: "+sum5);
    	int sum6 = num6.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("6: "+sum6);
    	int sum7 = num7.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("7: "+sum7);
    	int sum8 = num8.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("8: "+sum8);
    	int sum9 = num9.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("9: "+sum9);
    	int sum10 = num10.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("10: "+sum10);
    	int sum11 = num11.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("11: "+sum11);
    	int sum12 = num12.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("12: "+sum12);
    	int sum13 = num13.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("13: "+sum13);
    	int sum14 = num14.stream().mapToInt(AtomicInteger::intValue).sum();
    	System.out.println("14: "+sum14);



    }

	public void adding(List <AtomicInteger> namelist, List <Integer> list, int number) {
		synchronized (num) {
			num.set((int) list.stream()
					    .filter(num -> num == number)
					    .count());
					   
			namelist.add(num);		
		}
	}

	@Override
	public List<Integer> call(){
		List<Integer> list = getNumbers();
		
		return list;
	}
	
}
