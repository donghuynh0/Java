package Showroom.Vehicle;

public class Vehicle {
    private String manufacture;
    private double price;
    private int made_year;
    private String color;
    private int tax;
    private String id;
    public Vehicle(String manufacture, double price, int made_year, String color,int tax,String id) {
        this.manufacture = manufacture;
        this.price = price;
        this.made_year = made_year;
        this.color = color;
        this.tax = tax;
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMade_year() {
        return made_year;
    }

    public void setMade_year(int made_year) {
        this.made_year = made_year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "manufacture='" + manufacture + '\'' +
                ", price=" + price +
                ", made_year=" + made_year +
                ", color='" + color + '\'' +
                ", tax=" + tax +
                ", id=" + id +
                '}';
    }
}


