package Models.Product;

import java.util.Date;

public class Snack extends Product {
    private int calories;
    private String material;
    private Date valid_date;

    public Snack(String pid, String name, String origin, String maf_date, String supplier,
                 double price, int calories, String material, Date valid_date) {
        super(pid, name, origin, maf_date, supplier, price);
        this.calories = calories;
        this.material = material;
        this.valid_date = valid_date;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Date getValid_date() {
        return valid_date;
    }

    public void setValid_date(Date valid_date) {
        this.valid_date = valid_date;
    }

    @Override
    public String toString() {
        return "Snack{" +
                super.toString() +
                ", calories=" + calories +
                ", material='" + material + '\'' +
                ", valid_date=" + valid_date +
                '}';
    }
}
