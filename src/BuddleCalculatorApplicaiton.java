import exception.CustomizedException;
import model.LineItem;
import model.Order;
import org.apache.log4j.Logger;
import service.*;

import java.util.ArrayList;

public class BuddleCalculatorApplicaiton {

    private static final Logger logger = Logger.getLogger(BuddleCalculatorApplicaiton.class);
    public static void main(String[] args){
        GetSubmission gs = new GetSubmission();
        //get submission information from a file
        gs.getInformation("D:\\ajava\\22.txt");

        GetOrder go = new GetOrder();
        //get order information from a file
        Order order = null;
        try {
            order = go.readOrder("D:\\ajava\\33.txt",gs.getAll());
        } catch (CustomizedException e) {
            e.fileNotExist();
        }

        ArrayList<FilledLineItem> list = new ArrayList<>();
        for (LineItem e:order.getOrder()
             ) {
            FilledLineItem fli = new FilledLineItem(e,new LineItemBundleCalculator(e).calculateLineItem());
            list.add(fli);
        }
        FilledOrder fo = new FilledOrder(list);
        //output

        logger.info("\n"+fo.getTotalOrder());

    }
}
