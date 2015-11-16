
/**
 * @author Anders Ålander
 * <p>
 * Creates a customer object for the store simulation.
 */
public class Customer {
	/** The number of groceries the customer has currently */
	private int groceries = 0;
	/** On what time step the customer was added to the simulation */
	private int bornTime = 0;
	/** How long the customer has been waiting in the queue. Customers first in the queue are not waiting */
	private int waitTime = 0;
	/** The amount of groceries this customer have had registered so far in the register. */ 	
	private int groceriesRegistered = 0;
	/**
	 * Constructor for the customer class. 
	 * @param groceries Is the amount of groceries the customer will have when he is done shopping.
	 * @param bornTime Tells in what timestep this customer was created.
	 */
	public Customer(int groceries, int bornTime){
		this.groceries = groceries;
		this.bornTime = bornTime;
		this.waitTime = 0;
		this.groceriesRegistered = 0;
	}
	/** 
	 * This method is used on the first customer in the Register queue. 
	 * It decrements this customer's amount of groceries by one and registers it.
	 */
	public void serve(){
		if (groceries > 0){
			groceries--;
			groceriesRegistered++;
		}
	}
	/**
	 * Checks whether the customer is done or not. It is used by the Register
	 * remove the customer from the queue or not. A customer is done is defined as
	 * groceries = 0. Otherwise he is not done.
	 * @return Returns true if the customer is done, else false.
	 */
	public boolean isDone(){
		if (this.groceries == 0){
			return true;
		}
		else 
			return false;
	}
	/**
	 * Increases the wait time for this customer by one.
	 */
	public void incrementWaitTime(){
		waitTime++;
	}
	/**
	 * @return Returns the wait time of this customer. 
	 */
	public int getWaitTime(){
		return this.waitTime;
	}
	/**
	 * @return Returns the amount of groceries this customer currently have.
	 */
	public int getGroceries(){
		return this.groceries;
	}
	/**
	 * @return Returns the amount of groceries this customer have had
	 * registered so far.
	 */
	public int getGroceriesRegistered(){
		return this.groceriesRegistered;
	}
}