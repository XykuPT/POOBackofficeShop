package model;

import java.util.List;

public class Order extends Sale {
    private String Address;
    private String Location;

    public Order(String type, int saleId, String status, List<String> product, int total, int quantityTotal, String address, String location) {
        super(type, saleId, status, product, total, quantityTotal);
        Address = address;
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Address='" + Address + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}
