//package com.coderscampus.arraylist;
import java.util.List;
import java.util.ArrayList;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	List<Object> items2 = new ArrayList<>();
	private int i = 0;
	
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		
		items[i] = item;
		items2.add(item);
		i++;
		
		
		if(items.length == i) {
			items = new Object[items.length*2];
			for(int j = 0; j < items2.size(); j++) {
				items[j] = items2.get(j);
			}
		}
		
		return true;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//items
		return items.length;
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
		return (T)items[index];
	}
	
}
