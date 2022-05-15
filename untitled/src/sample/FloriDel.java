package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FloriDel implements Initializable {

    @FXML
    private TextField idDell;

    @FXML
    private TextField DenDell;

    @FXML
    private TextField VarDell;

    @FXML
    private TextField CanDell;

    @FXML
    private TextField TipDell;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file=new File("C:\\Users\\Retro\\IdeaProjects\\untitled\\src\\sample\\idsave.txt");
        Scanner sca= null;
        try {
            sca = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String idstring=sca.nextLine();
        int idint=Integer.parseInt(idstring);
        System.out.println(idint);
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
        try {
            String query = "SELECT * from flori WHERE  id="+idint+"";

            // create the java statement
            Statement st = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String Den = rs.getString("Denumire");
                String Var = rs.getString("Varsta");
                String Can = rs.getString("Cantitate");
                String Tip = rs.getString("Tip_vanzare");
                DenDell.setText(Den);
                VarDell.setText(Var);
                CanDell.setText(Can);
                TipDell.setText(Tip);
                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", id, Den, Var,Can,Tip);
            }

            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
