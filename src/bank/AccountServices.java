package bank;

public class AccountServices {

	public double getBalance(Customer objCustomer)
	{
//		Account account = objCustomer.getAccount();
		return objCustomer.getAccount().getAccBalance();
	}
	public void fundTransfer(Customer objCustomerFrom,
						Customer objCustomerTo,int amountToTransfer)
	{
		cashWithdraw(objCustomerFrom, amountToTransfer);
		cashDeposit(objCustomerTo,amountToTransfer);
		
	}
	public void cashWithdraw(Customer objCustomer,int amountToWithdraw)
	{
		if(amountToWithdraw < 20 || amountToWithdraw%20 !=0 )
		{
			System.out.println("Withdraw must me minimum 20 and it must in form 20s");
		}
		else
		{
			if(amountToWithdraw > objCustomer.getAccount().getAccBalance())
			{
				System.out.println("Invalid withdraw amount ... Your current balance is : " 
							+ getBalance(objCustomer));
			}
			else
			{
				objCustomer.getAccount().setAccBalance(
						objCustomer.getAccount().getAccBalance() - amountToWithdraw);
			}
		}
	}
	public void cashDeposit(Customer objCustomer,int amountToDeposit)
	{
		objCustomer.getAccount().setAccBalance(
						objCustomer.getAccount().getAccBalance() + amountToDeposit);
	}

}