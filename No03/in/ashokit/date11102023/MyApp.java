package No03.in.ashokit.date11102023;

import java.sql.SQLException;

public class MyApp
{
	public static void main(String[] args) throws SQLException
 	{
	 BookDao dao=new BookDao();
	 dao.getBookNameByPrice("PYTHON", 2000.00);
	 
	
 	}
}
