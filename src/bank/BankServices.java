package bank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BankServices {
	//Variables
	Map<Integer, Customer> allCustomers = new HashMap<Integer, Customer>();

	
	//Methods
	public void getAllCustomers() {
		Set<Integer> allKeys = allCustomers.keySet();
		
		for(Integer k : allKeys) {
			allCustomers.get(k).displayCustomerDetail();
		}
		
	}
	
	
	
	public void addNewCustomer(Customer customer) {
		allCustomers.put(customer.getCustId(), null);
	}
	
	public Customer searchCustomer(Integer custId) {
		

		return allCustomers.get(custId);
	}
	
//	public Customer searchCustomer(int custId) {
//		System.out.println(objCustomer);
//			for(Customer cust : objCustomer) {
//				if(cust.getCustId() == custId) {
//					System.out.println("Employee found");
//					return cust;
//				}
//			}
//			return null;
//		}

}
