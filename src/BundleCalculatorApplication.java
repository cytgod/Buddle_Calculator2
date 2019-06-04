
import exception.FileNotExist;
import model.FilledLineItem;
import model.FilledOrder;
import model.LineItem;
import model.Order;
import org.apache.log4j.Logger;
import service.*;

import java.util.ArrayList;

public class BundleCalculatorApplication {

    private static final Logger logger = Logger.getLogger(BundleCalculatorApplication.class);

    public static void main(String[] args) {
        SubmissionReader gs = new SubmissionReader();
        //get submission information from a file
        gs.getInformation("D:\\ajava\\22.txt");

        OrderReader go = new OrderReader();
        //get order information from a file
        Order order = null;
        try {
            order = go.readOrder("D:\\ajava\\33.txt", gs.getAll());
        } catch (FileNotExist e) {
            e.printStackTrace();
        }

        ArrayList<FilledLineItem> list = new ArrayList<>();
        assert order != null;
        for (LineItem e : order.getOrder()
        ) {
            FilledLineItem fli = new FilledLineItem(e, new LineItemBundleCalculator(e).calculateLineItem());
            list.add(fli);
        }
        FilledOrder fo = new FilledOrder(list);
        //output

        logger.info("\n" + fo.getTotalOrder());

    }
}
