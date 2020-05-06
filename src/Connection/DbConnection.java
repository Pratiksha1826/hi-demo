package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	

	public static Connection getConnection()
	{
		 Connection con = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydata", "root", "");
			System.out.println("connection created");

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
