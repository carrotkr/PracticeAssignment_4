/**
 * ArrayStack
 */
public class ArrayStack implements Stack {
	
	private Object[] values;
	private int numOfElements;
	
	/**
	 * ArrayStack
	 */
	public ArrayStack() {
		values = new Object[2];
		numOfElements = 0;
    }
	
	/**
	 * resize
	 * 
	 * @param
	 */
    private void resize(int sizeCap) {
        Object[] temp = new Object[sizeCap];
        
        for (int i = 0; i < numOfElements; i++) {
            temp[i] = values[i];
        }
        
        values = temp;
    }
	
	/**
	 * push
	 * 
	 * @param
	 */
	@Override
	public void push(Object item) {
		if (numOfElements == values.length) {
				resize(2*values.length);
		}
		
		values[numOfElements++] = item;
	}

	/**
	 * pop
	 * 
	 * @return
	 */
	@Override
	public Object pop() {
		Object item = values[numOfElements-1];
		
		values[numOfElements-1] = null;
		
		numOfElements--;
		
		if ((numOfElements > 0) && (numOfElements == values.length/4)) {
    			resize(values.length/2);
		}
		
		return item;
	}

	/**
	 * peek
	 * 
	 * @return
	 */
	@Override
	public Object peek() {
		return values[numOfElements-1];
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
