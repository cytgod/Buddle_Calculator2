package service;

import model.Bundles;
import model.LineItem;


import java.util.HashMap;

public class FilledLineItem {
    private LineItem li;

    private HashMap<Integer,Integer> hm ;

    public FilledLineItem(LineItem li,HashMap<Integer,Integer> hm) {
        this.li = li;
        this.hm = hm;

    }
    public double totalMoney(){
        double money = 0;
        for (Bundles e:li.getMediaType().getBundles()
        ) {
            money+=hm.get(e.getNum())*e.getPrice();
        }
        return money;
    }
    public String getFilledItem(){
        double money = totalMoney();
        String filleditem = li.toString()+" "+li.getMediaType().getBundles().get(0).getCurrency()+money+"\n";
        for (Bundles e:li.getMediaType().getBundles()
             ) {
            if(hm.get(e.getNum())!=0)
            filleditem = filleditem.concat(hm.get(e.getNum())+" x "+e.getNum()+" "+e.getCurrency()+hm.get(e.getNum())*e.getPrice()+"\n");
        }

        return filleditem;
    }


    public LineItem getLi() {
        return li;
    }

    public void setLi(LineItem li) {
        this.li = li;
    }


}
