/**
 * Treewordset. 
 * Binary search tree is actually fun :)
 * No duplication allowed
 */

package fs222mh_assign3.countWords;

import java.util.Iterator;

public class TreeWordSet implements WordSet{
	
	private Node root;		// Create a node class
	private int size;
	
	/**
	 * Constructor
	 */
	public TreeWordSet() {
		root = null;
		size = 0;
	}
	
	/**
	 * private node class. Lectures gave a good insight how to do this
	 */
	private class Node {
				
		public Word data;
		public Node left;
		public Node right;
		
		public Node(Word word) {
			data = word;
		}
		
		public void addNode(Node node) {
						
			if(node.data.compareTo(data) == 0) {	
				return;
			}

			if(node.data.compareTo(data) == -1) {		// add to left branch
				
				if(left == null) {
					left = node;
				}				
				else {
					left.addNode(node);		// use recursion
				}
			}			
			else {							// add to right branch
				if(right == null) {
					right = node;
				}				
				else {
					right.addNode(node); 	// use recursion
				}
			}
		}
	}
	
	/**
	 * Add new word to the tree. 
	 * 
	 * @param word
	 */
	@Override
	public void add(Word word) {
		
		if(contains(word)) {		// Check if word already exist
			return;
		}
		
		Node node = new Node(word);
		
		if(root == null) {		// the node will be root if there is no root
			root = node;
		}				
		else {					// else, going back for more
			root.addNode(node);
		}
		
		size++;
	 }

	/**
	 * Check whether or not a tree contains a word.
	 * 
	 * @param word to check.
	 */
	@Override
	public boolean contains(Word word) {
				
		Iterator<Word> iterator = new TreeIterator();
		
		while(iterator.hasNext()) {			
			if(word.equals(iterator.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the size of the set
	 * 
	 * @return size 
	 */
	@Override
	public int size() {
		return size;
	}
	
	
	
		
	/**
	 * TreeWordSet iterator.
	 * Got information about using a stack at: 
	 *  http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree,
	 *  http://stackoverflow.com/questions/4581576/implementing-an-iterator-over-a-binary-search-tree
	 */
	@Override
	public Iterator<Word> iterator() {
		return new TreeIterator();
	}
	
	private class TreeIterator implements Iterator<Word> {
				
		TreeStack stack = new TreeStack();
		private Node next;
		
		public TreeIterator() {
			next = root;
						
			if(next == null) {
				return;
			}
						
			while(next.left != null) {
				stack.push(next);
				next = next.left;
			}
		}
				
		@Override
		public boolean hasNext() {
			return next != null;
		}

		/**
		 *  the next element in the iterator.
		 */
		@Override
		public Word next() {
			
			Word word = next.data;
						
			if(stack.isEmpty() && next.right == null) {
				next = null;
				return word;
			}
						
			if(next.right != null) {
								
				Node recursor = next.right;
				
				while(recursor != null) {
					stack.push(recursor);
					recursor = recursor.left;
				}
			}
						
			next = stack.pop();
			
			return word;
			
		}
	}
	
	/**
	 * Stack for keeping track of parents, using push,pop and isEmpty
	 */
	private class TreeStack {
		
		Node[] nodes = new Node[0];
	
		public void push(Node node) {
			
			Node[] temp = new Node[nodes.length + 1];
			System.arraycopy(nodes, 0, temp, 0, nodes.length);
			
			temp[nodes.length] = node;
			
			nodes = new Node[temp.length];
			System.arraycopy(temp, 0, nodes, 0, temp.length);			
		}
		
		public Node pop() {
			
			Node node = nodes[nodes.length - 1];
			
			Node[] temp = new Node[nodes.length - 1];
			System.arraycopy(nodes, 0, temp, 0, temp.length);
			
			nodes = new Node[temp.length];
			System.arraycopy(temp, 0, nodes, 0, nodes.length);
			
			return node;
		}
				
		public boolean isEmpty() {
			return nodes.length == 0;
		}
	}

}
