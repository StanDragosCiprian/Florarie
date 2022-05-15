package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Flori.fxml"));
        Scene scene=new Scene(root);

primaryStage.setTitle("Hello World");
primaryStage.setScene(scene);
primaryStage.show();

        };



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, SQLException {
//MySqlConnection
launch(args);

        String MySQLURL = "jdbc:mysql://localhost:3307/florarie?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //MySqlSellect
        try {
            String query = "SELECT * FROM flori";

            // create the java statement
            Statement st = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("Denumire");
                String lastName = rs.getString("Varsta");
                String dateCreated = rs.getString("Cantitate");
                String isAdmin = rs.getString("Tip_vanzare");


                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        //MySqlInsert

    }
    }





