//package com.coderscampus.arraylist;
import java.util.List;
import java.util.ArrayList;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	//List<Object> items2 = new ArrayList<>();
	private int size = 0;
	
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		if(items.length == size) {
			System.out.println("growing array "+size);
			Object[] items2 = new Object[(items.length)*2];
			for(int j = 0; j< items.length; j++) {
				items2[j] = items[j];
			}
			items = items2;
		}
		
		
		items[size] = item;	
		size++;
		
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) {
		return (T)items[index];
	}
	
}
