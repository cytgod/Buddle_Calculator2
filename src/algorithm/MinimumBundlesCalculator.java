package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;


public class MinimumBundlesCalculator {
    private Integer[] a ;
    private int[] min;


    public MinimumBundlesCalculator(Integer[] a){
    this.a = a;
    min = new int[a.length];
    Arrays.fill(min,Integer.MAX_VALUE);
}

    public int[] getMin(Integer[] a,int[] b,int[] c){
        int b1 = 0;
        int c1= 0;
        for (int i = 0; i < a.length; i++) {
            b1 +=a[i]*b[i];
            c1 +=a[i]*c[i];
        }
        return b1>c1?c:b;
    }

    //int t is the total num of items customer needs, HashMap<Integer,Integer> s is the submission format
    public int[] calculator(int t){

        int[] order = new int[a.length];
        Arrays.fill(order,0);
        List<int[]> collection = new ArrayList<>();
        Optional<int[]> optional = Optional.ofNullable(calculate(a,order,t,collection));
        return optional.orElse(min);

        /*int[] v = calculate(a,order,t,collection);
        if(v==null){
            return min;
        }else{
            return v;
        }*/
    }

    private int[] calculate(Integer[] b,int[] order, int t, List<int[]> collection){

        for (int i = 0; i < b.length; i++) {
            collection.add(Arrays.copyOf(order,order.length));
            collection.get(collection.size()-1)[i]+=1;

            if(t-b[i]==0){
                return collection.get(collection.size()-1);
            }
            if(t-b[i]<0){
                min = getMin(b,min,collection.get(collection.size()-1));
            }
            if(t-b[i]>0){
                Optional<int[]> optional = Optional.ofNullable(calculate(b,collection.get(collection.size()-1),t-b[i],collection));
                if(optional.isPresent()){
                    return optional.get();
                }
                /*int[] re = calculate(b,collection.get(collection.size()-1),t-b[i],collection);
                if(re!=null)
                    return re;*/
            }
        }
        return null;

    }

}
