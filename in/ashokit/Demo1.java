package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 
{
	
	private static String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	
			public static void main(String[] args) 
		{
		    // Use try-with-resources for Connection and Statement
		    try (Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD)) 
		    {
		    	 Statement stmt = con.createStatement();
		        String sql = "insert into book values(1003,'PYTHON',2000.00)";

		        int count = stmt.executeUpdate(sql);
		        System.out.println("Rows affected: " + count);
		    } catch (SQLException e) {
		        e.printStackTrace(); // Handle any exceptions that may occur during database operations
		    }
		}

		
		
		
}
	

