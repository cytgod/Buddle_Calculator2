package model;


import model.FilledLineItem;

import java.util.List;

public class FilledOrder {
    private final List<FilledLineItem> filledOrder;

    public FilledOrder(List<FilledLineItem> filledOrder) {
        this.filledOrder = filledOrder;
    }

    public String getTotalOrder() {
        String totalOrder = "";
        for (FilledLineItem e : filledOrder
        ) {
            totalOrder = totalOrder.concat(e.getFilledItem());
        }

        return totalOrder;
    }
}
