package test;

import model.LineItem;
import org.junit.Before;
import org.junit.Test;
import service.LineItemBundleCalculator;
import service.SubmissionReader;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LineItemBundleCalculatorTest {
    private LineItemBundleCalculator libc;
    private SubmissionReader sr = new SubmissionReader();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void calculateLineItem1test1() {
        sr.getInformation("D:\\ajava\\22.txt");

        LineItem li = new LineItem(19, sr.getAll().get(1));
        libc = new LineItemBundleCalculator(li);
        assertEquals(new Integer[]{9, 6, 3}, libc.getBundle());

//        assertEquals((long)1,(long)hm.get(9));
//        assertEquals((long)2,(long)hm.get(5));
//        assertEquals((long)0,(long)hm.get(3));


    }

    @Test
    public void calculateLineItem1test2() {
        sr.getInformation("D:\\ajava\\22.txt");

        LineItem li = new LineItem(25, sr.getAll().get(1));
        libc = new LineItemBundleCalculator(li);
        HashMap<Integer, Integer> hm = libc.calculateLineItem();

        assertEquals((long) 3, (long) hm.get(9));
        assertEquals((long) 0, (long) hm.get(6));
        assertEquals((long) 0, (long) hm.get(3));


    }

    @Test
    public void calculateLineItem1test3() {
        sr.getInformation("D:\\ajava\\22.txt");

        LineItem li = new LineItem(19, sr.getAll().get(0));
        libc = new LineItemBundleCalculator(li);
        HashMap<Integer, Integer> hm = libc.calculateLineItem();

        assertEquals((long) 2, (long) hm.get(10));
        assertEquals((long) 0, (long) hm.get(5));


    }
}