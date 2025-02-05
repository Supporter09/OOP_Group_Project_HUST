package controller.staff.storageTable;

import controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Products.Stationary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StationaryEdit implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf6;


    public void handleDashboardButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/admin/dashboard.fxml"));
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

    public void handleStorageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleReturnButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleInsertButton(ActionEvent event) throws Exception {
        if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf2.getText().isEmpty()
                || tf4.getText().isEmpty() || tf5.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty field");
            alert.setHeaderText("Please fill all field before insert!");
            alert.showAndWait();
            return;
        }

        Login.staff.updateNameOfProduct(storage.editable,tf1.getText());
        Login.staff.updateTypeOfStationary((Stationary) storage.editable,tf4.getText());
        Login.staff.updatePriceOfProduct(storage.editable,Double.parseDouble(tf2.getText()));
        Login.staff.updateBrandOfStationary((Stationary) storage.editable, tf3.getText());
        Login.staff.updateDescriptionOfProduct(storage.editable, tf5.getText());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Edit successfully");
        alert.setHeaderText("Edit stationary information successfully!");
        alert.showAndWait();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Stationary x = (Stationary) storage.editable;
        tf1.setText(x.getName());
        tf2.setText(String.valueOf(x.getPrice()));
        tf3.setText(x.getBrand());
        tf4.setText(x.getStationaryType());
        tf5.setText(x.getDescription());
    }
}
