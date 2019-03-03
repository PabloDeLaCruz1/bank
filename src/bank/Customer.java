package bank;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public class Customer {
	//Always start with private variables, change to public as needed in the the future. 
	private int custId; //primitive types: int 4bytes-char 2bytes-float 2bytes-short-long-double-boolean-byte

	private String custName;
	private String custCity;
	private String custPhone;
	private Account custAccount;
//	private Map<String, List<Transaction>> transList = new HashMap<String,ArrayList<Transaction>>();
	private ArrayList<Transaction> transList = new ArrayList<Transaction>();
	private ArrayList<Account> accList = new ArrayList<Account>();
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	//Java creates a constructor for  you if you don't create one. 
	
	public void storeCustomerDetail(int custId,String custName,String custCity,
										String custPhone,Account custAccount,
										ArrayList<Account> accList, ArrayList<Transaction> transList)
	{
		this.custId = custId;
		this.custName=custName;
		this.custCity=custCity;
		this.custPhone=custPhone;
		this.custAccount = custAccount;
		this.accList = accList;
		this.transList = transList;
	}
	public Account getAccount()
	{
		return custAccount;
	}
	public void displayCustomerDetail()
	{
		System.out.println(custId + "  " + custName + "   " + custCity + "   " + custPhone);
		custAccount.displayAccountDetail();
	}

	public void addSAccount(SavingAccount sAccount){
		this.accList.add(sAccount);
	}
	public void addCAccount(CheckingAccount cAccount){
		this.accList.add(cAccount);
	}
	public void addTransaction(Transaction transaction){
		this.transList.add(transaction);
	}

}