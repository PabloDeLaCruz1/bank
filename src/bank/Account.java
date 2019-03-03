package bank;

//TODO change to interface
//interface Account{
//	public void createAccount;
//	public void deleteAccount;
//}
public abstract class Account {
	private int accNo;
	
	private double accBalance;

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	
	public void storeAccountDetail(int accNo,double accBalance)
	{
		this.accNo = accNo;
		this.accBalance=accBalance;
	}
	public void displayAccountDetail()
	{
		System.out.println(accNo + "   "  + accBalance);
	}
	
	public double getAccBalance() {
		return accBalance;	
	}
}
