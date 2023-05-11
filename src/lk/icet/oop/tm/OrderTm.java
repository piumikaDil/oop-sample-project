package lk.icet.oop.tm;

public class OrderTm {
    private String oID;
    private String cusId;
    private int qty;

    public OrderTm() {
    }

    public OrderTm(String oID, String cusId, int qty) {
        this.oID = oID;
        this.cusId = cusId;
        this.qty = qty;
    }

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
