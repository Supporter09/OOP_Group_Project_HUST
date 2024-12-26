package controller.staff.storageTable;

import controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Products.Stationary;
import model.Products.Toy;
import model.Products.Book;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class insertStorage implements Initializable {

    Stage dialogStage = new Stage();
    Scene scene;

    @FXML
    private Button dashboardButton;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private Label lb4;

    @FXML
    private Label lb5;

    @FXML
    private Label lb6;

    @FXML
    private Label lb7;

    @FXML
    private Label lb8;

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

    @FXML
    private TextField tf7;

    @FXML
    private TextField tf8;

    @FXML
    private ChoiceBox<String> typeField;

    private String[] typeChoice = {"Book","Toy","Stationary"};

    public void handleDashboardButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/dashboard.fxml"));
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

    public void handleLogoutButton(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/Login.fxml"));
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
        if (Objects.equals(typeField.getValue(), "Book")){
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() ||tf3.getText().isEmpty() ||
                    tf6.getText().isEmpty() ||tf5.getText().isEmpty() ||tf4.getText().isEmpty() ||
                    tf7.getText().isEmpty() || tf8.getText().isEmpty()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Please fill in all field!");
                errorAlert.show();
                return;
            }
            try {
                Login.staff.addProductToStore(new Book(tf1.getText(), Float.parseFloat(tf2.getText()), tf6.getText(),
                        tf3.getText(), tf4.getText(), Integer.parseInt(tf5.getText())), Integer.parseInt(tf8.getText()),
                        Float.parseFloat(tf7.getText()));

            } catch (NumberFormatException e){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Price, ISBN and import price must be a valid number.");
                errorAlert.show();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add product successfully");
            alert.setHeaderText("Add book successfully");
            alert.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
            Parent root = fxmlLoader.load();
            dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.show();
        }
//            lb1.setText("Name");
//            lb2.setText("Price");
//            lb3.setText("Brand");
//            lb4.setText("Description");
//            lb5.setText("Import price");
        else if (Objects.equals(typeField.getValue(), "Toy")){
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() ||tf3.getText().isEmpty() || tf5.getText().isEmpty() ||
            tf6.getText().isEmpty()){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Please fill in all field!");
                errorAlert.show();
                return;
            }
            try {
                Login.staff.addProductToStore(new Toy(tf1.getText(),Float.parseFloat(tf2.getText()),tf4.getText(),tf3.getText()),
                        Integer.parseInt(tf6.getText()),Float.parseFloat(tf5.getText()));
            } catch (NumberFormatException e){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Price and import price must be a valid number.");
                errorAlert.show();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add product successfully");
            alert.setHeaderText("Add toy successfully");
            alert.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
            Parent root = fxmlLoader.load();
            dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.show();
        }

        else if (Objects.equals(typeField.getValue(), "Stationary")){
//            lb1.setText("Name");
//            lb2.setText("Price");
//            lb3.setText("Brand");
//            lb4.setText("Stationary Type");
//            lb5.setText("Description");
//            lb6.setText("Import price");
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() ||tf3.getText().isEmpty() ||
                    tf4.getText().isEmpty() ||tf6.getText().isEmpty() || tf7.getText().isEmpty()){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Please fill in all field!");
                errorAlert.show();
                return;
            }
            try {
                Login.staff.addProductToStore(new Stationary(
                        tf1.getText(),Float.parseFloat(tf2.getText()),tf5.getText(),tf3.getText(),tf4.getText()),
                        Integer.parseInt(tf7.getText()),Float.parseFloat(tf6.getText()));
            } catch (NumberFormatException e){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText("Price and import price must be a valid number.");
                errorAlert.show();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add product successfully");
            alert.setHeaderText("Add stationary successfully");
            alert.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/staff/storageTable/storage.fxml"));
            Parent root = fxmlLoader.load();
            dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.show();
        }

    }

//    public void handleChooseButton(ActionEvent event) throws IOException {
//        if (Objects.equals(typeField.getValue(), "Book")){
//            tf1.setVisible(true);
//            tf2.setVisible(true);
//            tf3.setVisible(true);
//            tf4.setVisible(true);
//            tf5.setVisible(true);
//            tf6.setVisible(true);
//            tf7.setVisible(true);
//            tf8.setVisible(true);
//
//            lb1.setVisible(true);
//            lb2.setVisible(true);
//            lb3.setVisible(true);
//            lb4.setVisible(true);
//            lb5.setVisible(true);
//            lb6.setVisible(true);
//            lb7.setVisible(true);
//            lb8.setVisible(true);
//
//            lb1.setText("Name");
//            lb2.setText("Price");
//            lb3.setText("Publisher");
//            lb4.setText("Author");
//            lb5.setText("ISBN");
//            lb6.setText("Description");
//            lb7.setText("Import price");
//            lb8.setText("Quantity");
//        }
//
//        else if (Objects.equals(typeField.getValue(), "Toy")){
//            tf1.setVisible(true);
//            tf2.setVisible(true);
//            tf3.setVisible(true);
//            tf4.setVisible(true);
//            tf5.setVisible(true);
//            tf6.setVisible(true);
//            tf7.setVisible(false);
//            tf8.setVisible(false);
//
//            lb1.setVisible(true);
//            lb2.setVisible(true);
//            lb3.setVisible(true);
//            lb4.setVisible(true);
//            lb5.setVisible(true);
//            lb6.setVisible(true);
//            lb7.setVisible(false);
//            lb8.setVisible(false);
//
//            lb1.setText("Name");
//            lb2.setText("Price");
//            lb3.setText("Brand");
//            lb4.setText("Description");
//            lb5.setText("Import price");
//            lb6.setText("Quantity");
//        }
//
//        else if(Objects.equals(typeField.getValue(), "Stationary")){
//            tf1.setVisible(true);
//            tf2.setVisible(true);
//            tf3.setVisible(true);
//            tf4.setVisible(true);
//            tf5.setVisible(true);
//            tf6.setVisible(true);
//            tf7.setVisible(true);
//            tf8.setVisible(false);
//
//            lb1.setVisible(true);
//            lb2.setVisible(true);
//            lb3.setVisible(true);
//            lb4.setVisible(true);
//            lb5.setVisible(true);
//            lb6.setVisible(true);
//            lb7.setVisible(true);
//            lb8.setVisible(false);
//
//            lb1.setText("Name");
//            lb2.setText("Price");
//            lb3.setText("Brand");
//            lb4.setText("Stationary Type");
//            lb5.setText("Description");
//            lb6.setText("Import price");
//            lb7.setText("Quantity");
//        }
//    }

    public void handleChooseButton(ActionEvent event) throws IOException {
        // Check the selected type
        if (Objects.equals(typeField.getValue(), "Book")) {
            // Make fields visible for Book
            setVisibility(true, true, true, true, true, true, true, true);
            setLabels("Name", "Price", "Publisher", "Author", "ISBN", "Description", "Import price", "Quantity");
        } else if (Objects.equals(typeField.getValue(), "Toy")) {
            // Hide unused fields for Toy
            setVisibility(true, true, true, true, true, true, false, false);
            setLabels("Name", "Price", "Brand", "Description", "Import price", "Quantity", "", "");
        } else if (Objects.equals(typeField.getValue(), "Stationary")) {
            // Hide unused fields for Stationary
            setVisibility(true, true, true, true, true, true, true, false);
            setLabels("Name", "Price", "Brand", "Stationary Type", "Description", "Import price", "Quantity", "");
        }
    }

    // Helper method to manage visibility
    private void setVisibility(boolean tf1Vis, boolean tf2Vis, boolean tf3Vis, boolean tf4Vis,
                               boolean tf5Vis, boolean tf6Vis, boolean tf7Vis, boolean tf8Vis) {
        tf1.setVisible(tf1Vis);
        tf2.setVisible(tf2Vis);
        tf3.setVisible(tf3Vis);
        tf4.setVisible(tf4Vis);
        tf5.setVisible(tf5Vis);
        tf6.setVisible(tf6Vis);
        tf7.setVisible(tf7Vis);
        tf8.setVisible(tf8Vis);

        tf1.setManaged(tf1Vis);
        tf2.setManaged(tf2Vis);
        tf3.setManaged(tf3Vis);
        tf4.setManaged(tf4Vis);
        tf5.setManaged(tf5Vis);
        tf6.setManaged(tf6Vis);
        tf7.setManaged(tf7Vis);
        tf8.setManaged(tf8Vis);

        tf1.clear();
        tf2.clear();
        tf3.clear();
        tf4.clear();
        tf5.clear();
        tf6.clear();
        tf7.clear();
        tf8.clear();

        lb1.setVisible(tf1Vis);
        lb2.setVisible(tf2Vis);
        lb3.setVisible(tf3Vis);
        lb4.setVisible(tf4Vis);
        lb5.setVisible(tf5Vis);
        lb6.setVisible(tf6Vis);
        lb7.setVisible(tf7Vis);
        lb8.setVisible(tf8Vis);

        lb1.setManaged(tf1Vis);
        lb2.setManaged(tf2Vis);
        lb3.setManaged(tf3Vis);
        lb4.setManaged(tf4Vis);
        lb5.setManaged(tf5Vis);
        lb6.setManaged(tf6Vis);
        lb7.setManaged(tf7Vis);
        lb8.setManaged(tf8Vis);
    }

    // Helper method to set labels
    private void setLabels(String lbl1, String lbl2, String lbl3, String lbl4, String lbl5, String lbl6, String lbl7, String lbl8) {
        lb1.setText(lbl1);
        lb2.setText(lbl2);
        lb3.setText(lbl3);
        lb4.setText(lbl4);
        lb5.setText(lbl5);
        lb6.setText(lbl6);
        lb7.setText(lbl7);
        lb8.setText(lbl8);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVisibility(false, false, false, false, false, false, false, false);
        typeField.getItems().addAll(typeChoice);
    }
}
