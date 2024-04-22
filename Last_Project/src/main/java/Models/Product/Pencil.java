package Models.Product;

import java.util.Date;

public class Pencil extends Product {
    private String hardNess;
    private boolean hasEraser;

    public Pencil(String pid, String name, String origin, String maf_date, String supplier,
                  double price,String hardNess, boolean hasEraser) {
        super(pid, name, origin, maf_date, supplier,price);
        this.hardNess = hardNess;
        this.hasEraser = hasEraser;
    }

    public String getHardNess() {
        return hardNess;
    }

    public void setHardNess(String hardNess) {
        this.hardNess = hardNess;
    }

    public boolean isHasEraser() {
        return hasEraser;
    }

    public void setHasEraser(boolean hasEraser) {
        this.hasEraser = hasEraser;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                super.toString() +
                ", hardNess='" + hardNess + '\'' +
                ", hasEraser=" + hasEraser +
                '}';
    }
}
