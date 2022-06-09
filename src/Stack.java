import java.util.NoSuchElementException;

public class Stack<T> {
	 Node top;
	int n;
	
	class Node {
		 T value; // the item in the node
		 Node next; // reference to next item
	}

	public Stack() {
		top = null;
		n = 1;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return this.n;
	}

	public void clear() {
		top.next=null;
		top = null;
		n = 0;
	}

	public void push(T item) {
		Node node = new Node();
		node.value = item;
		if (this.isEmpty()) {
			top = node;
			return;
		}
		node.next = top;
		top = node;
		n++;

	}

	public T pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Node temp = top;
		top = top.next;
		n--;
		return temp.value;
	}

	public T peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return top.value;
	}

}
