package test;

import exception.FileNotExist;
import model.Order;
import org.junit.Before;
import org.junit.Test;
import service.OrderReader;
import service.SubmissionReader;

import static org.junit.Assert.*;

public class OrderReaderTest {
    private OrderReader or;
    private SubmissionReader sr;

    @Before
    public void setUp() {
        sr = new SubmissionReader();
        or = new OrderReader();
    }

    @Test
    public void readOrder() {
        sr.getInformation("D:\\ajava\\22.txt");

        try {
            Order order = or.readOrder("D:\\ajava\\33.txt", sr.getAll());
            assertEquals(13, order.getOrder().get(0).getNum());
            assertEquals(13, order.getOrder().get(1).getNum());
            assertEquals(11, order.getOrder().get(2).getNum());
            assertEquals("IMG", order.getOrder().get(0).getMediaType().getFormat());
            assertEquals("Flac", order.getOrder().get(1).getMediaType().getFormat());
            assertEquals("VID", order.getOrder().get(2).getMediaType().getFormat());

        } catch (FileNotExist fileNotExist) {
            fileNotExist.printStackTrace();
        }

    }
}