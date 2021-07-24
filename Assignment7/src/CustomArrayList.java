//package com.coderscampus.arraylist;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class CustomArrayList<T> implements CustomList<T> {
	List<T> items = new LinkedList<>();
	
	
	private int index = 0;
	
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		
		items.add(item);
			if(item instanceof String) {
				if(items.get(index).equals(item)) {
					index++;
					return true;
				}
			}else {
				if(items.get(index) == item) {
					index++;
					return true;
				}
			}
		
		return true;
		
	}//end of add

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//items
		return items.size();
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		//int arrSize = items.length;
		//Object smth = null;
		//for(int i = 0; i < items.length; i++) {
		//	if(items[index].equals(items[i])) {
		//		smth = items[index];
		//	}
			
		//}
		return (T)items.get(index);
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		items.add(index, item);
		
		if(items.get(index) != null) return true;
		else return false;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		T obj = items.get(0);
		items.remove(index);
		return (T) obj;
	}
	
}
