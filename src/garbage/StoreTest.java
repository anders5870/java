package garbage;
import Customer;
import Store;

import java.util.ArrayList;


public class StoreTest {

	public static void main(String[] args) {
		Store s = new Store();
		System.out.println("Genomsnittskölängden är " + s.getAverageQueueLength());
		s.step();
		System.out.println("The store got open registers " + s.hasOpenRegisters());
		if (!s.hasOpenRegisters() && s.hasCustomers()){
			s.openNewRegister();
		}
		System.out.println("The store got open registers " + s.hasOpenRegisters());
		ArrayList<Customer> doneCustomers = s.getDoneCustomers();
		
	}
	

}
