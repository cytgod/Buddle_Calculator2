package model;
import java.util.List;

public class MediaType {
    private final String name;
    private final String format;
    private final List<Bundles> bundles;

    public List<Bundles> getBundles() {
        return bundles;
    }


    public MediaType(String name, String format, List<Bundles> bundles) {
        this.name = name;
        this.format = format;
        this.bundles = bundles;
    }

    public String getFormat() {
        return format;
    }

    public Boolean removeBundles(Bundles b) {
        for (int i = 0; i < bundles.size(); ++i) {
            if (bundles.get(i).equals(b)==1) bundles.remove(i);
            return true;
        }
        return false;
    }


}
