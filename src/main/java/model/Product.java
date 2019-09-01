package model;

import java.util.List;

public class Product {
    private int prodId;
    private String name;
    private String price;
    private int qty;
    private String category;
    private List<String> color;

    public Product() {

    }

    public Product(int prodId, String name, String price, int qty, String category, List<String> color) {
        this.prodId = prodId;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.category = category;
        this.color = color;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", category='" + category + '\'' +
                ", color=" + color +
                '}';
    }
}
