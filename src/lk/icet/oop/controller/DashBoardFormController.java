package lk.icet.oop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public Button btnAddCus;
    public Button btnPlaceOrder;
    public Button btnUpdateOrder;
    public Button btnViewOrder;
    public Button btnExit;

    public void btnAddCusOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddNewCustomerForm.fxml"))));
        stage.show();
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/PlaceOrderForm.fxml"))));
        stage.show();
    }

    public void btnUpdateOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UpdateOrderForm.fxml"))));
        stage.show();
    }

    public void btnViewOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/viewForm.fxml"))));
        stage.show();
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
    }

//    private void setUi(String location) throws IOException {
//        JFXPanel context;
//        Stage stage = (Stage) context.getScene().getWindow();
//        stage.setScene(new Scene(
//                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
//        stage.centerOnScreen();
//    }
}
