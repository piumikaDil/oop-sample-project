package lk.icet.oop.db;

import lk.icet.oop.model.Customer;
import lk.icet.oop.model.Order;
import lk.icet.oop.model.OrderDetails;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerTable
            = new ArrayList<>();
    public static ArrayList<Order> orderTable
            = new ArrayList<>();
    public static ArrayList<OrderDetails> orderDetailsTable
            = new ArrayList<>();
}
