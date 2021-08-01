//package com.coderscampus.arraylist;
import java.util.List;
import java.util.ArrayList;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	//List<Object> items2 = new ArrayList<>();
	private int index = 0;
	
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		if(items.length == index) {
			System.out.println("growing array "+index);
			Object[] items2 = items;
			items = new Object[(items.length)*2];
			for(int j = 0; j< items2.length; j++) {
				items[j] = items2[j];
			}
		}
		
		
		items[index] = item;	
		index++;
		
		return true;
	}

	@Override
	public int getSize() {
		int size = 0;
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				size++;
			}
		}
		return size++;
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
