package controller.staff;

import controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Databases.OrderDB;
import model.Databases.ProductDB;
import model.Databases.UserDB;
import model.Users.Customer;
import model.Users.Staff;
import model.Users.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class dashboard implements Initializable {
    @FXML
    public AnchorPane dashHead;
    @FXML
    private Label name;
    @FXML
    private Label orderLb;

    @FXML
    private Label productLb;

    @FXML
    private Label staffLb;

    @FXML
    private Label userLb;

    public String holder;

    Stage dialogStage = new Stage();
    Scene scene;


    public void handleStorageButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleLogoutButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/Login.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrderDB orderDB = new OrderDB();
        UserDB userDB = new UserDB();
        ProductDB productDB = new ProductDB();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Staff> staffs = new ArrayList<>();
        try {
            for (User x : userDB.getAllUsers()){
                if (x instanceof Customer) {
                    customers.add((Customer) x);
                } else if (x instanceof Staff) {
                    staffs.add((Staff) x);
                }
            }

            orderLb.setText(String.valueOf(orderDB.size()));
            staffLb.setText(String.valueOf(staffs.size()));
            userLb.setText(String.valueOf(customers.size()));
            productLb.setText(String.valueOf(productDB.size()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void sendName(String name) throws Exception {
//        holder = name;
//        if (this.name != null) {
//            this.name.setText("Hello " + Login.staff.getUsername() + "!");
//        }
//    }

}
