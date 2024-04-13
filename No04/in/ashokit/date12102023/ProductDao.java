package No04.in.ashokit.date12102023;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ProductDao {
	
	private static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static final String DB_UNAME="root";
	private static final String DB_PAZZWORD="123456";
	
	public void getByNamePriceById(int pid) throws SQLException
	{
		
			String sql="call getByNamePriceById(?,?,?)";
		
		     Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD);
		
		     CallableStatement clstmt = con.prepareCall(sql);
		     
		     clstmt.setInt(1, pid);
		     clstmt.registerOutParameter(2, Types.VARCHAR);
		     clstmt.registerOutParameter(3, Types.DOUBLE);
		     
		     ResultSet rst = clstmt.executeQuery();
		     
		     while(rst.next())
		     {
		    	 System.out.print(rst.getString(1) +"\t");
		    	 System.out.println(rst.getDouble(2));
		     }
		
		
		     con.close();
		
		
		
	}
	

}
