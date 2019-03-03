package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankServices {
	//Variables
	Map<Integer, List<Account>> allCustomers = new HashMap<Integer, List<Account>>();

	
	//Methods
	public Map<Integer, List<Account>> getAllCustomers() {
		return allCustomers;
	}
	
	public void addNewCustomer(Customer customer) {
		allCustomers.put(customer.getCustId(), null);
	}
	

}
