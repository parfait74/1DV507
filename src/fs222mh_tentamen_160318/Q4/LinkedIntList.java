package fs222mh_tentamen_160318.Q4;

import java.util.Iterator;


/**
 * A single-linked implementation of the <code>IntList</code> interface.
 * This is a minimalistic implementation where no extra methods are
 * added to the public interface. The implementation makes use of 
 * two private inner classes (<code>Node</code> and <code>ListIterator</code>)
 * that are hidden and considered as implementation details.
 *  
 * @author jonasl
 *
 */
public class LinkedIntList {
	private int size = 0;
	private Node head = null;

	/** Creates an empty list. */
    public LinkedIntList() {}
    
	
	public void add(int n) {
		if (head == null)
			head = new Node(n);
		else {
			Node node = head;
			while (node.next != null)
				node = node.next;
			node.next = new Node(n);
		}
		size++;
	}

	
	public int get(int index) throws IndexOutOfBoundsException {
		checkIndex(index,size);
		Node node = head;
		for (int i=0;i<index;i++)
			node = node.next;
		return node.value;
	}


	
	public int indexOf(int n) {
		Node node = head;
		int index = 0;
		while (node != null) {
			if (node.value == n)
				return index;
			index++;
			node = node.next;
		}
		return -1;
	}

	
	public int size() {
		return size;
	}
	

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[ ");
		Node node = head;
		while (node != null) {
			buf.append(node.value +" ");
			node = node.next;
		}
		buf.append("]");
		return buf.toString();
	}
	
	
	public Iterator<Integer> iterator() {
		return new ListIterator();
	}

	/*
	 * Add element n and position index. It should not replace the existing 
	 * element at position index, it should  insert it at index and move the existing 
	 * elements at position >=index one step backwards. Exception if the position is 
	 * outside the range of valid/possible indices.
	 * 
	 */
	/**
	 * Method to add at specific position in the list
	 * @param n
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		// Create new node and see if it's the first, if so add it
		Node newNode = new Node(n);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} 
		// find the node where to add and insert the new node
		else {
			Node before = head;
			for (int i = 0; i < index - 1; i += 1) {
				before = before.next;
			}
			newNode.next = before.next;
			before.next = newNode;
		}
		size += 1;
	}
	
	/*
	 * A method public boolean isLargerThan(LinkedIntList otherList) that compare this
	 * list with otherList. Starting from the head, we compare the two lists element by element.
	 * As soon as we find an element that is larger than the corresponding element in the other list
	 * we stop and declare the list with the largest element as “larger”. If they have the same initial
	 * sequence of elements but one list contains more elements, than the longer list is larger. 
	 * A few examples
	 * {4,3} vs {1,2,3,4,5} ==> {4,3} is larger since 4 > 1
	 * {1,2,3,4} vs {1,3,5} ==> {1,3,5} is larger since 3 > 2
	 * {1,2,3,4} vs {1,2,3} ==> {1,2,3,4} is larger since the first list is longer 
	 */
	/**
	 * Got the pseudo code written, just can't get my head around it for now, not quite right.
	 * @param otherList
	 * @return
	 */
	public boolean isLargerThan(LinkedIntList otherList) {
		// Create iterator so I can traverse through the lists
		Iterator<Integer> itA = this.iterator();
		Iterator<Integer> itB = otherList.iterator();
		
		// As long as there are values to compare
		while(itA.hasNext() && itB.hasNext()) {
			Integer NodeA = itA.next();				
			Integer NodeB = itB.next();
			if (NodeA > NodeB) {
				return true;
			} else if (NodeA < NodeB) {
				return false;
			}
		}
		
		if (itA.hasNext() && !itB.hasNext()) {
			return true;
		}
		
		return false;
	}
	

	/*
	 * Remove element at position index by removing the corresponding node 
	 * from the list. Exception if the position is 
	 * outside the range of valid/possible indices.
	 */
	/**
	 * Method to remove at index
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		// if index 0
		if (index == 0) {
		}
		//Find node before so we can "remove" by setting next to the node behind the removed one
		else {
			Node before = head;
			for (int i = 0; i < index - 1; i += 1 ) {
				before = before.next;
			}
			Node delete = before.next;
			before.next = delete.next;
		}
		size -= 1;
		
		
	}
	
	/*
	 * Reverses the content of the list by reversing the order of 
	 * the nodes in the list.
	 */
	/**
	 * Might work, confused me a lot while figuring it out. Not 100% it works as expected
	 */
	public void reverse() {
		Node before = null;
		Node tmp = head;
		while(tmp != null) {
			Node next = tmp.next;
			tmp.next = before;
			before = tmp;
			tmp = next;
		}
		head = before;
		
	}
	
	/* 
	 * Private class members considered as implementation details. 
	 * 
	 */
	private void checkIndex(int index, int upper) throws IndexOutOfBoundsException {
		if (index < 0 || index >= upper) {
			String msg = "Index = "+index+", Upper boundary = "+upper;
			throw new IndexOutOfBoundsException(msg);
		}
	}
	
	class ListIterator implements Iterator<Integer> {
		private Node node = head;
		public Integer next() {
			int val = node.value;
			node = node.next;
			return val;
		}
		
		public boolean hasNext() {return node != null;}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}

	private class Node {
		int value;
		Node next = null;
		
		Node(int v) { value = v;}
	}
}

