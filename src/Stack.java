
/**
 * The Class Stack.
 *
 * @param <E> the element type
 */
public class Stack<E > implements IStack<E > {
	
	/** The Constant INITIAL_CAPACITY. */
	private static final int INITIAL_CAPACITY = 10;

	/** The size. */
	private int size;
	
	/** The items. */
	private E [] items;

	/**
	 * Instantiates a new stack.
	 */
	@SuppressWarnings("unchecked")
	public Stack () {
		this.items = (E []) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Instantiates a new stack.
	 *
	 * @param size the size
	 */
	@SuppressWarnings("unchecked")
	public Stack (int size) {
		this.items = (E []) new Object[size];
		size = 0;
	}

	/* (non-Javadoc)
	 * @see IStack#push(java.lang.Object)
	 */
	@Override
	public void push (E entry) {
		updateCapacity ();
		items[size] = entry;
		size ++;
	}

	/* (non-Javadoc)
	 * @see IStack#pop()
	 */
	@Override
	public E pop() {
		if (!isEmpty()) {
			size--;
			return items[size];
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see IStack#peek()
	 */
	@Override
	public E peek() {
		return items[size-1];
	}

	/* (non-Javadoc)
	 * @see IStack#isEmpty()
	 */
	@Override
	public boolean isEmpty(){
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see IStack#getSize()
	 */
	@Override
	public int getSize () {
		return size;
	}

	/* (non-Javadoc)
	 * @see IStack#clear()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		items = (E []) new Object[INITIAL_CAPACITY];
		size = 0;						 
	}
	
	/**
	 * Update capacity.
	 */
	@SuppressWarnings("unchecked")
	private void updateCapacity () {
		if (size == items.length ) {
			E [] tempBag = (E [])new Object[size * 2];
			for (int a = 0; a < size; a++) {
				tempBag[a] = items[a];
			}
			items = tempBag;
		}
	}

} // class
