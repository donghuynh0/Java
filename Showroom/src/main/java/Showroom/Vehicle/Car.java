package Showroom.Vehicle;

public class Car extends Vehicle {
    public static enum carTypes{Van,Sedan,SUV}
    private int seats;
    private carTypes type;

    public Car(String manufacture, double price, int made_year, String color, String id, int seats, carTypes type) {
        super(manufacture, price, made_year, color,10,id);
        this.seats = seats;
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public carTypes getType() {
        return type;
    }

    public void setType(carTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString()+
                ", seats=" + seats +
                ", type=" + type +
                '}';
    }
}
