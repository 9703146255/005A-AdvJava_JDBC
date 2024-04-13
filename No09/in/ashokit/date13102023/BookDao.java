package No09.in.ashokit.date13102023;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class BookDao 
{
		public static final String DB_URL = "jdbc:mysql://localhost:3306/ashokitdb";
	    public static final String DB_UNAME = "root";
	    public static final String DB_PASSWORD = "123456";

	    public void insertData()
	    {
	        HikariConfig config = new HikariConfig();
	        config.setJdbcUrl(DB_URL);
	        config.setUsername(DB_UNAME);
	        config.setPassword(DB_PASSWORD);
	        config.setMaximumPoolSize(20);
	        config.setMinimumIdle(5);

	        HikariDataSource dataSource = new HikariDataSource(config);

	        try (Connection con = dataSource.getConnection();)
	        {
	            con.setAutoCommit(false); // Disable auto-commit to control transactions

	            String sqlEmp = "insert into emp values(1,'thiru',10000.00)";
	            String sqlAddr = "insert into addr values('kurnool','ap','india')";
	            
	            try (Statement cstmt = con.createStatement())
	            {
	                int empCount = cstmt.executeUpdate(sqlEmp);

	               // int num = 10 / 0; // This will throw an ArithmeticException

	                int addCount = cstmt.executeUpdate(sqlAddr);

	                System.out.println("emp records are affected: " + empCount);
	                System.out.println("addr records are affected: " + addCount);

	                con.commit(); // Commit the transaction if all queries succeed
	            }
	            catch (SQLException e)
	            {
	                con.rollback(); // Rollback the transaction if an exception occurs
	                e.printStackTrace();
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }
}
