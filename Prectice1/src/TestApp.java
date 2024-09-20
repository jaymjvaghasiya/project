import java.sql.*;

class PrintGujaratiData {

    public void GetData() {
    	
    	
        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection (with UTF-8 encoding enabled)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testapp?useUnicode=true&characterEncoding=UTF-8", "root", "");

            // 3. Create a statement
            Statement stmt = con.createStatement();

            // 4. Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            // 5. Process the result set
            while (rs.next()) {
                String gujaratiData = rs.getString("gujaratiName"); // Replace with your column name
                System.out.println(gujaratiData); // Should correctly print Gujarati text
            }

            // 6. Close the resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class TestApp {
    public static void main(String[] args) {
        PrintGujaratiData pg = new PrintGujaratiData();
        pg.GetData();
    }
}





























