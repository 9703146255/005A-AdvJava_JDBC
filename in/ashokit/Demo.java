package in.ashokit;
/*
 day1
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	private static String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	
			
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName(DB_DRIVER);
		
		Connection con=DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
		
		Statement stmt=con.createStatement();
		
		String sql="insert into book values(1002,'AWS',2000.00)";
		
		int count=stmt.executeUpdate(sql);
		System.out.println("Rows effected :"+count);
		
		con.close();
		   
		
		
	}
	
	

}
