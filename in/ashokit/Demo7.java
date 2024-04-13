package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 
 ==>if()     	==>id should be unique ==>so that we can get one record==>than we can use if()
 ==>while()		==>we dont know in data base how nay records is there than we can go for while()
 
 */

public class Demo7
{
	
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	public static void main(String[] args) throws Exception {
		
		
	
	
	try(Connection	con=DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);) {
		

		Statement createStatement = con.createStatement();
		
		String sql="select * from book where book_id=1002";
		
		ResultSet eqr = createStatement.executeQuery(sql);
		
		if(eqr.next())
		{
			System.out.println(eqr.getInt(1));
			System.out.println(eqr.getString(2));
			System.out.println(eqr.getDouble(3));
		}
	
	} catch (Exception e) {
         e.printStackTrace();
	}
	
	
	
	
	
	
}
}
