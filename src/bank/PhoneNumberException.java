package bank;

public class PhoneNumberException extends Exception{
	public String getErrorMesssage() {
		return "Phone number must be 10 digits and contain no characters";
	}
}
