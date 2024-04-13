package No02.in.ashokit.date11102023;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
 by using procedures
 */
public class BookDao 
{
	public static final String DB_URL = "jdbc:mysql://localhost:3306/ashokitdb";
    public static final String DB_UNAME = "root";
    public static final String DB_PASSWORD = "123456";
	
  public void getBooksData() throws SQLException
  {
	  
	  		String sql="call getBookData()";
	      Connection conn= DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
	      
	      CallableStatement cst = conn.prepareCall(sql);
	      
	      ResultSet rst = cst.executeQuery();
	      
	      while(rst.next())
	      {
	    	  System.out.print(rst.getInt(1) +"\t");
	    	  System.out.print(rst.getString(2) +"\t");
	    	  System.out.println(rst.getDouble(3));
	      }
	      
	      conn.close();
  }
  
  public void getBooksDataById(int book_id) throws SQLException
  {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter book_id :");
	  int bookId = sc.nextInt();
	  
	  String sql="call getBooksDataById( ? )";
      Connection conn= DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD);
      
      CallableStatement cst = conn.prepareCall(sql);
      
      cst.setInt(1, book_id);
      
      ResultSet rst = cst.executeQuery();
      
      while(rst.next())
      {
    	  System.out.print(rst.getInt(1) +"\t");
    	  System.out.print(rst.getString(2) +"\t");
    	  System.out.println(rst.getDouble(3));
      }
      
      conn.close();
  }
  

  
  
  
}
