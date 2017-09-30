/**
 * ArrayStack
 */
public class ArrayStack implements Stack {

	private class Node {
		Object item;
		Node next;
	}
	
	private Node first;
	private int n;
	
	@Override
	public void push(Object item) {
		Node beforeFirst = first;
		first = new Node();
		
		first.item = item;
		first.next = beforeFirst;
		
		n++;
	}

	@Override
	public Object pop() {
		Object item = first.item;
		first = first.next;
		
		n--;
		
		return item;
	}
	
	@Override
	public Object peek() {
		return null;
	}

	@Override
	public boolean empty() {
		return first == null;
	}

}