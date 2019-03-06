package bank;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DataBase {

	private static Connection getSQLConnection() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","final2kk");
		return con;
	}
	public void createTablesForBank(){
		try {
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("CREATE TABLE customer(cust_id INT PRIMARY KEY AUTO_INCREMENT, cust_name VARCHAR(10), cust_city VARCHAR(10), cust_phone VARCHAR(10) )");
			PreparedStatement stat1 = DataBase.getSQLConnection().prepareStatement("CREATE TABLE account(acc_id INT PRIMARY KEY AUTO_INCREMENT, balance INT, accType VARCHAR(10), cust_id INT, FOREIGN KEY (cust_id) REFERENCES customer(cust_id))");
			PreparedStatement stat2 = DataBase.getSQLConnection().prepareStatement("CREATE TABLE transaction(trans_id INT PRIMARY KEY AUTO_INCREMENT, trans_amount INT, acc_id INT, FOREIGN KEY (acc_id) REFERENCES account(acc_id), trans_type VARCHAR(10), trans_date DATE)");
//			stat.execute();
//			stat1.execute();
			stat2.execute();

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deleteCustomer(int custId){
		try {
			//connection with oracle
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("delete from customer where cust_id=?");
			
			stat.setInt(1, custId);
			stat.executeUpdate();
			
			System.out.println("done...new record delete...");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}		
		
	}
	public void updateCustomer(int eid,int updatedSalary){
		try{
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("update employee set empsalary=? where empid=?");
			
			stat.setInt(1, updatedSalary);
			stat.setInt(2, eid);
			stat.executeUpdate();
			
			System.out.println("done...new record updated......");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}		
		
	}
	public void updateAccount(int custId, int balance){
		try{
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("update account set balance=? where cust_id=?");
			
			stat.setInt(1, balance);
			stat.setInt(2, custId);
			stat.executeUpdate();
			
			System.out.println("account updated...");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}		
		
	}
	public void insertCustomer(String custName, String custCity, String custPhone){
		try {
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("Insert into customer values(?,?,?,?)");
			stat.setInt(1, 0);
			stat.setString(2, custName);
			stat.setString(3, custCity);
			stat.setString(4, custPhone);

			int ret = stat.executeUpdate();
			
			if(ret>0){				
				System.out.println("done...new customer inserted...success");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
	}
	public void insertAccount(Integer balance, String accType, Integer custId){
		try {
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("Insert into account values(?,?,?,?)");
			stat.setInt(1, 0);
			stat.setInt(2, balance);
			stat.setString(3, accType);
			stat.setInt(4, custId);

			int ret = stat.executeUpdate();
			
			if(ret>0){				
				System.out.println("done...new account inserted...success");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
	}
	public void insertTransaction(Integer transAmount, Integer accId, String transType, String transDate){
		try {
			PreparedStatement stat = DataBase.getSQLConnection().prepareStatement("Insert into transaction values(?,?,?,?,?)");
			stat.setInt(1, 0);
			stat.setInt(2, transAmount);
			stat.setInt(3, accId);
			stat.setString(4, transType);
			stat.setString(5, transDate);

			int ret = stat.executeUpdate();
			
			if(ret>0){				
				System.out.println("done...new transaction inserted...success");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
	}
	public void showAllCustomers(){
		try {
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			Statement stat = DataBase.getSQLConnection().createStatement();
			ResultSet result = stat.executeQuery("Select * from Customer");
			
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int cnt=0;cnt < rsmd.getColumnCount(); cnt++)
				System.out.print(rsmd.getColumnName(cnt+1) + "    ");
			
			System.out.println("\n------------------------------------------------");
			while(result.next())
			{
				System.out.println("[" + result.getString(1) + "]          " + 
								result.getString(2) + "       " + 
									result.getString(3) + "     " + 
								result.getString(4)); 
			}
			System.out.println("Showing all Customers from DataBase");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void showAllCustomerAccounts(int custId){
		try {
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			Statement stat = DataBase.getSQLConnection().createStatement();
			ResultSet result = stat.executeQuery("Select * from Account where cust_id=" + custId);
			
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int cnt=0;cnt < rsmd.getColumnCount(); cnt++)
				System.out.print(rsmd.getColumnName(cnt+1) + "    ");
			
			System.out.println("\n------------------------------------------------");
			while(result.next())
			{
				System.out.println("--" + result.getString(1) + "          " + 
								result.getString(2) + "       " + 
									result.getString(3) + "     " + 
								result.getString(4)); 
			}
			System.out.println("Showing all Customer Accounts from DataBase");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public Customer getCustomer(int custId){
		try {
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			Statement stat = DataBase.getSQLConnection().createStatement();
			ResultSet result = stat.executeQuery("Select * from Customer where cust_id=" +custId);
			
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int cnt=0;cnt < rsmd.getColumnCount(); cnt++)
				System.out.print(rsmd.getColumnName(cnt+1) + "    ");
			
			System.out.println("\n------------------------------------------------");
			while(result.next())
			{
				System.out.println("--" + result.getString(1) + "          " + 
								result.getString(2) + "       " + 
									result.getString(3) + "     " + 
								result.getString(4)); 
				Customer newCustomer = new Customer();
				newCustomer.storeCustomerDetail(result.getString(2), result.getString(3), result.getString(4));
				
				return newCustomer;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public Account getAccount(int accId){
		try {
			//connection with oracle
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
			Statement stat = DataBase.getSQLConnection().createStatement();
			ResultSet result = stat.executeQuery("Select * from Account where acc_id=" + accId);
			
			ResultSetMetaData rsmd = result.getMetaData();
			
			for(int cnt=0;cnt < rsmd.getColumnCount(); cnt++)
				System.out.print(rsmd.getColumnName(cnt+1) + "    ");
			
			System.out.println("\n------------------------------------------------");
			while(result.next())
			{
				System.out.println("--" + result.getString(1) + "          " + 
								result.getString(2) + "       " + 
									result.getString(3) + "     " + 
								result.getString(4)); 
				
				int balance = Integer.parseInt(result.getString(2));
				int custId = Integer.parseInt(result.getString(4));
				
				if (result.getString(3).equals("Savings")) {
					SavingAccount newAccount = new SavingAccount();
					newAccount.storeAccountDetail(balance, result.getString(3), custId);
					return newAccount;
				}else if (result.getString(3).equals("Checking")) {
					CheckingAccount newAccount = new CheckingAccount();
					newAccount.storeAccountDetail(balance, result.getString(3), custId);
					return newAccount;
				}
				return null;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static void main(String s[])
	{
		DataBase db = new DataBase();
		
		/*Scanner sc = new Scanner(System.in);
		int eid = sc.nextInt();
		String ename = sc.next();
		String ecity = sc.next();
		String ephone = sc.next();
		int esalary = sc.nextInt();
		int dep = sc.nextInt();
		*/
		
//		db.insertCustomer("Pablo", "Pateson", "8623242951");
//		db.insertAccount(20000, "Savings", 5);
		
		
//		db.deleteCustomer(1);
		//obj.updateEmployee(1, 90909090);
//		db.getAllCustomers();
//		db.getCustomer(3);
		db.updateAccount(5, 49800 - 500);
//		db.getAllCustomers();
//		db.createTablesForBank();
//		Customer newCustomer = db.getCustomer(3);
//	 System.out.println(newCustomer.getCustName());
		
//		db.showAllCustomerAccounts(3);
	}
}



