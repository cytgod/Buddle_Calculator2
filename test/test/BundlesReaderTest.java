package test;

import model.Bundles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import service.BundlesReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BundlesReaderTest {
    private BundlesReader br;


    @Before
    public void setUp()  {
        br = new BundlesReader();
    }

    @Test
    public void parseBundlestest1() {
        String a = "4 @ $3543.21 7 @ $3534.1";
        List<Bundles> b = new ArrayList<>();
        b.add(new Bundles(4,"$",3543.21));
        b.add(new Bundles(7,"$",3534.1));
        assertEquals(b.toString(), br.parseBundles(a).toString());
    }


}