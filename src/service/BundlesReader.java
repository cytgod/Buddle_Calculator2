package service;

import model.Bundles;

import java.util.ArrayList;
import java.util.List;

public class BundlesReader {


    //read bundles information from a String
    public static List<Bundles> parseBundles(String a) {
        List<Bundles> bundles = new ArrayList<>();
        String[] info = a.trim().split(" ");
        int i = 0;
        while (i < info.length) {
            int num = Integer.parseInt(info[i]);
            String currency = info[i + 2].substring(0, 1);
            double money = Double.parseDouble(info[i + 2].substring(1));
            bundles.add(new Bundles(num, currency, money));
            i += 3;
        }
        return bundles;
    }

}
