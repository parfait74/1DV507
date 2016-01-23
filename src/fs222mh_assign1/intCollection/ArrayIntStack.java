package fs222mh_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{

	@Override
	public void push(int n) {
		if (size < values.length - 1) {		// If stack is large enough, add value
			values[size += 1] = n;
		} else {						// else, call on resize() and then add value
			resize();
			values[size += 1] = n;
		}
		
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		int i = values[size - 1];	// saves the value
		values[size - 1] = 0;		// reset the value
		size -= 1;
		return i;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		return values[size - 1];
	}
	
	

}
