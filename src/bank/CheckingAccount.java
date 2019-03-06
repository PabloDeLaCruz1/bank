package bank;

public class CheckingAccount extends Account {
	
	
	public void storeAccountDetail(int accBalance, int custId ) {
		super.storeAccountDetail(accBalance, "Checking", custId);
	}
//	public void displayAccountDetail() {
//		System.out.println("Checking Account ID: " + super.getAccNo() + " || Balance: "  + super.getAccBalance() + " || Overdraft amount: " + this.od + " || Type: " + super.getType());
//		System.out.println("---------------------------");
//	}
}
