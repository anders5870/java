import java.util.LinkedList;

/**
 * @author Anders Alander
 * This class creates the Register object. It holds a queue of customers
 * and tells whether the register is open or not. This class is used by
 * the Store class since a Store is just a number of Registers.
 */
public class Register {
	/** open tells whether the register is open or not */
	private boolean open;
	/** q is the register's queue represented as a linked list */
	private LinkedList<Customer> q = new LinkedList<Customer>();
	/** doneCustomer is the customer that is done in this register in this time step */
	private Customer doneCustomer;
	/**
	 * Constructor of Register.
	 * Open will be set to false and a new queue is made.
	 */
	public Register(){
		this.open = false;
		this.q = new LinkedList<Customer>();
	}
	/**
	 * Steps the queue forward.
	 * It uses the help methods:
	 * <p>
	 * @link #incrementWaitTime()
	 * @link #serveFirstCustomer()
	 * @link #checkoutDoneCustomer()
	 */
	public void step(){
		this.serveFirstCustomer();
		if(!this.q.isEmpty()){
			this.checkoutDoneCustomer();
		}
		this.incrementWaitTime();
	}
	/**
	 * Increases the wait time variable for each customer in the queue
	 * that aren't first in the queue. 
	 */
	private void incrementWaitTime(){
		Customer c;
		for (int i = 1; i < this.getQueueLength(); i++){
			c = this.getCustomer(i);
			c.incrementWaitTime();
			this.q.set(i, c);
		}
		
	}
	/**
	 * Serves the first customer by calling
	 * @link #serve() on him, if there is anyone
	 * to serve. When a customer is served the
	 * number of groceriesRegistered in this register
	 * is incremented by one.
	 */
	private void serveFirstCustomer(){
		Customer current = (Customer)this.q.peek();
		if (current != null){
			current.serve();
		}
	}
	/**
	 * Help function for step()
	 * It checks if the first customer is done
	 * If he is done he leaves the register and
	 * becomes the doneCustomer in this time step.
	 * If he is not done doneCustomer is set to null
	 * in this time step.
	 * <p>
	 * @link #doneCustomers
	 */
	private void checkoutDoneCustomer(){
		
		if (this.currentCustomerIsDone()){
			doneCustomer = this.q.remove(0);
			
		}	
		else doneCustomer = null;
		
	}
	/**
	 * Checks if the register is open.
	 * @return It returns true if the register is open else it returns false.
	 */
	public boolean isOpen(){
		if (this.open == true){
			return true;				
		}else{
			return false;
		}
	}
	/**
	 * Closes the register
	 * @return It returns the register that was closed.
	 */
	public Register closeRegister(){
		this.open = false;
		return this;
	}	
	/**
	 * Checks whether the first customer in the queue don't 
	 * have any more groceries that needs registering.
	 * @return Returns true if the customer is done, else false.
	 */
	public boolean currentCustomerIsDone(){
		Customer current = this.q.peek();
		if (current.isDone() == true) 
			return true;
			else return false;
	}
	/**
	 * Creates a new customer and places him last in this
	 * register's queue.
	 */
	public Register addToQueue(Customer c){
		this.q.add(c);
		return this;
	}
	/**
	 * @return Returns the queue length of this register.
	 */
	public int getQueueLength(){
		return this.q.size();
	}
	/**
	 * @return Opens a new register and returns it.
	 */
	public Register openRegister(){
		this.open = true;
		return this;
	}
	/**
	 * @return Returns the ArrayList of all the done customers in this register so far
	 */
	public Customer getDoneCustomer(){
		return this.doneCustomer;
	}
	/**
	 * @param i is the index in the Registers queue. This number must be
	 * equal or greater than 0 and less than the length of the queue.
	 * The length of the queue can be fetched by @link #getQueueLength().
	 * @return Returns the customer at index i in the register's queue.
	 */
	public Customer getCustomer(int i){
		return this.q.get(i);
	}
	/**
	 * @return Checks if the Register's queue is empty or not. Returns true if it is empty, else false.
	 */
	public boolean isEmpty(){
		if (this.q.isEmpty()==true) return true;
		else return false;
	}
}
