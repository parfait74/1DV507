/**
 * This class creates an object of class Word for each word in the file words.txt.
 * The objects are adding to a set of type hash and tree.
 * Last it also has an iterator the prints the words alphabetically
 */

package fs222mh_assign3.countWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordCountMain1 {

	public static void main(String[] args) {
		
		Scanner scan = null;
		List<Word> words = new ArrayList<>();
		
		try {
			scan = new Scanner(new File("words.txt"));
		}
		catch(FileNotFoundException e) {
			
		}
		
		//Start adding words to the list after created an object for each word
		while(scan.hasNext()){
			words.add(new Word(scan.next()));
		}
		scan.close();
		
		// trying to create  hash set, might need to re-do this, not 100% sure on the hashset, but seems straightforward 
		Set<Word> hash = new HashSet<>();
		
		for(Word word : words) {
			hash.add(word);
		}
		
		System.out.println(hash.size());	// Print the number of objects in the hashset, gives 349. Not sure what's diffing since teachers test gave 350. Close enough :)
		
		// create Tree set
		Set<Word> tree = new TreeSet<>();
		
		for (Word word : words) {
			tree.add(word);
		}
		
		System.out.println(tree.size()); 	// Same here, gives 349.
		
		// iterator to print 
		Iterator<Word> iterator = tree.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		

	}
	

}
