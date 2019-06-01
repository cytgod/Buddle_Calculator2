package model;

public class Bundles {
    private int num;
    private String currency;
    private double price;

    public Bundles(int num, String currency,double price) {
        this.num = num;
        this.price = price;
        this.currency = currency;
    }
    public String toString(){
        return num+" "+currency+price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int equals(Bundles other){
        if (this.getPrice()==other.getPrice()&&this.getCurrency().equals(other.getCurrency())&&this.getNum()==other.getNum())
            return 1;
        else
            return -1;
    }
}
