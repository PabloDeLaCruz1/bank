package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BankServices {
	Map<Integer, Customer> allCustomers = new HashMap<Integer, Customer>();

//	public void showAllCustomers() {
//		Set<Integer> allKeys = allCustomers.keySet();
//		for(Integer k : allKeys) {
//			allCustomers.get(k).displayCustomerDetail();
//		}
//	}
	public void addNewCustomer(Customer customer) {
		allCustomers.put(customer.getCustId(), customer);
	}
	public Customer searchCustomer(Integer custId) {
		return allCustomers.get(custId);
	}
	public void deleteCustomer(Integer custId) {
		allCustomers.remove(custId);
	}
}
