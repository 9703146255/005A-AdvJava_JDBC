package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo2 {
	
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	public static void main(String[] args)
	{
		
		 
		 
		 
		 try( Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD))
		 {
			 Statement stmt = connection.createStatement();
			 
			 String sql="select * from book";
			 
			 ResultSet rst = stmt.executeQuery(sql);
			 
			 boolean nxt=rst.next();
			 
			 System.out.println(nxt);
			 
			 boolean nxt1=rst.next();
			 
			 System.out.println(nxt1);
			 
			 boolean nxt2=rst.next();
			 
			 System.out.println(nxt2);
			 
			 
			 boolean nxt3=rst.next();
			 
			 System.out.println(nxt3);
			 
			 boolean nxt4=rst.next();
			 
			 System.out.println(nxt4);
			 
			 
			 
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

}
