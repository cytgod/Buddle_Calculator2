package model;

public class LineItem {
    private int num;
    private MediaType mediaType;

    public LineItem(int num, MediaType mediaType) {
        this.num = num;
        this.mediaType = mediaType;
    }

    public String toString(){
        return num+" "+mediaType.getFormat();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }


}
