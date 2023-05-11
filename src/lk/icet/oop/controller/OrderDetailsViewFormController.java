package lk.icet.oop.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.Customer;
import lk.icet.oop.model.OrderDetails;

public class OrderDetailsViewFormController {
    public TextField txtOrderId;
    public Label lblCusId;
    public Label lblCusName;
    public Label lblQty;
    public Label lblBill;
    public Button btnBack;

    public void txtOrderIdOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            setDetails();
        }
    }

    public void setDetails() {
        for (OrderDetails c : Database.orderDetailsTable) {
            if (c.getoId().equals(txtOrderId.getText())) {
                lblCusName.setText(c.getName());
                lblCusId.setText(c.getCusId());
                lblBill.setText(String.valueOf(c.getValue()));
                lblQty.setText(String.valueOf(c.getQty()));

            }
        }
}}
