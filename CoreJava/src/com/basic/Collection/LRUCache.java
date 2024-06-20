/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 * 
 * 
 * 
 * 
 */

package com.basic.Collection;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> map;
	private int capacity;
	private Node head;
	private Node tail;

	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public LRUCache(int capacity) {
		this.map = new HashMap<Integer, LRUCache.Node>();
		this.capacity = capacity;
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;

	}

	public int get(int key) {
		int value = -1;

		if (map.containsKey(key)) {
			Node valueNode = map.get(key);
			value = valueNode.value;

			valueNode.prev.next = valueNode.next;
			valueNode.next.prev = valueNode.prev;

			// Add this node at the front of list
			insert(valueNode);

		}

		return value;

	}

	private void remove() {
		Node lastNode = tail.prev;
		lastNode.prev.next = tail;
		tail.prev = lastNode.prev;
		map.remove(lastNode.key);
	}

	private void insert(Node node) {
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			// Existing key. Update value and add to front of the list
			Node valueNode = map.get(key);

			valueNode.prev.next = valueNode.next;
			valueNode.next.prev = valueNode.prev;

			valueNode.value = value;

			// Add this node at the front of list
			insert(valueNode);

		} else {

			// New key
			Node newNode = new Node(key, value);

			if (map.size() == 0) {
				tail.prev = newNode;
				head.next = newNode;
				newNode.prev = head;
				newNode.next = tail;
			} else {
				// If capacity is reached, remove from tail
				if (map.size() == capacity) {
					remove();
				}

				// Add new node at the front of list
				insert(newNode);
			}

			// Put new key in map
			map.put(key, newNode);
		}

	}

	public void display() {
		System.out.println("Map Size : " + map.size());
		map.entrySet().forEach(s -> System.out.print(s.getKey() + ":"));
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.display();

		/*
		 * Test case 1 cache.put(1, 1); cache.put(2, 2); cache.display();
		 * 
		 * System.err.println(cache.get(1)); cache.display();
		 * 
		 * cache.put(3, 3); cache.display();
		 * 
		 * System.err.println(cache.get(2)); cache.display();
		 * 
		 * cache.put(4, 4); cache.display();
		 * 
		 * System.err.println(cache.get(1)); cache.display();
		 * 
		 * System.err.println(cache.get(3)); cache.display();
		 * 
		 * System.err.println(cache.get(4)); cache.display();
		 */

		System.err.println(cache.get(2));
		cache.put(2, 6);
		cache.display();

		System.err.println(cache.get(1));

		cache.put(1, 5);
		cache.display();

		cache.put(1, 2);
		cache.display();

		System.err.println(cache.get(1));

		System.err.println(cache.get(2));
	}

}
