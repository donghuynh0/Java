package Showroom.Vehicle;

public class Truck extends Vehicle {

     private double weight;
     private int valid_year;

    public Truck(String manufacture, double price, int made_year, String color, String id,
                 double weight, int valid_year) {
        super(manufacture, price, made_year, color,5,id);
        this.weight = weight;
        this.valid_year = valid_year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getValid_year() {
        return valid_year;
    }

    public void setValid_year(int valid_year) {
        this.valid_year = valid_year;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                ", weight=" + weight +
                ", valid_year=" + valid_year +
                '}';
    }
}
