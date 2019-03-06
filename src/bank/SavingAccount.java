package bank;

public class SavingAccount extends Account{
	
	public void storeAccountDetail(int accBalance, int custId	) {
		super.storeAccountDetail(accBalance, "Savings", custId);
	}
//	public void displayAccDetail() {
//		System.out.println("Savings Account ID: " + super.getAccNo() + " || Balance: "  + super.getAccBalance() + " || Interest Rate: " + this.interestRate + " || Type: " + super.getType());
//	}
}
