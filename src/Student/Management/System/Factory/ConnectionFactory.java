package Student.Management.System.Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static Connection con=null;
	static
	{
	try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=Mysql");
		} 
	catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void close() 
	{
		try 
		{
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

}
