import java.util.ArrayList;


public class Store {
	//Generic dynamic "array" that grows in size when needed
	private ArrayList<Register> registerArray = new ArrayList<Register>();
	
/*
 * Constructor creates an array of registers for the store and
 * opens one of them.
 * <p>
 * @param numberOfRegisters The number of registers the store will have. It has to be greater than 0.
 */
	public Store(int numberOfRegisters) {
		this.registerArray = new ArrayList<Register>();
		Register r;
		for(int i = 0;i<numberOfRegisters;i++){
			r = new Register();
			this.registerArray.add(i,r);
		}
		this.registerArray.get(0).openRegister();
	}

	/*
	 * Steps all the registers in the store.
	 */
	public void step(){
		Register r;

		for (int i = 0; i<this.registerArray.size();i++){
			r = this.registerArray.get(i);
			r.step();
			this.registerArray.set(i, r);
		}	
	}
	/*
	 * Opens a new register in the store.
	 */
	public void openNewRegister(){
		for(Register r : this.registerArray){
			if(!r.isOpen()){
				r.openRegister();
				break;
			}
		}
	}
	/*
	 * @return It Returns true if the store has at least one open register, otherwise it returns false.
	 */
	public boolean hasOpenRegisters(){
		for(int i = 0; i<registerArray.size();i++){
			if(this.registerArray.get(i).isOpen() == true){
				return true;
			}
		}
		return false;
	}
	/*
	 * Creates a new customer and places him in the store's shortest queue.
	 */
	public void newCustomer(int groceries, int bornTime){
		Customer c = new Customer(groceries, bornTime);
		int index;
		Register r;

		index = this.getShortestQueueRegisterIndex();

		r = this.registerArray.get(index).addToQueue(c);
//		this.registerArray.set(index, r);

		
	}
	/*
	 * @return It returns the index of the queue in the store that has the shortest queue.
	 */
	private int getShortestQueueRegisterIndex() {
		int min = this.registerArray.get(0).getQueueLength();
		int index = 0;
		for (int i = 1; i< this.registerArray.size();i++){
			if (this.registerArray.get(i).getQueueLength() < min && this.registerArray.get(i).isOpen())
				index = i;	
		}
		return index;

	}
	/*
	 * @return It returns the average queue length in this store
	 * in decimal form. If there are no registers in the store, 
	 * it returns 0.
	 */
	public double getAverageQueueLength(){
		int m = 0; int openRegisters = 0;
		for (int i = 0; i < this.getRegisterArray().size();i++){
			if (this.registerArray.get(i).isOpen()){
				m += this.registerArray.get(i).getQueueLength();
				openRegisters++;
			}
		}
		return (m/openRegisters);
	}
/*
 * Checks whether the store has any customers currently.
 * @return It returns true if there are customers in the store currently, otherwise it returns false.
 */
	public boolean hasCustomers(){
		for(int i = 0; i<registerArray.size();i++){
			if(0 < registerArray.get(i).getQueueLength()){
				return true;
			}
		}
		return false;
	}	
	/*
	 * @return Returns an ArrayList of all the done customers in this time step.
	 */
	public ArrayList<Customer> getDoneCustomers(){
		ArrayList<Customer> doneCustomers = new ArrayList<Customer>();
		for (int i = 0; i<this.registerArray.size();i++){
			if(this.registerArray.get(i).getDoneCustomer() != null){//adds non-null customers 
				doneCustomers.add(this.registerArray.get(i).getDoneCustomer());
			}
		}
		return doneCustomers;
	}
	/*
	 * @return It returns the ArrayList of registers in the store.
	 */
	public ArrayList<Register> getRegisterArray(){
		return this.registerArray;
	}



}


