package com.basic.Collection;

public class MyHashMap {

	//default map size : 16
	private static int size = 16;
	
	//Array of Entry objects
	private Entry table[] = new Entry[size]; 
	
	// Entry class
	private static class Entry{
		String key;
		String value;
		Entry next; //Pointer to the next Entry object
				
		public Entry(String key, String value){
			this.key = key;
			this.value = value;
		}	
	}
	
	/**
	 * Return the value associated with the key else return NULL
	 * @param key
	 * @return
	 */
	public String get(String key){
		int hash = key.hashCode()%size; //Simple hashing 
		Entry e = table[hash];
		/*if(e!=null){
			if(e.key.equals(key)){
				return e.value;
			}else{
				while(e.next!=null){   //Loop through the Entry objects chain until the 'next' is NULL
					if(e.key.equals(key)){
						return e.value;
					}
					e = e.next;
				}
				if(e.key.equals(key)){ // Check for the last Entry object in the list
					return e.value;
				}
			}
		}*/
		
		while(e!=null){
			if(e.key.equals(key)){
				return e.value;
			}
			e = e.next;
		}
		return null;
	}
	
	/**
	 * If the key exists,replace the value and return the old value else return NULL
	 * @param key
	 * @param value
	 * @return
	 */
	public String put(String key, String value){
	
		int hash = key.hashCode()%size;
		Entry e = table[hash];
		Entry newBucket = new Entry(key, value);
		
		if(e == null){
			table[hash] = newBucket;
		}else{
			if(e.key.equals(key)){ 
				e.value = value; // Old value will be replaced by new one.
			}
			else{
				// Collision: check the list values 
				while(e.next!=null){
					if(e.key.equals(key)){
						String oldValue = e.value;
						e.value = value;
						return oldValue;
					}else{
						e = e.next;
					}
				}
				e.next = newBucket; // insert new element at the end of list
			}
		}
		return null;
	}
	
	/**
	 * To display the Map
	 */
	public void display(){
		for(int i=0;i<table.length;i++){
			Entry e = table[i];
			while (e != null) {
				System.out.println("Key : " + e.key + " , Value : " + e.value);
				e = e.next;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		//Create the map
		MyHashMap myMap = new MyHashMap();
		myMap.put("one", "one");
		myMap.put("two", "two");
		myMap.put("three", "three");
		myMap.put("four", "four");
		
		System.out.println("Map Values : \n");
		myMap.display();
		
		System.out.println("\nGet Map value for key : ");
		System.out.println(myMap.get("four"));
		
		System.out.println("\nPut a new value for existing key");
		myMap.put("three", "newThree");
		
		System.out.println("Map Values : \n");
		myMap.display();
		
		System.out.println("\nGet Map value for non-existent key : ");
		System.out.println(myMap.get("five"));

	}

}
