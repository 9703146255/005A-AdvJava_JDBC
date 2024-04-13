package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo8 {


	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book id :");
		int book_id=sc.nextInt();
		
		
	Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
		
	Statement createStatement = connection.createStatement();
	
	String sql="select * from book where book_id = "+book_id;
	
	   
	ResultSet executeQuery = createStatement.executeQuery(sql);
	
/*
 * getInt(book_id));  		==>    getInt(int index) or getInt(String columnname)
 * getString(book_name)); 	 ==>   getString(int index) or getString(String columnname)
 *getDouble(book_name)); 	 ==>   getString(int index) or getString(String columnname)
 *getDouble(book_name)); 	 ==>   getDouble(int index) or getDouble(String columnname)
 */
	while(executeQuery.next())
	{
		System.out.println(executeQuery.getInt(1));
		System.out.println(executeQuery.getString(2));
		System.out.println(executeQuery.getDouble(3));
	}
	
	
	}
}
