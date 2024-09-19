package No00in.ashokit.date09102023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class No04ReadDataFromFileSaveInDataBase {

	
	public static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	public static final String DB_UNAME="root";
	public static final String DB_PAZZWORD="123456";

	public static void main(String[] args) {
		
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PAZZWORD)) {
            // Read data from the text file
            String filePath = "D:\\ASHOKIT\\AdvanceJava\\csvfile.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Prepare SQL insert statement
            String insertSql = "INSERT INTO product (p_id, p_name, p_price) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int p_id = Integer.parseInt(parts[0].trim());
                    String p_name = parts[1].trim();
                    double p_price = Double.parseDouble(parts[2].trim());

                    // Set values for the prepared statement
                    preparedStatement.setInt(1, p_id);
                    preparedStatement.setString(2, p_name);
                    preparedStatement.setDouble(3, p_price);

                    // Execute the insert statement
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Records inserted successfully.");

            // Close resources
            preparedStatement.close();
            reader.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
/*
 101, Apple, 1.99
102, Orange, 0.99
103, Banana, 0.59
104, Grapes, 2.99
105, Mango, 1.49
106, Pineapple, 3.50
107, Watermelon, 4.00
108, Blueberry, 5.99
109, Strawberry, 3.79
110, Kiwi, 1.89

	*/
