
/**
 * The Class FoodEntry.
 */
public abstract class FoodEntry {
	
	/** The expire date. */
	private int expDate;

	/**
	 * Gets the expire date.
	 *
	 * @return the expire date
	 */
	public int getExpDate() {
		return expDate;
	}

	/**
	 * Sets the expire date.
	 *
	 * @param expDate the new expire date
	 */
	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public abstract String getName();

} // class
