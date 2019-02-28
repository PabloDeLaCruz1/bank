package bank;

public class CheckingAccount extends Account {
	private int od;
	private float interestRate = 2.0f;
	
	public void storeAccountDetail(int accNo, double accBalance, int od ) {
		super.storeAccountDetail(accNo, accBalance);
		this.od=od;
	}
	public void displayAccountDetail() {
		super.displayAccountDetail();
		System.out.println("Interest Rate is: " + this.interestRate) ;

		System.out.println("Overdraft amount is: " + this.od) ;
	}
}
