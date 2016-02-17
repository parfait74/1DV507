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
		int hash = 631;

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
