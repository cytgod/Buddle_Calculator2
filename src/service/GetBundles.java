package service;

import model.Bundles;

import java.util.ArrayList;

public class GetBundles {

   //read boundles information from a String
    public  static ArrayList<Bundles> parseBundles(String a){
        ArrayList<Bundles> bundles = new ArrayList<>();
        String[] info = a.trim().split(" ");
        int i=0;
        while(i<info.length){
            int num = Integer.parseInt(info[i]);
            String currency = info[i+2].substring(0,1);
            double money = Double.parseDouble(info[i+2].substring(1,info[i+2].length()));
            bundles.add(new Bundles(num,currency,money));
            i+=3;
        }
        return bundles;
    }

}
