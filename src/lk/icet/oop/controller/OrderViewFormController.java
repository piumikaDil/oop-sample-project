package lk.icet.oop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.Customer;
import lk.icet.oop.model.Order;
import lk.icet.oop.tm.CustomerTm;
import lk.icet.oop.tm.OrderTm;

public class OrderViewFormController {

    public TableView tblOrder;
    public TableColumn colOrderId;
    public TableColumn colQty;
    public TableColumn colCusId;

    public void initialize() {

        colCusId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("oId"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        viewCustomer();
    }

    private  void viewCustomer () {
        ObservableList<OrderTm> tmList = FXCollections.observableArrayList();
        for (Order o1 : Database.orderTable
        ) {
            OrderTm tm = new OrderTm(o1.getOrderId(),o1.getCusId(),o1.getQty());

            tmList.add(tm);


        }
        tblOrder.setItems(tmList);
    }

}
