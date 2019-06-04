package service;


import exception.FileNotExist;
import model.*;
import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderReader {

    /*read order information from a file*/


    public Order readOrder(String path, List<MediaType> mt) throws FileNotExist {
        List<LineItem> li = new ArrayList<>();
        try (FileReader fr = new FileReader(new File(path)); BufferedReader br = new BufferedReader(fr)) {
            for (String line; (line = br.readLine()) != null; ) {
                li.add(getLineItem(line, mt));
            }
            return new Order(li);
        } catch (IOException e) {
            if (!new File(path).exists())
                throw new FileNotExist(path + " dose not correct!", e);
        }

        return null;
    }

    private LineItem getLineItem(String li, List<MediaType> mt) {
        String[] part = li.trim().split(" ");
        int num = Integer.parseInt(part[0]);
        for (MediaType e : mt) {
            //judge and find out the mediaType of this lineItem
            if (e.getFormat().toLowerCase().equals(part[1].toLowerCase())) {
                return new LineItem(num, e);
            }
        }
        return null;
    }



}
