package Models.Product;

import java.util.Date;

public class Pen extends Product{
    private String inkColor;
    private String penType;

    public Pen(String pid, String name, String origin, String maf_date, String supplier,
               double price,String inkColor, String penType) {
        super(pid, name, origin, maf_date, supplier,price);
        this.inkColor = inkColor;
        this.penType = penType;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType;
    }

    @Override
    public String toString() {
        return "Pen{" +
                super.toString() +
                ", inkColor='" + inkColor + '\'' +
                ", penType='" + penType + '\'' +
                '}';
    }
}
