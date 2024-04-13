package No06.in.ashokit.date12102023;

import No05.in.ashokit.date12102023.ProductDao;

public class MyApp {
	

	public static void main(String[] args) throws Exception 
	{
		ProductDao pdo=new ProductDao();
		pdo.executeBatch();
	}

}
