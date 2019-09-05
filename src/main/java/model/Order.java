package model;

import java.util.List;

public class Order extends Sale {
    private String Address;
    private String Location;

    public Order(int saleId, String status, int[] product, int total, int totalqty, String address, String location) {
        super(saleId, status, product, total, totalqty);
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
}