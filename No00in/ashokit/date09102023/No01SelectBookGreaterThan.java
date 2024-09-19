package No00in.ashokit.date09102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
	DEVELOP JDBC PROGRAM TO RETRIEVE BOOKS WHICH ARE HAVING PRICE GREATER THAN GIVEN PRICE
 */




public class No01SelectBookGreaterThan {
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PAZZWORD="123456";
	public static void main(String[] args) throws SQLException {
		
		
		String sql="select * from book where book_price > ?";
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the price of the book :");
		Double book_price=sc.nextDouble();
	    sc.close();
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);
		
		PreparedStatement prst = con.prepareStatement(sql);
		
		prst.setDouble(1,book_price);
		
		
		ResultSet rst = prst.executeQuery();
		
		
		while(rst.next())
		{
			System.out.print(rst.getInt(1)+"\t");
			System.out.print(rst.getString(2)+"\t");
			System.out.println(rst.getDouble(3));
		}
		
		
		con.close();
		
		
		
	}
	/*
 101, Apple, 1.99
102, Orange, 0.99
103, Banana, 0.59
104, Grapes, 2.99
105, Mango, 1.49
106, Pineapple, 3.50
107, Watermelon, 4.00
108, Blueberry, 5.99
109, Strawberry, 3.79
110, Kiwi, 1.89

	*/

}
