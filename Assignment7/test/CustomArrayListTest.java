import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void add_one_item() {
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		myCustomList.add("Second");
		myCustomList.add(null);
		assertEquals(3, myCustomList.getSize());
		
		
	}
	
	@Test
	void add_works(){
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		myCustomList.add("Third");
		
	
		
		assertEquals(2, myCustomList.getSize());
			
	}
	@Test
	void add_works_with(){
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		myCustomList.add("Third");
		myCustomList.add(1, "Second");
	
		
		assertEquals("Third", myCustomList.get(2));
			
	}
	
	@Test
	void add_remove_works(){
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		myCustomList.add("Third");
		myCustomList.add(1, "Second");
		myCustomList.remove(1);
	
		
		assertEquals("Third", myCustomList.get(1));
			
	}
	
	@Test
	void add_sizeIncrease_works(){
		CustomList<Integer> myCustomList = new CustomArrayList<>();
		myCustomList.add(1);
		myCustomList.add(2);
		myCustomList.add(3);
		myCustomList.add(4);
		myCustomList.add(5);
		myCustomList.add(6);
		myCustomList.add(7);
		myCustomList.add(8);
		myCustomList.add(9);
		myCustomList.add(10);
		myCustomList.add(12);
		myCustomList.add(3 ,4);
		
		
		assertEquals(4, myCustomList.get(3));
			
	}
	
	@Test
	void add_with_two_param_Increase_works(){
		CustomList<Integer> myCustomList = new CustomArrayList<>();
		myCustomList.add(0, 1);
		myCustomList.add(1, 2);
		myCustomList.add(2, 3);
		myCustomList.add(3, 4);
		myCustomList.add(4, 5);
		myCustomList.add(5, 6);
		myCustomList.add(6, 7);
		myCustomList.add(7, 8);
		myCustomList.add(8, 9);
		myCustomList.add(9, 10);
		myCustomList.add(10, 12);
	
		
		
		assertEquals(11, myCustomList.getSize());
			
	}

}
