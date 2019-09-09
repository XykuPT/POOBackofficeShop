package model;


import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Arrays;
import java.util.List;

public class Sale {
    private int saleId;
    private String status;
    private List<String> product;
    private int total;
    private int quantityTotal;

    public Sale(){

    }

    public Sale( int saleId, String status, int total, int quantityTotal, List<String> product) {
        this.saleId = saleId;
        this.status = status;
        this.total = total;
        this.quantityTotal = quantityTotal;
        this.product = product;
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
