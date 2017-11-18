/**
 * ArrayQueue
 */
public class ArrayQueue implements Queue {
	
	private Object[] values;
	private int numOfElements;
	private int first;
	private int last;
	
	/**
	 * ArrayQueue
	 */
	public ArrayQueue() {
		values = new Object[2];
		numOfElements = 0;
        first = 0;
        last = 0;
    }
	
	/**
	 * resize
	 * 
	 * @param
	 */
	 private void resize(int sizeCap) {
		 Object[] temp = new Object[sizeCap];

		 for (int i = 0; i < numOfElements; i++) {
			 temp[i] = values[(first + i) % values.length];
		 }
	        
		 values = temp;
		 first = 0;
		 last = numOfElements;
	 }
	
	/**
	 * enqueue
	 * 
	 * @param
	 */
	@Override
	public void enqueue(Object item) {
		if (numOfElements == values.length) {
			resize(2*values.length);   
		}
		
		values[last++] = item;
		
		if (last == values.length) {
			last = 0;
		}

		numOfElements++;
	}

	/**
	 * dequeue
	 * 
	 * @return
	 */
	@Override
	public Object dequeue() {
		Object item = values[first];
		
		values[first] = null;
		
		numOfElements--;
		first++;
		
		if (first == values.length) {
			first = 0;
		}
		
		if (numOfElements > 0 && numOfElements == values.length/4) {
    			resize(values.length/2); 
		}
		
		return item;
	}

	/**
	 * empty
	 * 
	 * @return
	 */
	@Override
	public boolean empty() {
		return (numOfElements == 0);
	}
	
}
