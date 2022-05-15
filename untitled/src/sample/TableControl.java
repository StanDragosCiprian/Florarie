package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableControl implements Initializable {
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,String> Denumire;
    @FXML
    private TableColumn<ModelTable,String> Varsta;
    @FXML
    private TableColumn<ModelTable,String> Cantitate;
    @FXML
    private TableColumn<ModelTable,String> Tip_vanzare;

    @FXML
    private TableColumn<ModelTable,String> Action;
    ObservableList<ModelTable> oblist= FXCollections.observableArrayList();
    private Parent root;
//den,var,can,tip,ac;
    @FXML
    public void  includeFlori(ActionEvent event) throws IOException {
        try{
        FXMLLoader fxmlLoader=new FXMLLoader (getClass ().getResource("FloriNoi.fxml"));
        Parent rootl=(Parent) fxmlLoader.load();
        Stage stage=new Stage ();

        stage.setTitle("Second window");
        stage.setScene(new Scene(rootl));
        stage.show();
    }catch (Exception e){
        System.out.println("Cant load new window");
    }
    }
    @FXML
    public void inchidereAplicatie(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void upDataRow(MouseEvent event) throws IOException {
        File file=new File("C:\\Users\\Retro\\IdeaProjects\\untitled\\src\\sample\\idsave.txt");
        FileWriter fw=new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
        pw.println(table.getSelectionModel().getFocusedIndex()+1);

        pw.close();
        try{
            FXMLLoader fxmlLoader=new FXMLLoader (getClass ().getResource("FloriUpdate.fxml"));
            Parent rootl=(Parent) fxmlLoader.load();
            Stage stage=new Stage ();

            stage.setTitle("Second window");
            stage.setScene(new Scene(rootl));
            stage.show();
        }catch (Exception e){
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void Dell(MouseEvent event) throws IOException {
        File file=new File("C:\\Users\\Retro\\IdeaProjects\\untitled\\src\\sample\\idsave.txt");
        FileWriter fw=new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
        pw.println(table.getSelectionModel().getFocusedIndex()+1);

        pw.close();
        try{
            FXMLLoader fxmlLoader=new FXMLLoader (getClass ().getResource("Delete.fxml"));
            Parent rootl=(Parent) fxmlLoader.load();
            Stage stage=new Stage ();

            stage.setTitle("Second window");
            stage.setScene(new Scene(rootl));
            stage.show();
        }catch (Exception e){
            System.out.println("Cant load new window");
        }
    }
        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Connection con=MySqlConnect.getConnection();
            ResultSet rs=con.createStatement ().executeQuery("select * from flori");
            while (rs.next ()){

                oblist.add(new ModelTable(rs.getString("Denumire"),rs.getString("Varsta"),rs.getString("Cantitate"),rs.getString("Tip_vanzare")));
            }
            }catch (SQLException ex){
                Logger.getLogger(TableControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        Denumire.setCellValueFactory(new PropertyValueFactory<>("den"));
        Varsta.setCellValueFactory(new PropertyValueFactory<>("var"));
        Cantitate.setCellValueFactory(new PropertyValueFactory<>("can"));
        Tip_vanzare.setCellValueFactory(new PropertyValueFactory<>("tip"));
        table.setItems(oblist);



    }
    }
