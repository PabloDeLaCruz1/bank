package bank;
import java.util.Scanner;

public class MyMainApp {
	static DataBase db = new DataBase();
	static BankServices allCustomers = new BankServices();
	static Scanner sc = new Scanner(System.in);
	//-----DB---//
	static java.util.Date dt = new java.util.Date();
	static java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static String currentTime = sdf.format(dt);
	

	public static void storeAllCustomers(){
		try {
			//Create dummy accounts and transactions
			SavingAccount sAccount0 = new SavingAccount();
			SavingAccount sAccount1 = new SavingAccount();
//			sAccount0.storeAccountDetail(10000, 1);
//			sAccount1.storeAccountDetail(20000, 2);
			
			CheckingAccount cAccount0 = new CheckingAccount();
			CheckingAccount cAccount1 = new CheckingAccount();
			
			cAccount0.storeAccountDetail(10000, 1);
			cAccount1.storeAccountDetail(20000, 2);
			
			Transaction transaction10 = new Transaction();
			Transaction transaction11 = new Transaction();
			Transaction transaction20 = new Transaction();
			Transaction transaction22 = new Transaction();
			
			Customer cust1 = new Customer();
			Customer cust2 = new Customer();
			
			cust1.storeCustomerDetail("Pabloo", "paterson", "9322312312");
			cust2.storeCustomerDetail("Pedro", "P-Town", "9322311111");
			
			cust1.addSAccount(sAccount0);
			cust1.addCAccount(cAccount0);
			cust1.addTransaction(transaction10);
			cust1.addTransaction(transaction11);
			cust2.addTransaction(transaction20);
			cust2.addTransaction(transaction22);
			
			transaction10.storeTransactionDetails(111, 1, "Savings");
			transaction11.storeTransactionDetails(1111, 11, "Checking");
			transaction20.storeTransactionDetails(222, 2, "Savings");
			transaction22.storeTransactionDetails(2222, 22, "Savings");
			
			cust2.addSAccount(sAccount1);
			cust2.addCAccount(cAccount1);
			
			allCustomers.addNewCustomer(cust1);
			allCustomers.addNewCustomer(cust2);
			
			System.out.println("Stored all customers, accounts and services");

		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void newCustomer() throws PhoneNumberException{
		try {
			System.out.println("Enter Customers Name");
			String custName = sc.next();
			
			System.out.println("Enter Customers City");
			String custCity = sc.next();
			
			String custPhone = null;
			boolean retry = true;
			while(retry) {
				System.out.println("Enter Customer Phone");
				custPhone = sc.next();
				retry = validatePhone(custPhone);	
			}

			Customer newCust = new Customer();
			newCust.storeCustomerDetail(custName, custCity, custPhone);
			Integer custId = newCust.getCustId();
			allCustomers.allCustomers.put(custId,newCust);
			
			db.insertCustomer(custName, custCity, custPhone);
			
			newAccount(newCust);
				
		}catch (PhoneNumberException e) {
			System.out.println(e.getErrorMesssage());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public void newAccount(Customer currentCust) {
			System.out.println("What type of account do you want? (S for savings, C for checking");
		String accType = sc.next();
		
		switch(accType) {
		case"S":
			System.out.println("Enter Customer Account Details for savings account.");
			System.out.println("Balance: ");
			int sAccBalance = sc.nextInt();
			System.out.println("Interest Rate: ");
	
			float interestRate = sc.nextFloat();
			
			SavingAccount newSAccount = new SavingAccount();
//			newSAccount.storeAccountDetail(sAccBalance, interestRate);
			currentCust.addSAccount(newSAccount);
			
			//----DB-----//
			
			db.insertAccount(sAccBalance, "Savings", currentCust.getCustId());
			
			break;
				
		case"C":
			System.out.println("Enter Customer Account Details for Checking Account.");
			System.out.println("Balance: ");
			int cAccBalance = sc.nextInt();
			System.out.println("Overdraft: ");
	
			int od = sc.nextInt();	
			
			CheckingAccount newCAccount = new CheckingAccount();
			newCAccount.storeAccountDetail(cAccBalance, od);
			currentCust.addCAccount(newCAccount);
			
			db.insertAccount(cAccBalance, "Checking", currentCust.getCustId());

		break;
		default:
			System.out.println("Please enter S or C");
			}
		}
	public boolean mainMenu(boolean retry) {
		try {
			System.out.println("-----------------Welcome to Bank of Pablo-----------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("-------------------1--Customer Login----------------------");
			System.out.println("-------------------2--Create New Customer-----------------");
			System.out.println("-------------------3--Display All Customer(Admin Only)----");
			System.out.println("-------------------4--Exit--------------------------------");
			
			System.out.println("Please select (1-4)");
			int choiceofTransaction = sc.nextInt();
			
			switch(choiceofTransaction) {
			case 1:
				System.out.println("Please enter customer ID");
				Integer custId = sc.nextInt();
				Customer currentCust = db.getCustomer(custId);
				
//				currentCust.displayAccounts();
				db.showAllCustomerAccounts(custId);
				System.out.println("Please enter Account ID");
				Integer accId = sc.nextInt();
				System.out.println("Hello!, " + currentCust.getCustName());
				
				while(retry) {
					retry = menuScreen(currentCust, accId, retry);	
				}
				break;
			case 2:
				newCustomer();
				break;
			case 3:
				db.showAllCustomers();
				break;
			case 4:
				retry = false;
				break;
			default:
				System.out.println("Not a correct choice...of transaction");
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return true;
	}
	public boolean menuScreen(Customer currentCust, Integer accId, boolean retry)  throws CashWithdrawalException {
		try {		
			Scanner sc = new Scanner(System.in);
			MyMainApp bankApp = new MyMainApp();
			AccountServices ac = new AccountServices();
			Account currentAcc = db.getAccount(accId);
			int custId = currentAcc.getCustId();
			
			System.out.println("-----------------Welcome to Bank of Pablo-----------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("-------------------1--Get Balance-------------------------");
			System.out.println("-------------------2--Cash Withdrawl----------------------");
			System.out.println("-------------------3--Fund Transfer-----------------------");
			System.out.println("-------------------4--Display Account Details-------------");
			System.out.println("-------------------5--Display Transaction Details---------");
			System.out.println("-------------------6--Add New Account---------------------");
			System.out.println("-------------------7--Show Customer Information-----------");
			System.out.println("-------------------8--Delete Customer Account-------------");
			System.out.println("-------------------9--Delete Savings or Checking Acount---");
			System.out.println("-------------------0--Exit--------------------------------");
			System.out.println("----------------------------------------------------------");
			
			System.out.println("Enter your choice of transaction(1-9)");
			int choiceofTransaction = sc.nextInt();
			
			switch(choiceofTransaction) {
			case 1:
				currentAcc.getAccBalance();
				break;
			case 2:
				System.out.println("Please enter the amount to withdrawal");
				int amountToWithdrawal = sc.nextInt();
				if (amountToWithdrawal < 0) {
					throw new CashWithdrawalException();
				}
				ac.cashWithdraw(amountToWithdrawal, currentAcc);
				System.out.println("Thank you for your withdrawal of: " + amountToWithdrawal +". Your new balance is: $" + currentAcc.getAccBalance());
				
				Transaction newTransaction = new Transaction();
				newTransaction.storeTransactionDetails(amountToWithdrawal, accId, "Withdrawal");
				currentCust.addTransaction(newTransaction);
				
				//-----DB---//
				//Update Account
				db.updateAccount(custId, currentAcc.getAccBalance() - amountToWithdrawal);
				
				//Add transaction
				dt = new java.util.Date();
				currentTime = sdf.format(dt);
				db.insertTransaction(amountToWithdrawal, accId, "Withdrawal", currentTime );
				
				break;
			case 3:
				boolean retryTransfer = true;
				Customer recievingCustomer = null;
				Account accountTo = null;
				while(retryTransfer) {
					System.out.println("Please enter the second customer id.");
					int recievingCustomerId = sc.nextInt();
				    recievingCustomer = db.getCustomer(recievingCustomerId);

					System.out.println("Please enter the second customer Account id.");
					int accountToId = sc.nextInt();
					accountTo = db.getAccount(accountToId);
					
					retryTransfer = bankApp.validateAccount(recievingCustomer);	
				}
				
				System.out.println("Please enter the amount to transfer");
				int amountToTrasnfer = sc.nextInt();
//				ac.fundTransfer(currentAcc, accountTo, amountToTrasnfer);
				System.out.println("Thank you for your transfer of: " + amountToTrasnfer +". Your new balance is: $" + currentAcc.getAccBalance());
				
				//-----DB---//
				//Update Account
				System.out.println("custId" + custId);
				System.out.println("currentAcc.getAccBalance()" + currentAcc.getAccBalance());
				System.out.println("amountToTrasnfer" + amountToTrasnfer);
				System.out.println("accountTo.getCustId()" + accountTo.getCustId());
				System.out.println("accountTo.getAccBalance()" + accountTo.getAccBalance());
				
				db.updateAccount(custId, currentAcc.getAccBalance() - amountToTrasnfer);
				db.updateAccount(accountTo.getCustId(), accountTo.getAccBalance() + amountToTrasnfer);

				//Add transaction
				dt = new java.util.Date();
				currentTime = sdf.format(dt);
				db.insertTransaction(amountToTrasnfer, accId, "Transfer", currentTime );
				
				break;
			case 4:
				db.showAllCustomerAccounts(custId);
				break;
			case 5:
				currentCust.displayTransactions();
				break;
			case 6:
				newAccount(currentCust);
				break;
			case 7:
//				currentCust.displayCustomerDetail();
				break;
			case 8:
				allCustomers.deleteCustomer(currentCust.getCustId());
				break;
			case 9:
				currentCust.deleteAcc(accId);
//				currentCust.displayAccounts();
				
				System.out.println("Please enter Account ID");
				Integer newAccId = sc.nextInt();
				
				while(retry) {
					retry = menuScreen(currentCust, newAccId, retry);	
				}
				break;
			case 0:
				retry = false;
				break;
			default:
					System.out.println("Not a correct choice of transaction");
					break;
			}

		} catch (CashWithdrawalException e) {
			System.out.println(e.getErrorMesssage());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
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
			MyMainApp bankApp = new MyMainApp();
			MyMainApp.storeAllCustomers();
			boolean retry = true;
			
			while(retry) {
				retry = bankApp.mainMenu(retry);	
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			System.out.println("~~~Thank you for visiting Pablo's Bank. Until next time~~~");
		}	
	}
}