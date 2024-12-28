package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection con;

    public static  Connection getConnection(){
        try {
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagmentsystem","root","12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void closeConnection(){
        try {
            con.close();
            System.out.println("Connection closed successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
