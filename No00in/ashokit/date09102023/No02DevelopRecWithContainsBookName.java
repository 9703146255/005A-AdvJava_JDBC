package No00in.ashokit.date09102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*

DEVELOP JDBC PROGRAM TO RETRIEVE BOOK WHICH CONTAINS 'JAVA' IN BOOK NAME




 */

public class No02DevelopRecWithContainsBookName {


	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PAZZWORD="123456";

	public static void main(String[] args) throws SQLException {


		String sql="select * from book where book_name like ?";


		Scanner sc=new Scanner(System.in);
		System.out.println("enter the book name :");
		String book_name=sc.next();
		sc.close();

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);

		PreparedStatement prst = con.prepareStatement(sql);

		prst.setString(1, "%"+book_name+"%");


		ResultSet rst = prst.executeQuery();

		
		if(rst.next())
		{

			while(rst.next())
			{
				System.out.print(rst.getInt(1)+"\t");
				System.out.print(rst.getString(2)+"\t");
				System.out.println(rst.getDouble(3));
			}
		}
		else
		{
			System.out.println("records are not available");
		}


		con.close();






	}

}
