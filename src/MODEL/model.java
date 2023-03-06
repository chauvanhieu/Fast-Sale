package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;

public class model {

    public model() {
    }

    public static Connection getConnection() {
        java.sql.Connection conn = null;
        try {
            String databaseName = "fastsale";
            String DB_URL = "jdbc:mysql://localhost:3306/" + databaseName;
            String USER_NAME = "root";
            String PASSWORD = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    


}
