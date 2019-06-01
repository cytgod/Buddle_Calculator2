package service;
import model.MediaType;

import java.io.*;
import java.util.ArrayList;

public class GetSubmission {
    private ArrayList<MediaType> all = new ArrayList<>();



    public ArrayList<MediaType> getAll(){
        return all;
    }
    public void getInformation(String path){

        File file = new File(path);
        if (GetOrder.checkExist(file)) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                for (String line; (line = br.readLine()) != null; ) {

                    String[] s = line.trim().split("\\|");
                    all.add(new MediaType(s[0].trim(),s[1].trim(),GetBundles.parseBundles(s[2].trim())));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
