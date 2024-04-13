package No03.in.ashokit.date11102023;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class BookDao 
{
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/ashokitdb";
    public static final String DB_UNAME = "root";
    public static final String DB_PASSWORD = "123456";
	public void getBookNameByPrice(String book_name,double book_price) throws SQLException
	{
			
		  String sql="call getBookData(?,?)";
	      Connection conn= DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
	      
	      CallableStatement cst = conn.prepareCall(sql);
	      
	      cst.setDouble(1, book_price);
	      cst.registerOutParameter(2, Types.VARCHAR);
	      
	      ResultSet rst = cst.executeQuery();
	      
	      while(rst.next())
	      {
	    	  System.out.print(rst.getString(2) +"\t");
	    	  System.out.println(rst.getDouble(3));
	      }
	 
	}
}
