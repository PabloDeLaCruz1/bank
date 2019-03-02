package types;

//abstract class Bank{
//	public abstract void calculateInterest();
//	public abstract void calculateCompoundInterest();
//
//}
interface Bank{ //contract based implementation, frameworks are going to be full of interfaces. 
	int a = 10;
	void calculateInterest(); //dont need to write public or abstract, its implied
	void calculateCompoundInterest();

}
interface Bank1{
	void calculateInterest();
	void calculateCompoundInterest();

}
//public class BankClass extends Bank { // Can't extend interface because there is nothing to inheritance.
public class BankClass implements Bank, Bank1 { 
	@Override
	public void calculateInterest() {
		System.out.println("My way of interest calculation");
	}
	@Override //this is used just for documentation.
	public void calculateCompoundInterest() {
		System.out.println("My banks way of compound interest");
	}
//	public void sellGrocery() { cant use public method because its not part of the contract with the interface
//		
//	}
	
	private void sellGrocery() { //you can still create private methods since they will be used in other methods that are part of the interface
		
	}
	public void services() {
		//super.calculateInterest(); //"super to use parents method"
		calculateInterest(); //super will only work on implemented methods, so cant call on abstract classes.

	}
	public static void main(String[] s) {
		new BankClass().services();
	}

}

class Check{
	void fun() {
		Bank obj = new BankClass(); //the interface object Bank is used to POINT to BankClass. We always point to the child since they have the implementation. 
	}
}