
/**
 * The Class Inventory.
 */
public class Inventory {

	/** The minimum per item. */
	private final int MIN_PER_ITEM = 700;

	/** The max per item. */
	private final int MAX_PER_ITEM = 1000;

	/** The cheese. */
	private IStack<FoodEntry> cheese;

	/** The tomatoes. */
	private IStack<FoodEntry> tomatoes;

	/** The buns. */
	private IStack<FoodEntry> buns;

	/** The patties. */
	private IStack<FoodEntry> patties;

	/** The lettuce. */
	private IStack<FoodEntry> lettuce;

	/** The onions. */
	private IStack<FoodEntry> onions;

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory () {
		buns     = new Stack<>();
		patties  = new Stack<>();
		cheese   = new Stack<>();
		onions   = new Stack<>();
		lettuce  = new Stack<>();
		tomatoes = new Stack<>();
	}

	/**
	 * Creates the burger.
	 *
	 * @return true, if successful
	 */
	public boolean createItemOne () {
		if (buns.isEmpty() || 
				patties.isEmpty() || 
				tomatoes.isEmpty() 
				|| onions.isEmpty() || 
				lettuce.isEmpty()) {
			return false;
		} else {
			tomatoes.pop();
			patties.pop();
			buns.pop();
			onions.pop();
			lettuce.pop();
			cheese.pop();
		}
		return true;
	}

	/**
	 * Creates the cheese burger.
	 *
	 * @return true, if successful
	 */
	public boolean createItemTwo() {
		if (cheese.isEmpty() || 
				buns.isEmpty() || 
				patties.isEmpty()
				|| lettuce.isEmpty() || 
				tomatoes.isEmpty() || 
				onions.isEmpty()) {
			return false;
		} else {
			cheese.pop();
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
			onions.pop();
		}
		return true;
	}

	/**
	 * Creates the vegan lettuce wrap burger.
	 *
	 * @return true, if successful
	 */
	public boolean createItemThree() {
		if (lettuce.getSize() < 2 || 
				tomatoes.isEmpty() || 
				onions.isEmpty()) {
			return false;
		} else {
			lettuce.pop();
			lettuce.pop();
			tomatoes.pop();
			onions.pop();
		}
		return true;
	}

