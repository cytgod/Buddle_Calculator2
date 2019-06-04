package service;

import model.MediaType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubmissionReader {
    private List<MediaType> all = new ArrayList<>();
    public List<MediaType> getAll() {
        return all;
    }

    public void getInformation(String path) {
        File file = new File(path);
        if (file.exists()) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                for (String line; (line = br.readLine()) != null; ) {
                    String[] s = line.trim().split("\\|");
                    all.add(new MediaType(s[0].trim(), s[1].trim(), BundlesReader.parseBundles(s[2].trim())));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
