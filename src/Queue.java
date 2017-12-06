
/**
 * The Class Queue.
 *
 * @param <E> the element type
 */
public class Queue<E> implements IQueue<E> {
	
	/** The Constant INITIAL_CAPACITY. */
	private static final int INITIAL_CAPACITY = 10;
	
	/** The items. */
	private E[] items;
	
	/** The head. */
	private int head;
	
	/** The rear. */
	private int rear;
	
	/**
	 * Instantiates a new queue.
	 */
	public Queue () {
		this (INITIAL_CAPACITY);
	}
	
	/**
	 * Instantiates a new queue.
	 *
	 * @param size the size
	 */
	@SuppressWarnings("unchecked")
	public Queue (int size) {
		int newSize = size + 1;
		items = (E[]) new Object[newSize];
		rear = size;
		head = 0;
	}
	
	/* (non-Javadoc)
	 * @see IQueue#add(java.lang.Object)
	 */
	@Override
	public void add (E entry) {
		if (head == ((rear + 2) % items.length)){
			return; // Queue is full.
		}
		int newRear = rear + 1;
		rear = newRear % items.length;
		items[rear] = entry;
	}

	/* (non-Javadoc)
	 * @see IQueue#remove()
	 */
	@Override
	public E remove () {
		if(isEmpty()) {
			return null; // Cannot remove from empty queue.
		}
		E temp = items[head];
		items[head] = null;
		int newHead = head + 1;
		head = newHead % items.length;
		return temp;
	}

	/* (non-Javadoc)
	 * @see IQueue#get()
	 */
	@Override
	public E get () {
		if (isEmpty()) {
			return null;
		}
		return items[head];
	}
	
	/* (non-Javadoc)
	 * @see IQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return head == (rear + 1) % items.length;
	}

	/* (non-Javadoc)
	 * @see IQueue#clear()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.items = (E[]) new Object[items.length];
		rear = items.length - 1;
		head = 0;
		
	}

} // class
