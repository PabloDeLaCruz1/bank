package bank;
import java.util.*;



public class MyMainApp {
	
	 static Customer objCustomer[];
	 static List<Transaction> transList1 = new ArrayList<Transaction>();
	 static List<Transaction> transList2 = new ArrayList<Transaction>();

	 static Transaction sTrans[];
	
	public void storeAllCustomers(){
		try {
		Scanner sc = new Scanner(System.in);
		MyMainApp bankApp = new MyMainApp();
		Map<String, Customer> bankMap = new HashMap<String, Customer>();
		
		//Creates 2 customers as dummy data
		objCustomer = new Customer[2];
					
		//Adds customers to bank app
		BankServices bServices = new BankServices();
		bServices.addNewCustomer(objCustomer[0]);
		bServices.addNewCustomer(objCustomer[1]);

		//Create dummy accounts and transactions
		SavingAccount sAccount0 = new SavingAccount();
		SavingAccount sAccount1 = new SavingAccount();
		CheckingAccount cAccount0 = new CheckingAccount();
		CheckingAccount cAccount1 = new CheckingAccount();
		Transaction transaction00 = new Transaction();
		Transaction transaction01 = new Transaction();
		Transaction transaction10 = new Transaction();
		Transaction transaction11 = new Transaction();

		
		//Adds accounts and transactions to our customers
		objCustomer[0].addSAccount(sAccount0);
		objCustomer[0].addCAccount(cAccount0);
		objCustomer[0].addTransaction(transaction00);
		objCustomer[0].addTransaction(transaction01);
		
		objCustomer[1].addSAccount(sAccount1);
		objCustomer[1].addCAccount(cAccount1);
		objCustomer[1].addTransaction(transaction10);
		objCustomer[1].addTransaction(transaction11);
		
		//Adds transactions to our customers
//		custMap.put("1", transList1);
//		custMap.put("2", transList2);

		for(int cnt =0; cnt < objCustomer.length; cnt++) {
			System.out.println("Enter Customer details for customer number: " + cnt);
			objCustomer[cnt] = new Customer();
			
			System.out.println("What type of account do you want? (S for savings, C for checking");
//			String accType = sc.next();
			
			System.out.println("Enter Customer Details (id,name,city,phone)");
			
//			int custId = sc.nextInt();
//			String custName = sc.next();
//			String custCity = sc.next();
			
			boolean retry = true;
			String custPhone = null;
			
			while(retry) {
				System.out.println("please enter phone number");
//				custPhone = sc.next();
				retry = bankApp.validatePhone("1234567890");	
			}

			switch("S") {
			case"S":
				System.out.println("Enter Customer Account Details for savings account..(accNo, balance, interest");
//				int accNo = sc.nextInt();
//				double accBalance = sc.nextDouble();
//				float interestRate = sc.nextFloat();
				
//				SavingAccount sa = new SavingAccount();
//				sa.storeAccountDetail(1, 10000, 2);
//				objCustomer[cnt].storeCustomerDetail(1+cnt, "Pablo"+cnt, "Paterson"+cnt, custPhone, sa, null,null);
				
				break;
					
			case"C":
				System.out.println("Enter Customer Account Details for checking account..(id, balance, od");
				int accNo1 = sc.nextInt();
				double accBalance1 = sc.nextDouble();
				int od = sc.nextInt();	
				
//				CheckingAccount ca = new CheckingAccount();
//				ca.storeAccountDetail(accNo1, accBalance1, od);
//				objCustomer[cnt].storeCustomerDetail(1+cnt, "Pablo"+cnt, "Paterson"+cnt, "832323", ca, null, null);
				
				break;
			}
		}
		}
//		catch (PhoneNumberException e) {
//		System.out.println(e.getErrorMesssage());
//		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void displayAllCustomers() {
		for(Customer cust : objCustomer) {
			cust.displayCustomerDetail();
			System.out.println("--------------------");
		}
	}
	
	
	public Customer searchCustomer(int custId) {
		System.out.println(objCustomer);
			for(Customer cust : objCustomer) {
				if(cust.getCustId() == custId) {
					System.out.println("Employee found");
					return cust;
				}
			}
			return null;
		}
		
