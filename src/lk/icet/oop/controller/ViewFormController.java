package lk.icet.oop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.Customer;
import lk.icet.oop.tm.CustomerTm;

import java.io.IOException;

public class ViewFormController {
    public Button btnViewCustomer;
    public Button btnViewOrder;
    public Button btnDetails;

    public void btnViewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/CustomerViewForm.fxml"))));
        stage.show();
    }

    public void btnViewOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderViewForm.fxml"))));
        stage.show();
    }

    public void btnDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderDetailsViewForm.fxml"))));
        stage.show();
    }
}



