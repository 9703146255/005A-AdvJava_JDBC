package No08.in.ashokit.date13102023;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class BookDao 
{
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PASSWORD="123456";
    public void insertData() throws SQLException
    {
    	HikariConfig config=new HikariConfig();
    	config.setAutoCommit(false);              //we can use two ways ==>config.setAutoCommit(false);   or 
    	config.setJdbcUrl(DB_URL);
    	config.setUsername(DB_UNAME);
    	config.setPassword(DB_PASSWORD);
    	
    	config.setMaximumPoolSize(20);
    	config.setMinimumIdle(5);
    	
    	HikariDataSource datasource=new HikariDataSource(config);
    	
    	Connection con=datasource.getConnection();
    	
    	String sqlEmp="insert into emp values(1,'thiru',10000.00)";
    	Statement cstmnt = con.createStatement();
    	int empcount = cstmnt.executeUpdate(sqlEmp);
    	
    	int num=10/0;
    	
    	String sqlAddr="insert into addr values('kurnool','ap','india')";
    	int addcount = cstmnt.executeUpdate(sqlAddr);
    
    	
    	
    	System.out.println("emp records are effected  :"+empcount);
    	System.out.println("addr records are effected :"+addcount);
    	
    	
    	
    }
}
