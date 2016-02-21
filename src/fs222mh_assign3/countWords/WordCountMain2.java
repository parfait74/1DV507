/**
 * Class trying out the hash and wordtree sets.
 * Count of words is 349 on both. Still close enough :)
 */
package fs222mh_assign3.countWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class WordCountMain2 {

	public static void main(String[] args) {
		
		Scanner scan = null;
		List<Word> words = new ArrayList<>();
		
		try {
			scan = new Scanner(new File("words.txt"));
		}
		catch(FileNotFoundException e) {
			
		}
		
		/**
		 *  Populate the list.
		 */
		while(scan.hasNext()) {
			words.add(new Word(scan.next()));
		}
		
		scan.close();
		
		/**
		 * Hash set
		 */
		HashWordSet hash = new HashWordSet();
		
		for(Word word : words) {
			hash.add(word);
		}
		
		System.out.println(hash.size());
		
		/**
		 * Tree set
		 */
		TreeWordSet tree = new TreeWordSet();
		
		for(Word word : words) {
			tree.add(word);
		}
		
		System.out.println(tree.size());
		
		/**
		 * Alphabetically, from the tree iterator.
		 */
		Iterator<Word> iterator = tree.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();
		
		/**
		 * trying the hashiterator
		 */
		iterator = hash.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
