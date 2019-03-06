package bank;

import java.util.concurrent.atomic.AtomicInteger;

//TODO change to interface
public abstract class Account {
	private int accBalance;
	private String type;
	
	public int getCustId() {
		return custId;
	}
	private int custId;
	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}
	public void storeAccountDetail(int accBalance, String type, int custId){
		this.accBalance=accBalance;
		this.type = type;
		this.custId = custId;
	}
	public int getAccBalance() {
		return accBalance;	
	}
	public String getType() {
		return type;
	}
}
