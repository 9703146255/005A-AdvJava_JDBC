package No06.in.ashokit.date12102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDao {

	private static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static final String DB_UNAME="root";
	private static final String DB_PAZZWORD="123456";
	
	public void executeBatch() throws Exception
	{
		        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);

		        String insertQuery = "INSERT INTO book (bookID, bookName, price) VALUES (?, ?, ?)";
		        PreparedStatement pstmt = con.prepareStatement(insertQuery);

		        pstmt.setInt(1, 1001);
		        pstmt.setString(2, "The Great Gatsby");
		        pstmt.setDouble(3, 12.99);
		        pstmt.addBatch();

		        pstmt.setInt(1, 1002);
		        pstmt.setString(2, "To Kill a Mockingbird");
		        pstmt.setDouble(3, 10.50);
		        pstmt.addBatch();

		        pstmt.setInt(1, 1003);
		        pstmt.setString(2, "Harry Potter");
		        pstmt.setDouble(3, 17.95);
		        pstmt.addBatch();

		        pstmt.setInt(1, 1004);
		        pstmt.setString(2, "The Hobbit");
		        pstmt.setDouble(3, 9.99);
		        pstmt.addBatch();

		        int[] count = pstmt.executeBatch();

		        System.out.println("Number of rows affected: " + count.length);
		    }
	}


