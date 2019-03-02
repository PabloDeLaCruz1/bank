package bank;

public class CashWithdrawalException extends Exception {
	public String getErrorMesssage() {
		return "Cannot withdrawal that amount...";
	}
}
