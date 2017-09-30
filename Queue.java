public interface Queue {
	
	public void enqueue(Object item);
	
	public Object dequeue();	
	
	public boolean empty();

}
