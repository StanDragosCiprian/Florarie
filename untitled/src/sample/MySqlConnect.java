package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnect {
    public static Connection getConnection(){
        String MySQLURL = "jdbc:mysql://localhost:3307/florarie?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                return con;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return con;
    }
}
