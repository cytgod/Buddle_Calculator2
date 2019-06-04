package service;

import algorithm.MinimumBundlesCalculator;
import model.LineItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LineItemBundleCalculator {

    private final HashMap<Integer, Integer> hm = new HashMap<>();

    private LineItem li;

    public LineItemBundleCalculator(LineItem li) {

        this.li = li;
    }

    public Integer[] getBundle() {
        Integer[] bundle = new Integer[li.getMediaType().getBundles().size()];
        for (int i = 0; i < li.getMediaType().getBundles().size(); i++) {
            bundle[i] = li.getMediaType().getBundles().get(i).getNum();
        }
        Arrays.sort(bundle, Collections.reverseOrder());
        return bundle;
    }

    public HashMap<Integer, Integer> calculateLineItem() {
        Integer[] a = getBundle();
        MinimumBundlesCalculator mbc = new MinimumBundlesCalculator(a);
        int need = li.getNum();
        Integer[] num = mbc.calculator(need);
        for (int i = 0; i < a.length; i++) {
            hm.put(a[i], num[i]);
        }
        return hm;

    }
}
