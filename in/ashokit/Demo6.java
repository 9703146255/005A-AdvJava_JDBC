package in.ashokit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo6 {
	
	private static String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static String DB_UNAME="root";
	private static String DB_PASSWORD="123456";
	public static void main(String[] args) throws SQLException {
		
		

		try(Connection conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);) {
			Statement createStatement = conn.createStatement();
			
			String sql="select * from book";
			
			ResultSet rst = createStatement.executeQuery(sql);
			
			while(rst.next())
			{

				System.out.println(rst.getInt(1)+" :  "+rst.getString(2)+"  :  "+rst.getDouble(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
