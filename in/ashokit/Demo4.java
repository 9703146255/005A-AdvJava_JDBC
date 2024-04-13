package in.ashokit;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
======================================== 
 book_id 	book_name		book_price
=======================================
1001		springboot			1000.50
1002		AWS					2000.00
1002		AWS					2000.00
1003		PYTHON				2000.00
========================================
 
 
 */
public class Demo4 {
	
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
			 
			
			 
			 if(rst.next())
			 {
				 System.out.print(rst.getInt(1)+"\t");
				 System.out.print(rst.getString(2)+"\t");
				 System.out.println(rst.getDouble(3)+"\t");
			 }
			 if(rst.next())
			 {
				 System.out.print(rst.getInt(1)+"\t");
				 System.out.print(rst.getString(2)+"\t");
				 System.out.println(rst.getDouble(3)+"\t");
			 }
			 if(rst.next())
			 {
				 System.out.print(rst.getInt(1)+"\t");
				 System.out.print(rst.getString(2)+"\t");
				 System.out.println(rst.getDouble(3)+"\t");
			 }
			 if(rst.next())
			 {
				 System.out.print(rst.getInt(1)+"\t");
				 System.out.print(rst.getString(2)+"\t");
				 System.out.println(rst.getDouble(3)+"\t");
			 }
			 
			 //false
			 if(rst.next())
			 {
				 System.out.print(rst.getInt(1)+"\t");
				 System.out.print(rst.getString(2)+"\t");
				 System.out.println(rst.getDouble(3)+"\t");
			 }
			 
			 
			 
			 
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

}
