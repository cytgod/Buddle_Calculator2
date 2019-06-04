package model;

import java.util.List;

public class Order {
    private List<LineItem> order;

    public Order(List<LineItem> order) {
        this.order = order;
    }

    public List<LineItem> getOrder() {
        return order;
    }

}
