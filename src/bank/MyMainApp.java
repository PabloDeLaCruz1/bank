package bank;
import java.util.*;

public class MyMainApp {
	public static void main(String s[])
	{
		Customer objCustomer = new Customer();
		SavingAccount custAccount = new SavingAccount();
		
		//Scanning
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Details..");
		
		int custId = sc.nextInt();
		String custName = sc.next();
		String custCity = sc.next();
		String custPhone = sc.next();
		
		System.out.println("Enter Customer Account Details..");

		int accNo = sc.nextInt();
		double accBalance = sc.nextDouble();
		float interestRate = sc.nextFloat();
		
		custAccount.storeAccountDetail(accNo, accBalance, interestRate);
		objCustomer.storeCustomerDetail(custId,custName,custCity,custPhone,custAccount);		
		objCustomer.displayCustomerDetail();
		
		//----------------------------------------------Second Customer -----------------------//

		Customer objCustomer1 = new Customer();
		CheckingAccount custAccount1 = new CheckingAccount();
		
				
		System.out.println("Enter Customer Details..");
		
		int custId1 = sc.nextInt();
		String custName1 = sc.next();
		String custCity1 = sc.next();
		String custPhone1 = sc.next();
		
		System.out.println("Enter Customer Account Details..");

		int accNo1 = sc.nextInt();
		double accBalance1 = sc.nextDouble();
		int od = sc.nextInt();
		
		custAccount1.storeAccountDetail(accNo1, accBalance1, od);
		objCustomer1.storeCustomerDetail(custId1, custName1, custCity1, custPhone1, custAccount1);		
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
