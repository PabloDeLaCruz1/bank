package bank;

public class MyMainApp {
	public static void main(String s[])
	{
		Customer objCustomer = new Customer();
		SavingAccount objAccount = new SavingAccount();
		objAccount.storeAccountDetail(111, 20000, 4.5f);
		objCustomer.storeCustomerDetail(1,"John","Phx","34343434",objAccount);		
		objCustomer.displayCustomerDetail();
		
		

		Customer objCustomer1 = new Customer();
		CheckingAccount objAccount1 = new CheckingAccount();
		objAccount1.storeAccountDetail(112, 30000);
		objCustomer1.storeCustomerDetail(2,"George","Phx","98343434",objAccount1);		
		objCustomer1.displayCustomerDetail();
		
		
		//--------------------------------------------------Services-----------------//
		
		AccountServices as = new AccountServices();
		/*
		//balance enquiry service
		double balance = as.getBalance(objCustomer1);
		System.out.println("Customer Balance :" + balance);
		
		
		//500$ Withdraw service
		as.cashWithdraw(objCustomer1, 5000);
		objCustomer1.displayCustomerDetail();*/
		
		//5000$ Fund Transfer service
//		as.fundTransfer(objCustomer, objCustomer1, 5000);	
//
//		objCustomer.displayCustomerDetail();
//		objCustomer1.displayCustomerDetail();
		
		double balance1 = as.getBalance(objCustomer);
		double balance2 = as.getBalance(objCustomer1);
		
		System.out.println("Balance of customer 1 : " + balance1);
		System.out.println("Balance of customer 2 : " + balance2);
		
		as.cashWithdraw(objCustomer, 120000);
		objCustomer.displayCustomerDetail();
		
		
	}
}
