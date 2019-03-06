//package jdbc;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class MyEmployeeJDBC {
//
//	static Connection con;
//	private static Connection getSQLConnection() throws SQLException
//	{
//		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
//		return con;
//	}
//
//	
//	public void createSampleTable()
//	{
//		try 
//		{
//			PreparedStatement stat = MyEmployeeJDBC.getSQLConnection().prepareStatement("create table pro(pid numeric,pname varchar(10),pprice numeric)");
//			stat.execute();
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}
//	}
//	
//	
//	
//	
//	public void deleteEmployee(int eid)
//	{
//		try 
//		{
//			//connection with oracle
//			PreparedStatement stat = MyEmployeeJDBC.getSQLConnection().prepareStatement("delete from employee where empid=?");
//			
//			stat.setInt(1, eid);
//			stat.executeUpdate();
//			
//			System.out.println("done...new record delete...");
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}		
//		
//	}
//	public void updateEmployee(int eid,int updatedSalary)
//	{
//		try 
//		{
//			//connection with oracle
//			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
//			PreparedStatement stat = MyEmployeeJDBC.getSQLConnection().prepareStatement("update employee set empsalary=? where empid=?");
//			
//			stat.setInt(1, updatedSalary);
//			stat.setInt(2, eid);
//			stat.executeUpdate();
//			
//			System.out.println("done...new record updated......");
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}		
//		
//	}
//	public void insertNewEmployee(int eid,String ename,String ecity,String ephone,int esalary,int dep)
//	{
//		try 
//		{
//			//connection with oracle
//			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
//			
//			PreparedStatement stat = MyEmployeeJDBC.getSQLConnection().prepareStatement("Insert into Employee values(?,?,?,?,?,?)");
//			
//			stat.setInt(1, eid);
//			stat.setString(2, ename);
//			stat.setString(3, ecity);
//			stat.setString(4, ephone);
//			stat.setInt(5, esalary);
//			stat.setInt(6, dep);
//
//			int ret = stat.executeUpdate();
//			
//			if(ret>0)
//			{				
//				System.out.println("done...new record inserted...success");
//			}
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}		
//	}
//	public void getAllEmployees()
//	{
//		try 
//		{
//			//connection with oracle
//			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","syntel123$");
//			Statement stat = MyEmployeeJDBC.getSQLConnection().createStatement();
//			ResultSet result = stat.executeQuery("Select * from Employee");
//			
//			
//			ResultSetMetaData rsmd = result.getMetaData();
//			
//			
//			for(int cnt=0;cnt < rsmd.getColumnCount(); cnt++)
//				System.out.print(rsmd.getColumnName(cnt+1) + "    ");
//			
//			System.out.println("\n------------------------------------------------");
//			while(result.next())
//			{
//				System.out.println(result.getString(1) + "  " + 
//								result.getString(2) + "  " + 
//									result.getString(3) + "  " + 
//								result.getString(4) + "   " + 
//									result.getString(5) + "  " +
//								result.getString(6)); 
//			}
//			
//			System.out.println("done......");
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e);
//		}
//	}
//	public static void main(String s[])
//	{
//		MyEmployeeJDBC obj = new MyEmployeeJDBC();
//		
//		/*Scanner sc = new Scanner(System.in);
//		int eid = sc.nextInt();
//		String ename = sc.next();
//		String ecity = sc.next();
//		String ephone = sc.next();
//		int esalary = sc.nextInt();
//		int dep = sc.nextInt();
//		
//		
//		obj.insertNewEmployee(eid, ename, ecity, ephone, esalary, dep);
//	*/
//		
//		
//		//obj.deleteEmployee(777);
//		//obj.updateEmployee(1, 90909090);
//
//		//obj.getAllEmployees();
//		obj.createSampleTable();
//	}
//}
//
//
//
