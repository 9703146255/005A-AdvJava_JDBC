package No00in.ashokit.date09102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 DEVELOP JDBC PROGRAM TO READ 2 BOOKS ID'S FROM USER AND RETRIEVE THE RECORDS
 ============================================================================
 */
public class No03Read2BooksIdsFromUser {
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PAZZWORD="123456";

	

	public static void main(String[] args) throws SQLException {
		
		String sql="select * from book where book_id in (?, ?)";
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the book_id1 :");
		int book_id1=sc.nextInt();
		
		System.out.println("enter the book_id2 :");
		int book_id2=sc.nextInt();
		
		
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);
		PreparedStatement prst = con.prepareStatement(sql);
		
		prst.setInt(1, book_id1);
		prst.setInt(2, book_id2);
		
		ResultSet rst = prst.executeQuery();
		
		
				while(rst.next())
				{
					System.out.print(rst.getInt(1)+"\t");
					System.out.print(rst.getString(2)+"\t");
					System.out.println(rst.getDouble(3));
				}
		
		
		
		

	}

}
