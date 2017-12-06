
/**
 * Stores the customer
 * with the specific number.
 */
public class Customer {
	
	/** The number. */
	private int number;

	/**
	 * Instantiates a new customer.
	 *
	 * @param number the number
	 */
	public Customer(int number) {
		this.number = number;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer " + number;
	}
	
}
