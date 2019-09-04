package model;

public class Sale {
    private int saleId;
    private String status;
    private int[] products;
    private int total;
    private int totalqty;

    public Sale(int saleId, String status, int[] products, int total, int totalqty) {
        this.saleId = saleId;
        this.status = status;
        this.products = products;
        this.total = total;
        this.totalqty = totalqty;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int[] getProduct() {
        return products;
    }

    public void setProduct(int[] products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        total = total;
    }

    public int getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(int totalqty) {
        totalqty = totalqty;
    }
}
