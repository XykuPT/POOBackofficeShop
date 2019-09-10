package model;

import java.util.List;

public class Sale {
    private String type;
    private int saleId;
    private String status;
    private List<String> product;
    private int total;
    private int quantityTotal;

    public Sale(){

    }

    public Sale(String type, int saleId, String status, List<String> product, int total, int quantityTotal) {
        this.type = type;
        this.saleId = saleId;
        this.status = status;
        this.total = total;
        this.quantityTotal = quantityTotal;
        this.product = product;
    }

    public String getType(){return type;}
    public void setType(String type){this.type = type;}
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

    public List<String> getProduct() {
        return product;
    }
    public void setProduct(List<String> product) {
        this.product = product;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getQuantityTotal() {
        return quantityTotal;
    }
    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", quantityTotal=" + quantityTotal +
                ", product=" + product +
                '}';
    }
}
