package No01.in.ashokit.date10102023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyApp {

	public static void main(String[] args) throws IOException {

		
		 String filePath = "D:\\ASHOKIT\\AdvanceJava\\product.txt";
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            ProductDao productDAO = new ProductDao();

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    int p_id = Integer.parseInt(parts[0].trim());
	                    String p_name = parts[1].trim();
	                    double p_price = Double.parseDouble(parts[2].trim());

	                    productDAO.insertProduct(p_id, p_name, p_price);
	                }
	            }

	            System.out.println("Records inserted successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			 
	 }
}


