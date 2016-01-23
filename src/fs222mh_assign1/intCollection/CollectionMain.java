package fs222mh_assign1.intCollection;

public class CollectionMain {

	public static void main(String[] args) {
		
		// ArrayIntList
		ArrayIntList list = new ArrayIntList();
				
		for (int i = 0; i < 24; i += 1) { 
			list.add(i);
		}
		
		System.out.println("ArrayIntList starts here:");

		System.out.println("The list contains: " + list);
		System.out.println("The size of the list: " + list.size);
		
		list.addAt(2, 5);		
		System.out.println("The list contains: " + list);
		System.out.println("The size of the list: " + list.size);
		
		list.remove(2);
		System.out.println("The list contains: " + list);
		System.out.println("The size of the list: " + list.size);
		
		System.out.println("Value at position 14: " + list.get(14));
		System.out.println("Value at position 6: " + list.get(6));
		System.out.println("Value 2 are at position: " + list.indexOf(2));
		System.out.println("Value 11 are at position: " + list.indexOf(11));

		//ArrayIntStack
		ArrayIntStack stack = new ArrayIntStack();
		
		for (int i = 0; i < 15; i += 1) {
			stack.push(i);
		}
		
		System.out.println("\n\nArrayIntStack starts here:");
		
		System.out.println("Size of the stack are: " + stack.size);
		System.out.println("The stack contains: " + stack);
		
		stack.pop();
		System.out.println("Size of the stack are: " + stack.size);
		System.out.println("The stack contains: " + stack);
		
		System.out.println("Topvalue of stack is: " + stack.peek());
		
		
	}		

}
