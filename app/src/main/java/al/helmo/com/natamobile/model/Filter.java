package al.helmo.com.natamobile.model;

public class Filter {

    private int limitMin;
    private int limitMax;
    private String text;


    public Filter(int limitMin, int limitMax, String text){
        setLimitMin(limitMin);
        setLimitMax(limitMax);
        setText(text);
    }

    public int getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(int limitMin) {
        this.limitMin = limitMin;
    }

    public int getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(int limitMax) {
        this.limitMax = limitMax;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
