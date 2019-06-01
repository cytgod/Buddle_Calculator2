package service;


import java.util.ArrayList;

public class FilledOrder {
    private ArrayList<FilledLineItem> filledOrder;

    public FilledOrder(ArrayList<FilledLineItem> filledOrder) {
        this.filledOrder = filledOrder;
    }

    public String getTotalOrder(){
        String totalOrder = "";
        for (FilledLineItem e:filledOrder
             ) {
            totalOrder = totalOrder.concat(e.getFilledItem());
        }

        return totalOrder;
    }
}
