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
import java.util.regex.Pattern;

public class AddNewCustomerFormController {
    public TextField txtCusId;
    public TextField txtCusName;
    public Label lblOrderId;
    public TextField txtQty;
    public TextField txtBill;
    public Button btnPlaceOrder;
    public Button btnCancel;
    public Button btnBack;

    public void initialize(){
        setOrdertomerId();

    }

    public void txtCusIdOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (validatePhoneNumber(txtCusId.getText())){
                txtCusName.requestFocus();
            }else{
                new Alert(Alert.AlertType.ERROR, "Enter correct id!").show();

            }

        }
    }

    public void txtCusNameOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            txtQty.requestFocus();
        }
    }

    public void txtQtyOnAction(KeyEvent keyEvent) {
        int qty = Integer.parseInt(txtQty.getText());
        String value = String.valueOf(qty * 500);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            txtBill.setText(value);
        }
    }

    public void txtBillOnAction(KeyEvent keyEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        if ( txtCusName.getText().isEmpty() || txtQty.getText().isEmpty() || txtBill.getText().isEmpty() ){
            new Alert(Alert.AlertType.ERROR, "Enter All Details!").show();

        }else {
            Customer c1 = new Customer(
                    txtCusId.getText(),
                    txtCusName.getText()
            );

            Database.customerTable.add(c1);


            Order o1 = new Order(
                    txtCusId.getText(),
                    lblOrderId.getText(),
                    Integer.parseInt(txtQty.getText()),
                    Integer.parseInt(txtBill.getText())
            );

            OrderDetails orderDetails = new OrderDetails(
                    lblOrderId.getText(),
                    txtCusId.getText(),
                    txtCusName.getText(),
                    Integer.parseInt(txtQty.getText()),
                    Integer.parseInt(txtBill.getText())
            );
            Database.orderDetailsTable.add(orderDetails);


            boolean isOrderSave = Database.orderTable.add(o1);

            if (isOrderSave) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order added succesfully!").show();
                setOrdertomerId();
                clear();
            }
        }


    }

    public void btnCanselOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"))));
        stage.show();
    }

    public static boolean validatePhoneNumber(String phone) {
        if(phone==null || phone.isEmpty()){
            return false;
        }
        String emailRegex =  "^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$";
        Pattern emailPattern =Pattern.compile(emailRegex);

        if(emailPattern.matcher(phone).matches()){
            return true;
        }else {
            return false;
        }
    }

    public void setOrdertomerId(){
        if (Database.orderTable.isEmpty()){
            lblOrderId.setText("O-1");
            return;
        }
        String tempOrderId = Database.orderTable.get(Database.orderTable.size() - 1).getOrderId();
        String array[] = tempOrderId.split("-");
        int tempNum = Integer.parseInt(array[1]);
        int finalOrderId = tempNum + 1;
        lblOrderId.setText("O-" + finalOrderId);
    }

    public void clear(){
        txtBill.clear();
        txtCusId.clear();
        txtCusName.clear();
        txtQty.clear();
    }
}
