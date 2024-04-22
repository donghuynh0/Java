package Models.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private String pid;
    private String name;
    private String origin;
    private Date maf_date;
    private String supplier;
    private double price;
    public Product(String pid, String name, String origin, String maf_date, String supplier, double price) {
        this.pid = pid;
        this.name = name;
        this.origin = origin;
        this.maf_date = convertStringToDate(maf_date);
        this.supplier = supplier;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getMaf_date() {
        return maf_date;
    }

    public void setMaf_date(Date maf_date) {
        this.maf_date = maf_date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", maf_date=" + formatter.format(maf_date) +
                ", supplier='" + supplier + '\'' +
                ", price=" + price ;
    }

    private Date convertStringToDate(String dateString) {
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Handle the case where date conversion might fail
        }
    }
}
