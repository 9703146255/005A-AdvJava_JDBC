package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/*
 when we are given chance to user to enter the data ==> uname & password ex: thiru --    --  ==> commenting in mysql remaining part not execute
 user will enter the unwanted sql queries these is called sql injection
 

 */
public class Demo9 {
	
	
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the user name :");
		String uname=sc.next();
		System.out.println("enter the password :");
		String password=sc.next();
		
		Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
		
		Statement createStatement = connection.createStatement();
		
		String sql = "SELECT * FROM sbiacc WHERE uname = '" + uname + "' AND password = '" + password + "'";
		//
		
		ResultSet executeQuery = createStatement.executeQuery(sql);
		
		while(executeQuery.next())
		{
			System.out.println(executeQuery.getString(1));
			System.out.println(executeQuery.getInt(2));
			System.out.println(executeQuery.getInt(3));
			System.out.println(executeQuery.getString(4));
			System.out.println(executeQuery.getDouble(5));
			
		}
		
		
		
		
		
	}

}
