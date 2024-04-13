package No07.in.ashokit.date13102023;

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
    	config.setJdbcUrl(DB_URL);
    	config.setUsername(DB_UNAME);
    	config.setPassword(DB_PASSWORD);
    	
    	config.setMaximumPoolSize(20);
    	config.setMinimumIdle(5);
    	
    	HikariDataSource datasource=new HikariDataSource(config);
    	
    	Connection con=datasource.getConnection();
    	
    	String sql="insert into book values(1,'adv java',100.00)";
    	
    	Statement cstmnt = con.createStatement();
    	
    	int count = cstmnt.executeUpdate(sql);
    	System.out.println("records are effected"+count);
    	
    	
    	
    }
}
