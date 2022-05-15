package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class NewFlori implements Initializable {
    @FXML
    private TextField DenIn;

    @FXML
    private TextField VarIn;

    @FXML
    private TextField CanIn;

    @FXML
    private TextField TipIn;


    @FXML
    void insertFlori(MouseEvent event) {
        System.out.println("Mere");

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
int z=223;
        try {


            Statement stinsert = con.createStatement();
            stinsert.executeUpdate("INSERT INTO `flori` (`Denumire`, `Varsta`, `Cantitate`, `Tip_vanzare`) VALUES ('"+DenIn.getText()+"','"+VarIn.getText()+"','"+CanIn.getText()+"','"+TipIn.getText()+"');");
            con.close();
            Platform.exit();
        }catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }
    @FXML
    private void inchidereAplicatie(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