	/**
	 * Creates the burger no onion.
	 *
	 * @return true, if successful
	 */
	public boolean createItemFour() {
		if (buns.isEmpty() || 
				patties.isEmpty() || 
				lettuce.isEmpty()
				|| tomatoes.isEmpty()) {
			return false;
		} else {
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}

	/**
	 * Creates cheese burger no onion.
	 *
	 * @return true, if successful
	 */
	public boolean createItemFive() {
		if (cheese.isEmpty() || 
				buns.isEmpty() || 
				patties.isEmpty()
				|| lettuce.isEmpty() 
				|| tomatoes.isEmpty()) {
			return false;
		} else {
			cheese.pop();
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}

	/**
	 * Creates the burger no tomato.
	 *
	 * @return true, if successful
	 */
	public boolean createITemSix() {
		if (buns.isEmpty() || 
				patties.isEmpty() || 
				lettuce.isEmpty()
				|| onions.isEmpty()) {
			return false;
		} else {
			buns.pop();
			patties.pop();
			lettuce.pop();
			onions.pop();
		}
		return true;
	}

	/**
	 * Shipment arrives.
	 *
	 * @param dateArriv the date arrival
	 */
	public void shipmentArrives(int dateArriv) {

		int bunsAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < bunsAmount; a ++) {
			FoodEntry bun = new Bun();
			bun.setExpDate (dateArriv + 2);
			buns.push(bun);
		}
		int cheeseAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < cheeseAmount; a ++) {
			FoodEntry cheese = new Cheese();
			cheese.setExpDate (dateArriv + 3);
			this.cheese.push(cheese);
		}
		int lettuceAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < lettuceAmount; a ++) {
			FoodEntry lettuce = new Lettuce();
			lettuce.setExpDate (dateArriv + 3);
			this.lettuce.push(lettuce);
		}
		int onionAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < onionAmount; a ++){
			FoodEntry onion = new Onion();
			onion.setExpDate (dateArriv + 2);
			onions.push(onion);
		}
		int pattyAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < pattyAmount; a ++){
			FoodEntry patty = new Patty();
			patty.setExpDate (dateArriv + 5);
			patties.push(patty);
		}
		int tomatoAmount = Driver.RAND.nextInt(MAX_PER_ITEM - MIN_PER_ITEM + 1) + MIN_PER_ITEM;
		for (int a = 0; a < tomatoAmount ; a ++){
			FoodEntry tomato = new Tomato();
			tomato.setExpDate (dateArriv + 4);
			tomatoes.push(tomato);
		}
	} // method

	/**
	 * Manages the food.
	 *
	 * @param date the date
	 * @return the sorted array
	 */
	public int[] manageFood (int date) {
		return new int[]{
				manageCheese(date), 
				manageBun(date), 
				managePatty(date), 
				manageLettuce(date), 
				manageTomato(date), 
				manageOnion(date)};
	}

	/**
	 * Manages onion.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int manageOnion(int date) {
		int res = 0;
		FoodEntry[] tmp = new Onion[onions.getSize()];
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = onions.pop();
		}
		sortOutFood( tmp );
		for (int a = 0; a < tmp.length; a ++) {
			Onion onion = (Onion)tmp[a];
			if (date < onion.getExpDate()) {
				onions.push(onion);
			} else {
				res ++;
			}
		}
		return res;
	}

	/**
	 * Manages tomato.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int manageTomato(int date) {
		int res = 0;
		FoodEntry[] tmp = new Tomato[tomatoes.getSize()];
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = tomatoes.pop();
		}
		sortOutFood(tmp);
		for (int a = 0; a < tmp.length; a ++) {
			Tomato tomato = (Tomato)tmp[a];
			if (date < tomato.getExpDate()) {
				tomatoes.push(tomato);
			} else {
				res ++;
			}
		}
		return res;
	}

	/**
	 * Manages lettuce.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int manageLettuce(int date) {
		int res = 0;
		FoodEntry[] tmp = new Lettuce[lettuce.getSize()];
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = lettuce.pop();
		}
		sortOutFood( tmp );
		for (int a = 0; a < tmp.length; a ++) {
			Lettuce lettuce = (Lettuce)tmp[a];
			if (date < lettuce.getExpDate()) {
				this.lettuce.push(lettuce);
			} else {
				res ++;
			}
		}
		return res;
	}

	/**
	 * Manages patty.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int managePatty(int date) {
		int res = 0;
		FoodEntry[] tmp = new Patty[patties.getSize()];
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = patties.pop();
		}
		sortOutFood(tmp);
		for (int a = 0; a < tmp.length; a ++) {
			Patty p = (Patty)tmp[a];
			if (date < p.getExpDate()) {
				patties.push(p);
			} else {
				res ++;
			}
		}
		return res;
	}

	/**
	 * Manages cheese.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int manageCheese(int date) {
		FoodEntry[] tmp = new Cheese[cheese.getSize()];
		int res = 0;
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = cheese.pop();
		}
		sortOutFood(tmp);
		for (int a = 0; a < tmp.length; a ++) {
			Cheese cheese = (Cheese)tmp[a];
			if (date < cheese.getExpDate()) {
				this.cheese.push(cheese);
			} else {
				res ++; 
			}
		}
		return res;
	}

	/**
	 * Manages bun.
	 *
	 * @param date the date
	 * @return the index
	 */
	private int manageBun(int date) {
		int res = 0;
		FoodEntry[] tmp = new Bun[buns.getSize()];
		for (int a = 0; a < tmp.length; a ++) {
			tmp[a] = buns.pop();
		}
		sortOutFood(tmp);
		for (int a = 0; a < tmp.length; a ++) {
			Bun bun = (Bun)tmp[a];
			if (date < bun.getExpDate() ) {
				buns.push(bun);
			} else {
				res++;
			}
		}
		return res;
	}

	/**
	 * Sorts out the food.
	 *
	 * @param entries the entries
	 */
	private void sortOutFood (FoodEntry[] entries) {

		for (int a = 0; a < entries.length - 1; a ++) {

			int cur = a;

			for (int b = a + 1; b < entries.length; b ++) {
				if (entries[b].getExpDate() < entries[cur].getExpDate())
					cur = b;
			}

			FoodEntry tmpEntry = entries[cur];
			entries[cur] = entries[a];
			entries[a] = tmpEntry;
		} // outer for loop
	} // method

} // class
