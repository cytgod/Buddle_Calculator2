package model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;

public class MediaType {
    private String name;
    private String format;
    private ArrayList<Bundles> bundles;

    public ArrayList<Bundles> getBundles() {
        return bundles;
    }

    public void setBundles(ArrayList<Bundles> bundles) {
        this.bundles = bundles;
    }

    public MediaType(String name, String format, ArrayList<Bundles> bundles) {
        this.name = name;
        this.format = format;
        this.bundles = bundles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void addBundles(Bundles b) {
        bundles.add(b);
    }
    public Boolean removeBundles(Bundles b) {
        for (int i = 0; i < bundles.size(); i++) {
            if(bundles.get(i).equals(b)==1)
                bundles.remove(i);
            return true;
        }
        return false;
    }



}
