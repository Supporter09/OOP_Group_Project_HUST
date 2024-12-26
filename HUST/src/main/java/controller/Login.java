package controller;

import app.utils.HelperMethods;
import controller.admin.dashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Databases.UserDB;
import model.Users.Admin;
import model.Users.Customer;
import model.Users.Staff;
import model.Users.User;

import java.io.IOException;

public class Login {
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;


    private static UserDB userdb = new UserDB();
    public static Staff staff;
    public static Admin admin;
    public static Customer customer;

    Stage dialogStage = new Stage();

    Scene scene;

    public void handleLoginButton(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty()){
            HelperMethods.alertBox("Please enter the Username", null, "Login Failed!");
        }
        else if (password.isEmpty()){
            HelperMethods.alertBox("Please enter the Password", null, "Login Failed!");
        }
        else {
            try{
                User user = userdb.getByUsernameAndPassword(username,password);

                switch (user) {
                    case Admin admin1 -> {
                        System.out.println("admin");
                        admin = admin1;
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/admin/dashboard.fxml"));
                        Parent root = fxmlLoader.load();

                        controller.admin.dashboard controller = fxmlLoader.getController();


                        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        dialogStage.setScene(scene);
                        dialogStage.show();
                        //break;
                    }

                    case Staff staff1 -> {
                        System.out.println("staff");
                        staff = staff1;
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/dashboard.fxml"));
                        Parent root = fxmlLoader.load();

                        controller.staff.dashboard controller = fxmlLoader.getController();
                        controller.initialize(null, null);  // This will set the name using the staff username

                        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        dialogStage.setScene(scene);
                        dialogStage.show();
                        //break;
                    }

                    case Customer customer1 -> {
                        System.out.println("customer");
                        customer = customer1;
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/user/Dashboard.fxml"));
                        Parent root = fxmlLoader.load();
                        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        dialogStage.setScene(scene);
                        dialogStage.show();
                        //break;
                    }
                    case null, default -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Wrong Information");
                        alert.setHeaderText("Please check your username and password!");
                        alert.showAndWait();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }



    public void handleRegisterButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/Register.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleGuestButton(ActionEvent event) throws Exception {
        customer = new Customer("New","New");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/user/Dashboard.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

}









