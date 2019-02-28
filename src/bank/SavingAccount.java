package bank;

public class SavingAccount extends Account{

	private float interestRate; 
	
	//Class overloading- same function name, different amount of arguments
	public void storeAccountDetail(int accNo, double accBalance, float interestRate) {
		super.storeAccountDetail(accNo, accBalance);
		this.interestRate = interestRate;
	}
	public void displayAccDetail() {
		super.displayAccountDetail();
		System.out.println("Interest Rate : " + interestRate);
	}
}
