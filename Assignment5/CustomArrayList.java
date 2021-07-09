//package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[100];
	private int i = 0;
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		items[i] = item;
		i++;
		
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
		Object smth = null;
		for(int i = 0; i < items.length; i++) {
			if(items[index].equals(items[i])) {
				smth = items[index];
			}
			
		}
		return (T)smth;
	}
	
}
