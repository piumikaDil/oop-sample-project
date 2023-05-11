package lk.icet.oop.model;

public class OrderDetails {
    private String oId;
    private String cusId;
    private String name;
    private int qty;
    private int value;

    public OrderDetails() {
    }

    public OrderDetails(String oId, String cusId, String name, int qty, int value) {
        this.oId = oId;
        this.cusId = cusId;
        this.name = name;
        this.qty = qty;
        this.value = value;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
