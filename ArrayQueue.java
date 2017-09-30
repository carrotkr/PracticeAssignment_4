/**
 * ArrayQueue
 */
public class ArrayQueue implements Queue {

	private class Node {
		Object item;
		Node next;
	}
	
	private Node first;
	private Node last;
	private int n;
	
	@Override
	public void enqueue(Object item) {
		Node beforeLast = last;
		last = new Node();
		
		last.item = item;
		last.next = null;
		
		if (empty()) {
			first = last;
		} else {
			beforeLast.next = last;
		}
		
		n++;
	}
	
	@Override
	public Object dequeue() {
		Object item = first.item;
		first = first.next;
		
		n--;
		
		if (empty()) {
			last = null;
		}
		
		return item;
	}

	@Override
	public boolean empty() {
		return first == null;
	}

}