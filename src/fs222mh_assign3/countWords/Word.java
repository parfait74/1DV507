package fs222mh_assign3.countWords;

public class Word implements Comparable<Word> {
	
	private String word;
	
	public Word(String word) {
		this.word = word.toLowerCase();
	}
	
	public String toString() {
		return word;
	}
	
	@Override
	public int hashCode() {
		
		//this didn't work trying to sum up the ASCII, got really weird numbers most likely due to sum get's the same hash for words with the same letters in it
		/*int hash = 0;
		for (int i = 0; i < word.length(); i += 1) {
			char c = word.toLowerCase().charAt(i);
			hash += Character.getNumericValue(c);
		}*/
		
		// Looked online for a solution to create a hash function, http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
		int hash = 222;
		for (int i = 0; i < word.length(); i += 1) {
			hash = ((hash << 5) + hash) + word.toLowerCase().charAt(i);
		}
		
		return hash;
	}
	
	@Override
	public boolean equals(Object other) {
		return hashCode() == other.hashCode();
	}

	@Override
	public int compareTo(Word w) {
		if (this.equals(w)) {
			return 0;
		}
		
		for (int i = 0; i < toString().length(); i += 1) {
			if(toString().charAt(i) < w.toString().charAt(i)) {
				return -1;
			}
			if (toString().charAt(i) > w.toString().charAt(i)) {
				return 1;
			}
			if (i == toString().length() - 1) {
				return -1;
			}
			if (i == w.toString().length() - 1) {
				return 1;
			}
		}
		
		return 0;
	}
	
	
	
	
	
	
	

}
