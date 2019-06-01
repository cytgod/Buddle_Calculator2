package service;

import exception.CustomizedException;
import model.*;
import model.Order;

import java.io.*;
import java.util.ArrayList;

public class GetOrder {

    /*read order information from a file*/


    public Order readOrder(String path,ArrayList<MediaType> mt) throws CustomizedException {
        ArrayList<LineItem> li = new ArrayList<>();
        File file = new File(path);
        if (checkExist(file)) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                for (String line; (line = br.readLine()) != null; ) {
                    String[] s = line.trim().split(" ");
                    int num = Integer.parseInt(s[0]);
                    for (MediaType e:mt){
                        if (e.getFormat().toLowerCase().equals(s[1].toLowerCase())){
                            li.add(new LineItem(num,e));
                        }
                    }
                }
                return new Order(li);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            throw new CustomizedException();
        }
        return null;
    }


    public static Boolean checkExist(File file) {
        if (file.exists()) {
            return true;
        } else {
            System.out.println("file not exists, create it ...");
            return false;
        }
    }
}
