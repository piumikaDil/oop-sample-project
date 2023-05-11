package lk.icet.oop.model;

public class Order {
    private String cusId;
    private String orderId;
    private int qty;
    private int value;

    public Order() {
    }

    public Order(String cusId, String orderId, int qty, int value) {
        this.cusId = cusId;
        this.orderId = orderId;
        this.qty = qty;
        this.value = value;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "Order{" +
                "cusId='" + cusId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", qty=" + qty +
                ", value=" + value +
                '}';
    }
}
