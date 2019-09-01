package model;

import java.util.List;

public class Sale {
    private List<Product> product;
    private int total;
    private int totalqty;

    public Sale(List<Product> product, int total, int totalqty) {
        this.product = product;
        this.total = total;
        this.totalqty = totalqty;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
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
