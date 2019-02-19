package com.basic.Collection;

public class MyArrayList {
	
	private int size_factor = 5;
	private Object[] myList ;
	private int index; //next index where the element will be added. Default 0
	
	public MyArrayList() {
		myList = new Object[size_factor];
	}
	
	boolean add(Object value){
		if(index == myList.length){
			doubleSpace();
		}
		
		myList[index++] = value;
		return true;
	}
	
	Object get(int index){
		if(index > myList.length-1){
			return null;
		}
		return myList[index];
	}
	
	/**
	 * Method to double the array size when the last index is occupied
	 */
	void doubleSpace(){
		
		System.out.println("double the array");
		Object[] newList = new Object[2 * size_factor];
		for(int i=0;i<myList.length;i++){
			newList[i]=myList[i];
		}
		myList = newList;
		System.err.println("next index : "+index);
	}
	
	void display(){
	
		for(int i=0;i<index;i++){
			System.out.println(myList[i]);
		}
	}
	
	
	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		myList.add("1");
		myList.add(456);
		myList.add("abc");
		myList.add("2");
		myList.add(789);
	//	myList.add(999);
		
		
		myList.display();
		
		System.err.println(myList.get(5));
		
	
		
		

	}

}
