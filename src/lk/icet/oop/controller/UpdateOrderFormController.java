package lk.icet.oop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.OrderDetails;

import java.io.IOException;

public class UpdateOrderFormController {
    public ComboBox cmbOrder;
    public TextField txtCusId;
    public TextField txtCusName;
    public TextField txtQty;
    public TextField txtValue;
    public Button btnUpdate;
    public Button btnBackToHome;

    public void initialize() {
        loadAllOrderIds();

        cmbOrder.getSelectionModel()
                .selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        setOrderDetails();
                    }

                });
    }

    public void txtQtyOnAction(KeyEvent keyEvent) {
        int qty = Integer.parseInt(txtQty.getText());
        String value = String.valueOf(qty * 500);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            txtValue.setText(value);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        for (int i = 0; i < Database.orderDetailsTable.size(); i++) {
            if (cmbOrder.getValue() == (Database.orderDetailsTable.get(i).getoId())) {
                Database.orderDetailsTable.get(i).setCusId(txtCusId.getText());
                Database.orderDetailsTable.get(i).setName(txtCusName.getText());
                Database.orderDetailsTable.get(i).setQty(Integer.parseInt(txtQty.getText()));
                Database.orderDetailsTable.get(i).setValue(Integer.parseInt(txtValue.getText()));
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated...").show();
            }
        }
    }

    private void loadAllOrderIds() {
        for (OrderDetails o : Database.orderDetailsTable) {
            cmbOrder.getItems().add(o.getoId());

        }
    }

    public void setOrderDetails() {
        for (OrderDetails r : Database.orderDetailsTable) {
            if (r.getoId().equals(cmbOrder.getValue())) {
                txtCusId.setText(r.getCusId());
                txtCusName.setText(r.getName());
                txtQty.setText(String.valueOf(r.getQty()));
                txtValue.setText(String.valueOf(r.getValue()));
            }
        }
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
        stage.show();
    }
}
