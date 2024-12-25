package controller.admin;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Products.ProductInfo;
import model.Report.Report;

import java.io.IOException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class statistic implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private ChoiceBox<String> fromMonth;

    @FXML
    private ChoiceBox<String> fromYear;

    @FXML
    private ChoiceBox<String> toMonth;

    @FXML
    private ChoiceBox<String> toYear;

    @FXML
    private ChoiceBox<String> toDate;

    @FXML
    private ChoiceBox<String> fromDate;

    @FXML
    private Label profitLable;

    @FXML
    private Label revenueLable;

    @FXML
    private Label expenseLabel;

    @FXML
    private TableColumn<ProductInfo, Integer> id;

    @FXML
    private TableColumn<ProductInfo, String> name;

    @FXML
    private TableColumn<ProductInfo, Double> price;

    @FXML
    private TableColumn<ProductInfo, Integer> quantity;

    @FXML
    private TableView<ProductInfo> table;

    private String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    private String[] year = {"2023","2024"};
    private String[] date = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                            "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    ObservableList<ProductInfo> productObservableList = FXCollections.observableArrayList();
    @FXML
    public void handleDashboardButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/admin/dashboard.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleEmployeeButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/admin/employeeTable/employee.fxml"));
        Parent root = fxmlLoader.load();
        dialogStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    public void handleStorageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/admin/storageTable/storage.fxml"));
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
        fromMonth.getItems().addAll(month);
        toMonth.getItems().addAll(month);
        fromYear.getItems().addAll(year);
        toYear.getItems().addAll(year);
        fromDate.getItems().addAll(date);
        toDate.getItems().addAll(date);
    }

    public void handleExtractButton(ActionEvent event) throws Exception {
        try{
            YearMonth startYearMonth = YearMonth.of(
                    Integer.parseInt(fromYear.getValue()),
                    Integer.parseInt(fromMonth.getValue())
            );
            LocalDate startDate = startYearMonth.atDay(Integer.parseInt(fromDate.getValue()));

            YearMonth endYearMonth = YearMonth.of(
                    Integer.parseInt(toYear.getValue()),
                    Integer.parseInt(toMonth.getValue())
            );
            LocalDate endDate = endYearMonth.atDay(Integer.parseInt(toDate.getValue()));
            System.out.println(startDate);
            System.out.println(endDate);
            Report report = new Report(startDate, endDate);

            // Update the labels with the values from the report
            expenseLabel.setText(String.valueOf(report.getCosts()));
            revenueLable.setText(String.valueOf(report.getRevenue()));
            profitLable.setText(String.valueOf(report.getProfit()));

//            ProductInfo p = null;
//            try {
//                ArrayList<ProductInfo> allProducts = report.getProductInfos();
//                for(ProductInfo x : allProducts){
//                    productObservableList.add(x);
//                }
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//
//            id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProduct().getProductID()).asObject());
//            name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getName()));
//            price.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getProduct().getPrice()).asObject());
//            quantity.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
//
//            table.setItems(productObservableList);
//            table.refresh();

        }






        catch (DateTimeException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong date format");
            alert.setHeaderText("Please choose appropriate date!");
            alert.showAndWait();

        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty field");
            alert.setHeaderText("Please pick a date!");
            alert.showAndWait();
        }

    }
}
