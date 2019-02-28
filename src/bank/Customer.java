package bank;

public class Customer {
	//Always start with private variables, change to public as needed in the the future. 
	private int custId; //primitive types: int 4bytes-char 2bytes-float 2bytes-short-long-double-boolean-byte
	private String custName;
	private String custCity;
	private String custPhone;
	private Account custAccount;
	
	
	//Java creates a constructor for  you if you dont create one. 
	
	public void storeCustomerDetail(int custId,String custName,String custCity,
										String custPhone,Account custAccount)
	{
		this.custId = custId;
		this.custName=custName;
		this.custCity=custCity;
		this.custPhone=custPhone;
		this.custAccount = custAccount;
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
}