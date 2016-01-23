package fs222mh_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	@Override
	public void add(int n) {
		if (size < values.length - 1) { 	// If array is large enough, add n and increase size by one
			values[size += 1] = n;
		} else {						// else, call on resize() and double the array before adding n and increasing size by one
			this.resize();
			values[size += 1] = n;
		}
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		int temp = size + 1;
		
		if (size + 1 < values.length) {	// Verify that array is large enough
			if (size < index) {			// check that index doesn't point at existing value in array. Index needs to be larger
				values[index] = n;
				size += 1;
			} else {					// move last position to last position + 1 and repeat until (index -1). i.e shift right to fit new value in
				for ( int i = size; i > index - 1; i -= 1) {
					values[temp -= 1] = values[i];
				}
				values[index] = n;		// add n to position(index)
				size += 1;
			}
		} else {
			resize();					// call on resize()
			
			// Same code as above
			if (size < index) {
				values[index] = n;
				size += 1;
			} else {
				for (int i = size; i > index - 1; i -= 1) {
					values[temp -= 1] = values[i];
				}
				values[index] = n;
				size += 1;
			}
		}
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		for ( int i = index; i < size; i += 1) {	// switch left and override the value at position(index)
			values[i] = values[i + 1];
		}
		size -= 1;									// remove one
		
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		return values[index];
	}

	@Override
	public int indexOf(int n) {
		int[] array = new int[size];			// create array to store values 
		int position = 0;
		
		for (int i = 0; i <= size; i += 1) {
			if (get(i) == n) {
				array[position] = i;
				return position = array[position];			
			}
		}
		return -1;
	}
	
	

}