	public boolean menuScreen(AccountServices ac, Customer currentCust, boolean retry)  throws CashWithdrawalException {
		try {		
			Scanner sc = new Scanner(System.in);
			MyMainApp bankApp = new MyMainApp();

		System.out.println("----------------------Welcome to BOA----------------------");
		System.out.println("----------------------------------------------------------");
		System.out.println("-------------------1--Get Balance-------------------------");
		System.out.println("-------------------2--Cash Withdrawl----------------------");
		System.out.println("-------------------3--Fund Transfer-----------------------");
		System.out.println("-------------------4--Display Account Details-------------");
		System.out.println("-------------------5--Exit--------------------------------");
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Enter your choice of transaction...");
		int choiceofTransaction = sc.nextInt();
		
		switch(choiceofTransaction) {
		case 1:
			System.out.println("Youre balance is : $" + ac.getBalance(currentCust));
			break;
		case 2:
			System.out.println("Please enter the amount to withdrawal");
			int amountToWithdrawal = sc.nextInt();
			if (amountToWithdrawal < 0) {
				throw new CashWithdrawalException();
			}
			ac.cashWithdraw(currentCust, amountToWithdrawal);
			System.out.println("Thank you for your withdrawal of: " + amountToWithdrawal +". Your new balance is: $" + ac.getBalance(currentCust));
			break;
		case 3:
			boolean retryTransfer = true;
			Customer recievingCustomer = null;
			while(retryTransfer) {
				System.out.println("Please enter the second customer id.");

				int recievingCustomerId = sc.nextInt();
				 System.out.println("objcustomer---" + objCustomer[1].getCustId());
				 System.out.println(bankApp.searchCustomer(recievingCustomerId));
				 System.out.println("HELLLLO2");

				recievingCustomer = bankApp.searchCustomer(recievingCustomerId);
				retryTransfer = bankApp.validateAccount(recievingCustomer);	
			}
			

			System.out.println("Please enter the amount to transfer");
			int amountToTrasnfer = sc.nextInt();
			ac.fundTransfer(currentCust, recievingCustomer,amountToTrasnfer);
			System.out.println("Thank you for your transfer of: " + amountToTrasnfer +". Your new balance is: $" + ac.getBalance(currentCust));
			break;
		case 4:
			currentCust.displayCustomerDetail();
			break;
		case 5:
			retry = false;
		default:
				System.out.println("Not a correct choice...of transaction");
				break;
		}
//		System.out.println("do you want to continue...(Y/N");
//		String choice = sc.next();
//		if(!choice.equals("Y")) {
//			break;
//		}
	} catch (CashWithdrawalException e) {
		// TODO: handle exception
		System.out.println(e.getErrorMesssage());
	}
	catch (Exception e) {
		// TODO: handle exception
	}
		return retry;
	}

	private boolean validateAccount(Customer recievingCustomer) throws NullAccountException {
		try {
			if(recievingCustomer == null ) {
				throw new NullAccountException();
			}else {
				return false;
			}
		} catch (NullAccountException e) {
			System.out.println(e.getErrorMessage());
			return true;
		}
	}
	public boolean validatePhone(String custPhone)  throws PhoneNumberException {
		try {
				String pattern = "\\d{10}";   
		if (custPhone.matches(pattern)) {
				return false;
			}else {
				throw new PhoneNumberException();
			}
		}catch (PhoneNumberException e) {
			System.out.println(e.getErrorMesssage());
			return true;
		}
	}
	public static void main(String s[]){
		try{
			System.out.println("Please enter customer ID");
			Scanner sc = new Scanner(System.in);
	
			int custId = sc.nextInt();
			MyMainApp bankApp = new MyMainApp();
			bankApp.storeAllCustomers();
			AccountServices ac = new AccountServices();
			Customer currentCust = bankApp.searchCustomer(custId);
			boolean retry = true;
			while(retry) {
				retry = bankApp.menuScreen(ac, currentCust, retry);	
			}
		}catch (Exception e) {
		// TODO: handle exception
		}finally {
			System.out.println("Thank you Note lol");
		}	
	}

}