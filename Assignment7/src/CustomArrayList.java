//package com.coderscampus.arraylist;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;
	
	@Override
	public boolean add(T item){
		// TODO Auto-generated method stub
		
		if(items.length == size) {
			//System.out.println("growing array "+size);
			Object[] items2 = new Object[(items.length)*2];
			for(int j = 0; j< items.length; j++) {
				items2[j] = items[j];
			}
			items = items2;
		}
		
		
		items[size] = item;	
		size++;
		
		return true;
		
	}//end of add

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//items
		return size;
	}

	@Override
	public T get(int index) {
		return (T)items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		System.out.println("Changing item at index "+ index + "to "+ item);
		//saving the values
		Object[] items2 = new Object[items.length];
		for (int i = 0; i < items.length; i++) {     
            items2[i] = items[i];     
        }      
		//adding item to that index
		items[index] = item;
		size++;
		//shuffling	
		for (int i = index; i < size; i++) {     
			items[i+1] = items2[i];    
        }  
		//items[index+1] = items2[index];
		
		
		return true;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		T obj = (T) items[index];
		size--;
		Object[] items2 = new Object[items.length];
		for (int i = 0; i < items.length; i++) {     
            items2[i] = items[i];     
        }      
		//shuffling
		for (int i = index; i < size; i++) {     
			items[i] = items2[i+1];    
        }  
		
		
		return (T) obj;
	}
	
}
