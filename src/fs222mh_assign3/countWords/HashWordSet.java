package fs222mh_assign3.countWords;

import java.util.Iterator;

public class HashWordSet implements WordSet{
	
	private Node[] buckets;		// separate class created
	private int size;
	
	/**
	 * Constructor
	 */
	public HashWordSet() {
		buckets = new Node[256];
		size = 0;
	}
	
	/**
	 * Own Node Class
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
		
		Node node = new Node(word);
		node.next = buckets[bucketIndex];
		buckets[bucketIndex] = node;
		
		size += 1;
		
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
		Node node = buckets[bucketIndex];
		
		// go through the list to see if there is a match.
		while (node != null) {
			if (node.data.equals(word)) {
				return true;
			}
			node = node.next;
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
	 * Aouch, an iterator. Creating a new class for iterating the hashwordset
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
					return null;		// No more words = return null
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
