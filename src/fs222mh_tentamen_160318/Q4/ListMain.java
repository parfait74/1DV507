package fs222mh_tentamen_160318.Q4;

import java.util.Iterator;

/**
 * A simple program demonstrating how to use most of the methods 
 * in the LinkedIntList class.
 *
 * @author jonasl
 *
 */
public class ListMain {


	public static void main(String[] args) {
		LinkedIntList list = new LinkedIntList();
		
		System.out.println("Testing "+list.getClass().getName());
		for (int i=0;i<10;i++)
			list.add(i*10);
		System.out.println(list);
		
		System.out.println("Size = "+list.size());
		System.out.println("At pos 5: = "+list.get(5));
		System.out.println("At pos 0: = "+list.get(0));
		System.out.println("At pos 9: = "+list.get(9));
		
		System.out.println("Index of 99: = "+list.indexOf(99));
		System.out.println("Index of 40: = "+list.indexOf(40));
		System.out.println("Index of 555: = "+list.indexOf(555));
		
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.print("  "+it.next());
		System.out.println("\n\n");
		
		// Check addAt method
		list.addAt(33, 4);
		System.out.println("Checking the addAt method at index 4");
		Iterator<Integer> it3 = list.iterator();
		while (it3.hasNext())
			System.out.print("  "+it3.next());
		System.out.println("\n\n");
		
		// Check remove method
		list.remove(4);
		System.out.println("Checking the remove method at index 4");
		Iterator<Integer> it4 = list.iterator();
		while (it4.hasNext())
			System.out.print("  "+it4.next());
		System.out.println("\n\n");
		
		//Check reverse method
		list.reverse();
		System.out.println("Reversing the list: ");
		Iterator<Integer> it2 = list.iterator();
		while (it2.hasNext())
			System.out.print("  "+it2.next());
		System.out.println("\n\n");
		
		//Check isLargerThen
		LinkedIntList listTest = new LinkedIntList();
		listTest.add(5);
		if ( list.isLargerThan(listTest)) {
			System.out.println("list is larger");
		}
		
		

	}

}
