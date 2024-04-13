package No01.in.ashokit.date10102023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
	
	
	 	public static final String DB_URL = "jdbc:mysql://localhost:3306/ashokitdb";
	    public static final String DB_UNAME = "root";
	    public static final String DB_PASSWORD = "123456";

	    public  void insertProduct(int p_id, String p_name, double p_price) {
	        try (Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWORD)) {
	            String insertSql = "INSERT INTO product1 (p_id, p_name, p_price) VALUES (?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

	            preparedStatement.setInt(1, p_id);
	            preparedStatement.setString(2, p_name);
	            preparedStatement.setDouble(3, p_price);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
