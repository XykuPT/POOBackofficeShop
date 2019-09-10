package model;

/**
 * Price Model
 */
public class Price {
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
