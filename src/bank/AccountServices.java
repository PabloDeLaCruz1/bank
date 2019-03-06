package bank;

public class AccountServices {

	public double getBalance(Account currentAccount)
	{
		return currentAccount.getAccBalance();
	}
	public void fundTransfer(Account currentAcc,
						Account accountTo, int amountToTransfer)
	{
		cashWithdraw(amountToTransfer, currentAcc);
		cashDeposit(accountTo, amountToTransfer);
		
	}
	public void cashWithdraw(int amountToWithdraw, Account currentAcc)
	{
		if(amountToWithdraw < 20 || amountToWithdraw%20 !=0 )
		{
			System.out.println("Withdraw must me minimum 20 and it must in form 20s");
		}
		else
		{
			if(amountToWithdraw > currentAcc.getAccBalance())
			{
				System.out.println("Invalid withdraw amount ... Your current balance is : " 
							+ currentAcc.getAccBalance());
			}
			else
			{
				currentAcc.setAccBalance(
						currentAcc.getAccBalance() - amountToWithdraw);
			}
		}
	}
	public void cashDeposit(Account currentAcc, int amountToDeposit)
	{
		currentAcc.setAccBalance(
						currentAcc.getAccBalance() + amountToDeposit);
	}

}