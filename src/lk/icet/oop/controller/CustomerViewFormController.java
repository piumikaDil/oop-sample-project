package lk.icet.oop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.icet.oop.db.Database;
import lk.icet.oop.model.Customer;
import lk.icet.oop.tm.CustomerTm;

public class CustomerViewFormController {
    public TableColumn cusId;
    public TableColumn cusName;
    public TableView tblCustomer;

    public void initialize() {

        cusId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewCustomer();
    }

     private  void viewCustomer () {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        for (Customer c1 : Database.customerTable
        ) {
            CustomerTm tm = new CustomerTm(c1.getId(), c1.getName());

            tmList.add(tm);


        }
        tblCustomer.setItems(tmList);
    }

}

