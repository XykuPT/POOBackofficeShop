package model;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Arrays;
import java.util.List;

class Price {
    private int value;

    public Price(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    private String currency;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}

public class Product {
    private int prodId;
    private String name;
    private Price price;
    private int quantity;
    private String category;
    private List<String> colors;

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
        int value = this.price.getValue();
        String currency = this.price.getCurrency();
        return value + currency;
    }

    @BsonProperty("price")
    public void setPrice(String price) {
        int value = Integer.parseInt(price.substring(0, price.length() -1));
        String currency = price.substring(price.length() -1);
        Price customPrice = new Price(value, currency);
        this.price = customPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @BsonProperty("qty")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getColors() {
        return colors;
    }

    @BsonProperty("color")
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", colors=" + colors +
                '}';
    }
}
