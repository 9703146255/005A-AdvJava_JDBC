package No05.in.ashokit.date12102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 addBatch() used for to add the queries to batch object
 executeBatch(); it is used to add batch object to db
 */
public class ProductDao {
	
	
	private static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static final String DB_UNAME="root";
	private static final String DB_PAZZWORD="123456";
	
	public void executeBatch() throws Exception
	{
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);
		
		
		Statement stmt = con.createStatement();
		
		stmt.addBatch("insert into book values(1001, 'The Great Gatsby', 12.99)");
		stmt.addBatch("insert into book values(1002, 'To Kill a Mockingbird', 10.50)");
		stmt.addBatch("insert into book values(1003, 'Harry Potter', 17.95)");
		stmt.addBatch("insert into book values(1004, 'The Hobbit', 9.99)");
		
		int[] count = stmt.executeBatch();
		
		System.out.println("number of rows effected : "+count.length);
		
		
		
	}

}
