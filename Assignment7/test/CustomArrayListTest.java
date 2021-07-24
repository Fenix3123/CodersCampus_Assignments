import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void add_one_item() {
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		assertEquals("First", myCustomList.get(0));
		
		
	}
	
	@Test
	void returns_false() {
		CustomList<String> myCustomList = new CustomArrayList<>();
		myCustomList.add("First");
		myCustomList.add("Third");
		myCustomList.add(1, "Second");
		
	System.out.println(myCustomList.get(2));
		
		
		
		
	}

}
