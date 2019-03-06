package bank;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	private int custId;
	private static AtomicInteger custCount = new AtomicInteger(0); 
	private String custName;
	private String custCity;
	private String custPhone;
	private ArrayList<Transaction> transList = new ArrayList<Transaction>();
	private ArrayList<Account> accList = new ArrayList<Account>();
	private ArrayList<SavingAccount> sAccList = new ArrayList<SavingAccount>();
	private ArrayList<CheckingAccount> cAccList = new ArrayList<CheckingAccount>();

	public ArrayList<Transaction> getTransList() {
		return transList;
	}
	public ArrayList<Account> getAccList() {
		return accList;
	}
	public int getCustId() {
		return custId;
	}
	public void storeCustomerDetail(String custName,String custCity,
										String custPhone){
		this.custId = custCount.incrementAndGet();

		this.custName=custName;
		this.custCity=custCity;
		this.custPhone=custPhone;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
//	public void displayCustomerDetail(){
//		System.out.println(custId + "  " + custName + "   " + custCity + "   " + custPhone);
//		this.displayAccounts();
//	}
//	public void displayAccounts(){
//		if(!sAccList.isEmpty()) {
//			System.out.println("Savings Accounts:");
//			for(SavingAccount sAcc: sAccList) {
//				sAcc.displayAccDetail();
//			}
//		}
//		if (!cAccList.isEmpty()) {
//			 System.out.println("Checking Accounts:");
//			 for(CheckingAccount cAcc: cAccList) {
//				cAcc.displayAccountDetail();
//			}
//		}
//	}
	public void displayTransactions(){
		System.out.println("Transactions:");
		for(Transaction ob: transList) {
			ob.displayTransactionDetails();
		}
	}
	public void addSAccount(SavingAccount sAccount){
		this.accList.add(sAccount);
		this.sAccList.add(sAccount);
	}
	public void addCAccount(CheckingAccount cAccount){
		this.accList.add(cAccount);
		this.cAccList.add(cAccount);
	}
	public void addTransaction(Transaction transaction){
		this.transList.add(transaction);
	}
	
	public void deleteAcc(Integer accId) {
		
		if (accList.get(accId).getType().equals("Savings")) {
			System.out.println("Savings account deleted.");
			sAccList.remove(accList.get(accId));
		}else {
			System.out.println("Checking account deleted.");
			cAccList.remove(accList.get(accId));
		}
		//TODO fix bug when removing from accList
        //accList.remove(accList.get(accId));
	}
}