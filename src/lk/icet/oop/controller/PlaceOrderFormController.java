package lk.icet.oop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.Customer;
import lk.icet.oop.model.Order;
import lk.icet.oop.model.OrderDetails;

import java.io.IOException;

public class PlaceOrderFormController {

    public Label lblOrderId;
    public TextField txtCusId;
    public TextField txtName;
    public TextField txtQty;
    public TextField txtValue;
    public Button btnPlaceOrder;
    public Button btnCancel;
    public Button btnBack;

    public void initialize() {
        setOrdertomerId();

    }

    public void txtCusIdOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            setCustomerDetails();
            txtQty.requestFocus();
        }
    }

    public void txtNameOnAction(KeyEvent keyEvent) {
    }

    public void txtQtyOnAction(KeyEvent keyEvent) {
        int qty = Integer.parseInt(txtQty.getText());
        String value = String.valueOf(qty * 500);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            txtValue.setText(value);
        }
    }

    public void txtValueOnAction(KeyEvent keyEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        Order o1 = new Order(
                txtCusId.getText(),
                lblOrderId.getText(),
                Integer.parseInt(txtQty.getText()),
                Integer.parseInt(txtValue.getText())
        );

        OrderDetails orderDetails = new OrderDetails(
                lblOrderId.getText(),
                txtCusId.getText(),
                txtName.getText(),
                Integer.parseInt(txtQty.getText()),
                Integer.parseInt(txtValue.getText())
        );
        Database.orderDetailsTable.add(orderDetails);

        boolean isSave = Database.orderTable.add(o1);

        if (isSave) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order added succesfully!").show();

        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
        stage.show();
    }

    public void setCustomerDetails() {
        for (Customer c : Database.customerTable) {
            if (c.getId().equals(txtCusId.getText())) {
                txtName.setText(c.getName());

            }
        }
    }

    public void setOrdertomerId() {
        if (Database.orderTable.isEmpty()) {
            lblOrderId.setText("O-1");
            return;
        }
        String tempOrderId = Database.orderTable.get(Database.orderTable.size() - 1).getOrderId();
        String array[] = tempOrderId.split("-");
        int tempNum = Integer.parseInt(array[1]);
        int finalOrderId = tempNum + 1;
        lblOrderId.setText("O-" + finalOrderId);
    }
}
