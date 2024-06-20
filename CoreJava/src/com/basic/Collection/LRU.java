package com.basic.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/********************* Using ArrayList may not be the best approach as it caused Time Limit Exceeded Error **********************/
public class LRU {

	private Map<Integer, Integer> map;
	private List<Integer> list;
	private int capacity;

	public LRU(int capacity) {
		this.map = new HashMap<Integer, Integer>(capacity);
		this.list = new ArrayList<Integer>();
		this.capacity = capacity;
	}

	private void remove() {
		// If cache is full, remove least used object from list and map
		if (list.size() == capacity) {
			int keyToRemove = list.get(capacity - 1);
			list.remove(capacity - 1);
			map.remove(keyToRemove);
		}
	}

	public int get(int key) {

		int value = -1;

		if (map.get(key) != null) {
			// Key exists. Update the list to add to the front = recently accessed
			value = map.get(key);

			if (list.remove(Integer.valueOf(key))) {// Double check.
				// Ideally if the key is present in map, it should be in list as well
				// No capacity check required since its just replace
				list.add(0, key);
			}

		}

		return value;

	}

	public void put(int key, int value) {

		/* Scenario 1 : If the key is already present in map */
		// First check if the key already exists. If yes, just replace the value
		// Also find the key in list and add it to the front
		if (map.get(key) != null) {
			if (list.remove(Integer.valueOf(key))) { // Double check.
				// Ideally if the key is present in map, it should be in list as well
				// No capacity check required since its just replace
				list.add(0, key);
			}
			map.put(key, value);
		}

		/* Scenario 2 : If the key is NOT present in map */
		else {
			// If cache is full, remove least used object from list and map
			// Then put new key/value pair in map

			remove();

			list.add(0, key);
			map.put(key, value);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
