package test;

import org.junit.Before;
import org.junit.Test;
import service.SubmissionReader;


import static org.junit.Assert.assertEquals;

public class SubmissionReaderTest {
    private SubmissionReader sr;

    @Before
    public void setUp() throws Exception {


        sr = new SubmissionReader();

    }

    @Test
    public void getInformation() {

        String path = "D:\\ajava\\22.txt";
        sr.getInformation(path);
        assertEquals("IMG", sr.getAll().get(0).getFormat());
        assertEquals("Flac", sr.getAll().get(1).getFormat());
        assertEquals("VID", sr.getAll().get(2).getFormat());
        assertEquals(5, sr.getAll().get(0).getBundles().get(0).getNum());
        assertEquals(10, sr.getAll().get(0).getBundles().get(1).getNum());
        assertEquals(3, sr.getAll().get(1).getBundles().get(0).getNum());
        assertEquals(6, sr.getAll().get(1).getBundles().get(1).getNum());
        assertEquals(9, sr.getAll().get(1).getBundles().get(2).getNum());


    }
}