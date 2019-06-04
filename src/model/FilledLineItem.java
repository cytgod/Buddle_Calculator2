package model;

import java.util.HashMap;

public class FilledLineItem {
    private final LineItem li;

    private final HashMap<Integer, Integer> hm;

    public FilledLineItem(LineItem li, HashMap<Integer, Integer> hm) {
        this.li = li;
        this.hm = hm;

    }

    private double totalMoney() {
        double money = 0;
        for (Bundles e : li.getMediaType().getBundles()
        )
            money += hm.get(e.getNum()) * e.getPrice();
        return money;
    }

  String getFilledItem() {
        double money = totalMoney();
        String filledItem = li.toString() + " " + li.getMediaType().getBundles().get(0).getCurrency() + money + "\n";
        for (Bundles e : li.getMediaType().getBundles()
        ) {
            if (hm.get(e.getNum()) != 0)
                filledItem = filledItem.concat(hm.get(e.getNum()) + " x " + e.getNum() + " " + e.getCurrency() + hm.get(e.getNum()) * e.getPrice() + "\n");
        }

        return filledItem;
    }


}
