package No04.in.ashokit.date12102023;

import java.sql.SQLException;

/*
 Write a procedure to get product name,product price by using product id
 */

public class MyApp {

	public static void main(String[] args) throws SQLException {
		
		ProductDao pdo=new ProductDao();
		pdo.getByNamePriceById(100);

	}

}
