package bank;

public class NullAccountException extends Exception {
	public String getErrorMessage() {
		return "Please enter a correct account number";
	}	
}
