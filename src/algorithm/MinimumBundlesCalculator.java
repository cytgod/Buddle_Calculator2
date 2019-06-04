package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;




public class MinimumBundlesCalculator {
    private final Integer[] bundleNum;
    //record the combination of bundles with minimum number of items
    private Integer[] min;


    public MinimumBundlesCalculator(Integer[] a) {
        this.bundleNum = a;
        min = new Integer[a.length];
        Arrays.fill(min, 10000);
    }

    public Integer[] getMin(Integer[] a, Integer[] b, Integer[] c) {
        int b1 = 0;
        int c1 = 0;
        for (int i = 0; i < a.length; i++) {
            b1 += a[i] * b[i];
            c1 += a[i] * c[i];
        }
        return b1 > c1 ? c : b;
    }

    //int t is the total num of items customer needs, HashMap<Integer,Integer> s is the submission format
    public Integer[] calculator(int t) {

        Integer[] order = new Integer[bundleNum.length];
        Arrays.fill(order, 0);
        List<Integer[]> collection = new ArrayList<>();
        Optional<Integer[]> optional = Optional.ofNullable(calculate(bundleNum, order, t, collection));
        return optional.orElse(min);

    }

    //bundleNum will be an array that is in descending order
    private Integer[] calculate(Integer[] bundleNum, Integer[] order, int gross, List<Integer[]> collection) {

        for (int i = 0; i < bundleNum.length; i++) {
            collection.add(Arrays.copyOf(order, order.length));
            //Record every possible combination
            collection.get(collection.size() - 1)[i] += 1;
            //if the gross can be separated exactly with nothing left, return the combination
            if (gross - bundleNum[i] == 0) {
                return collection.get(collection.size() - 1);
            }
            // if the gross can't be separated exactly, recording record the combination of bundles with minimum number of items
            if (gross - bundleNum[i] < 0) {
                min = getMin(bundleNum, min, collection.get(collection.size() - 1));
            }
            if (gross - bundleNum[i] > 0) {
                //only result that is not null can be returned
                Optional<Integer[]> optional = Optional.ofNullable(calculate(bundleNum, collection.get(collection.size() - 1), gross - bundleNum[i], collection));
                if (optional.isPresent()) {
                    return optional.get();
                }
            }
        }
        return null;

    }

}
