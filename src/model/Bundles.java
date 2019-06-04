package model;

public class Bundles {
    private final int num;
    private final String currency;
    private final double price;

    public Bundles(int num, String currency, double price) {
        this.num = num;
        this.price = price;
        this.currency = currency;
    }

    public String toString() {
        return num + " " + currency + price;
    }

    public int getNum() {
        return num;
    }

    public String getCurrency() {
        return currency;
    }

    public double getPrice() {
        return price;
    }


    public int equals(Bundles other) {
        if (this.getPrice() == other.getPrice() && this.getCurrency().equals(other.getCurrency()) && this.getNum() == other.getNum())
            return 1;
        else
            return -1;
    }
}
