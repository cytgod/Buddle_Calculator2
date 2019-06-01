package model;

import java.util.ArrayList;

public class Order {
    private ArrayList<LineItem> order;

    public Order(ArrayList<LineItem> order) {
        this.order = order;
    }

    public ArrayList<LineItem> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<LineItem> order) {
        this.order = order;
    }


}
