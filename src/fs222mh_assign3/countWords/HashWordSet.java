package fs222mh_assign3.countWords;

import java.util.Iterator;

public class HashWordSet implements WordSet{
	
	private Node[] buckets;		// separate class created
	private int size;
	
	/**
	 * Constructor
	 */
	public HashWordSet() {
		buckets = new Node[1];
		size = 0;
	}
	
	/**
	 * Own Node Class that is a linked list
	 */
	private class Node {
		
		public Word data;
		public Node next;
		
		public Node(Word word) {
			data = word;
		}

	}
	
	
	/**
	 * Adds a word if it don't exist
	 */
	@Override
	public void add(Word word) {
		if (contains(word)) {
			return;
		}
		
		int bucketIndex = getIndex(word);	//find correct bucket
		
		Node node = new Node(word);			// Not found, add new node as first entry
		node.next = buckets[bucketIndex];
		buckets[bucketIndex] = node;
		
		size += 1;
		
		if (size == buckets.length) {		// Rehash if needed
			rehash();
		}
	}
	
	/**
	 * Rehash function, more or less copied from lecture notes
	 */
	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		size = 0;
		for (Node n : temp) {
			if(n == null) continue;
			while(n != null) {
				add(n.data);
				n = n.next;
			}
		}
	}

	private int getIndex(Word word) {
		
		int hash = word.hashCode();
		if (hash < 0) {
			hash -= hash;
		}
		
		hash = hash % buckets.length;
				
		return hash;
	}

	/**
	 * Checks if set contains a specific word
	 */
	@Override
	public boolean contains(Word word) {
		
		int bucketIndex = getIndex(word); 	//find correct bucket
		Node node = buckets[bucketIndex];	//First node in list
		
		// go through the list to see if there is a match.
		while (node != null) {
			if (node.data.equals(word)) {
				return true;				// Word found
			}
			node = node.next;				// Next node in list
		}
		return false;
	}

	/**
	 * Gives the size of the set
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Iterator for the hashwordset
	 */
	@Override
	public Iterator<Word> iterator() {
		return new HashWordSetIterator();
	}
	
	private class HashWordSetIterator implements Iterator<Word> {
		
		private int index;
		private Node node;
		
		// Iterator
		public HashWordSetIterator() {
			node = null;
			index = -1;
		}

		@Override
		public boolean hasNext() {
			if (node != null && node.next != null) {
				return true;
			}
			
			for (int i = index +1; i < buckets.length; i += 1) {
				if (buckets[i] != null) {
					return true;
				}
			}
			
			return false;
		}

		@Override
		public Word next() {
			
			if (node == null || node.next == null) {
				index += 1;
				
				// check if next bucket is empty or not
				while (buckets[index] == null && index < buckets.length) {
					index += 1;
				}
				
				if (index < buckets.length) {	// if there is more left before taking a new node from a bucket
					node = buckets[index];					
				}
				else {
					return null;		// No more words 
				}
			}
			
			// I mode nodes in the bucket, jump to next one
			else {
				node = node.next;
			}
			// Return data
			return node.data;
		}

	}

	

}
