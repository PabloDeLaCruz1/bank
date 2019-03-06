package bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Transaction {
	 private static AtomicInteger count = new AtomicInteger(0); 
	int transId;
	double transAmount;
	int accId;
	String transType;
	
	public void storeTransactionDetails(double transAmount, int accId, String transType) {
		this.transId = count.incrementAndGet();
		this.transAmount = transAmount;
		this.accId = accId;
		this.transType = transType;
	}
	public void displayTransactionDetails() {
		System.out.println("Id: " + transId + " Amount " + transAmount + " AccoundId: " + accId + " Type: " + transType);
	}
}
