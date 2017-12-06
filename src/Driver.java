
import java.util.Random;

/**
 * The Class Driver.
 * This class contains main 
 * method to test this program.
 */
public class Driver {

	/**
	 * Random generator of integers.
	 */
	public final static Random RAND = new Random();

	/** The Constant MAX_QUEUE_PEOPLE. */
	public final static int MAX_QUEUE_PEOPLE = 50;

	/**
	 * Must be printed for each day.
	 * Increments if item are not available.
	 */
	private static int lostCustomerDay;

	/**
	 * Must be printed for each day.
	 * Increments if no cheese.
	 */
	private static int wasteCheese;

	/**
	 * Must be printed for each day.
	 * Increments if no bun.
	 */
	private static int wasteBun;

	/**
	 * Must be printed for each day.
	 * Increments if no patty.
	 */
	private static int wastePatty;

	/**
	 * Must be printed for each day.
	 * Increments if no lettuce.
	 */
	private static int wasteLettuce;

	/**
	 * Must be printed for each day.
	 * Increments if no tomato.
	 */
	private static int wasteTomato;

	/**
	 * Must be printed for each day.
	 * Increments if no onion.
	 */
	private static int wasteOnion;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Burger.
	 */
	private static int countItemOne;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Cheese Burger.
	 */
	private static int countItemTwo;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Vegan lettuce wrap Burger.
	 */
	private static int countItemThree;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Burger No Onion.
	 */
	private static int countItemFour;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Cheese Burger No Onion.
	 */
	private static int countItemFive;

	/**
	 * Must be printed for each day.
	 * Increments if the customer orders Burger NoTomato.
	 */
	private static int countItemSix;
	
	/**
	 * Stores customer as a key and number of menu as a value.
	 */
	private static Dictionary<Customer, Integer> dictCust;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		
		dictCust = new Dictionary<>();

		test(inventory);

	} // main

	/**
	 * Tests the program.
	 *
	 * @param inventory the inventory
	 */
	private static void test(Inventory inventory) {

		/*
		 * Loop through the all days in December.
		 */
		for (int day = 0, next = 1201; day < 31; day ++, next ++) {

			// Choose shipment day randomly (3-6 days).
			int shipmentArrival = RAND.nextInt(4) + 3;

			if (day % shipmentArrival == 0) {
				inventory.shipmentArrives(next);
			}

			/*
			 * Loop through the 10 possible hours (10AM - 7PM).
			 */
			for (int h = 10; h < 20; h ++) {

				// Customers arrive on the hour between 1-100 people.
				int custAmount = RAND.nextInt(100) + 1;

				/*
				 * The line can hold up to 50 people.
				 */
				Queue<Customer> customers = new Queue<Customer>(50);

				if (custAmount > MAX_QUEUE_PEOPLE) {
					lostCustomerDay = lostCustomerDay + custAmount - MAX_QUEUE_PEOPLE;
					custAmount = MAX_QUEUE_PEOPLE;
				}

				int curNumCust = 0;

				// Add every customer to the queue.
				do {
					customers.add(new Customer(curNumCust));
					curNumCust ++;
				} while (curNumCust != custAmount);

				/*
				 * Create all required orders while
				 * there is at least one customer
				 * in line.
				 */
				while (!customers.isEmpty()) {

					/*
					 * Customer makes order randomly from list 1-6.
					 */
					int numItems = RAND.nextInt(6);

					boolean ordered = false;

					if (numItems == 0 && inventory.createItemOne()) {
						countItemOne++;
						ordered = true;
					} else if (numItems == 1 && inventory.createItemTwo()) {
						countItemTwo++;
						ordered = true;
					} else if (numItems == 2 && inventory.createItemThree()) {
						countItemThree++;
						ordered = true;
					} else if (numItems == 3 && inventory.createItemFour()) {
						countItemFour++;
						ordered = true;
					} else if (numItems == 4 && inventory.createItemFive()) {
						countItemFive++;
						ordered = true;
					} else if (numItems == 5 && inventory.createITemSix()) {
						countItemSix++;
						ordered = true;
					}
					if (!ordered){
						lostCustomerDay++;
					}
					Customer cust = customers.remove();
					dictCust.put(cust, numItems);
				}
				
				printCustomers();
				dictCust.clear();
			}

			/*
			 * Manage inventory to avoid using waste food.
			 */
			int[] foodWasted = inventory.manageFood(next);
			wasteCheese  = foodWasted[0];
			wasteBun     = foodWasted[1];
			wastePatty   = foodWasted[2];
			wasteLettuce = foodWasted[3];
			wasteTomato  = foodWasted[4];
			wasteOnion   = foodWasted[5];

			printStatistics(next);

			updateVariables();	
		}
	}

	/**
	 * Updates variables.
	 */
	private static void updateVariables() {
		lostCustomerDay = 0;
		countItemOne    = 0;
		countItemTwo    = 0;
		countItemThree  = 0;
		countItemFour   = 0;
		countItemFive   = 0;
		countItemSix    = 0;
		wasteCheese     = 0;
		wasteBun        = 0;
		wastePatty      = 0;
		wasteLettuce    = 0;
		wasteTomato     = 0;
		wasteOnion      = 0;
	} // method

	/**
	 * Prints the statistics.
	 *
	 * @param currentDate the current date
	 */
	private static void printStatistics(int currentDate) {
		System.out.println("December:                         " + (currentDate - 1200));
		System.out.println("Lost Customer Day:                " + lostCustomerDay);
		System.out.println("Waste Cheese:                     " + wasteCheese);
		System.out.println("Waste Bun:                        " + wasteBun);
		System.out.println("Waste Patty:                      " + wastePatty);
		System.out.println("Waste Lettuce:                    " + wasteLettuce);
		System.out.println("Waste Tomato:                     " + wasteTomato);
		System.out.println("Waste Onion:                      " + wasteOnion);
		System.out.println("Burgers ready:                    " + countItemOne);
		System.out.println("Cheese Burgers ready:             " + countItemTwo);
		System.out.println("Vegan lettuce wrap Burgers ready: " + countItemThree);
		System.out.println("Burgers No Onion ready:           " + countItemFour);
		System.out.println("Cheese Burgers No Onion ready:    " + countItemFive);
		System.out.println("Burgers No Tomato ready:          " + countItemSix + "\n");
	}
	
	/**
	 * Prints all customers with orders.
	 */
	private static void printCustomers() {
		System.out.println(dictCust);
	}

} // class
