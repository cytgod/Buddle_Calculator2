package test;

import algorithm.MinimumBundlesCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MinimumBundlesCalculatorTest {
    private MinimumBundlesCalculator cal;
    private Integer[] a = {9, 5, 3};

    @Before
    public void setup() {
        cal = new MinimumBundlesCalculator(a);
    }

    @Test
    public void test1() {
        Integer[] b = {1, 0, 0};
        Integer[] c = {13, 13, 13};
        assertArrayEquals(new Integer[]{1, 0, 0}, cal.getMin(a, b, c));
    }

    @Test
    public void test2() {


        assertArrayEquals(new Integer[]{0, 0, 1}, cal.calculator(1));
    }

    @Test
    public void test3() {


        assertArrayEquals(new Integer[]{0, 0, 1}, cal.calculator(2));
    }

    @Test
    public void test4() {

        assertArrayEquals(new Integer[]{0, 0, 1}, cal.calculator(3));
    }

    @Test
    public void test5() {
        assertArrayEquals(new Integer[]{0, 1, 0}, cal.calculator(4));
    }

    @Test
    public void test6() {

        assertArrayEquals(new Integer[]{0, 1, 0}, cal.calculator(5));
    }

    @Test
    public void test7() {

        assertArrayEquals(new Integer[]{0, 0, 2}, cal.calculator(6));
    }

    @Test
    public void test8() {

        assertArrayEquals(new Integer[]{0, 1, 1}, cal.calculator(7));
    }

    @Test
    public void test9() {

        assertArrayEquals(new Integer[]{0, 1, 1}, cal.calculator(8));
    }

    @Test
    public void test10() {

        assertArrayEquals(new Integer[]{1, 0, 0}, cal.calculator(9));
    }

    @Test
    public void test11() {

        assertArrayEquals(new Integer[]{0, 2, 0}, cal.calculator(10));
    }

    @Test
    public void test12() {
        assertArrayEquals(new Integer[]{0, 1, 2}, cal.calculator(11));
    }

    @Test
    public void test13() {

        assertArrayEquals(new Integer[]{1, 0, 1}, cal.calculator(12));
    }

    @Test
    public void test14() {

        assertArrayEquals(new Integer[]{1, 2, 0}, cal.calculator(19));
    }


}
