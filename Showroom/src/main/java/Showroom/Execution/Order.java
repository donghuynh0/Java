package Showroom.Execution;

import Showroom.Customer.Customer;
import Showroom.Employee.Manager;
import Showroom.Employee.Saler;
import Showroom.Vehicle.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private static enum OrderStatus {Pendding,Ready,Completed}
    private Customer customer;
    private Saler saler;
    private Manager manager;
    private Vehicle vehicle;
    private Date sell_date;
    private double real_price;
    private OrderStatus status;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Order(Customer customer, Saler saler, Manager manager, Vehicle vehicle, Date sell_date, double real_price) {
        this.customer = customer;
        this.saler = saler;
        this.manager = manager;
        this.vehicle = vehicle;
        this.sell_date = sell_date;
        this.real_price = real_price;
        this.status = OrderStatus.Pendding;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Saler getSaler() {
        return saler;
    }

    public Manager getManager() {
        return manager;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSell_date() {
        String date = dateFormat.format(sell_date);
        return date;
    }

    public double getReal_price() {
        return real_price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // don't supply cusotmer and manager
    public void approve() throws Exception{
        if (manager == null){
            throw new Exception("Please!, specify Who is approving.");
        }
        status = OrderStatus.Ready;
    }
    public void delivery() throws  Exception{
        if (customer == null){
            throw new Exception("Please!, specify who is buying.");
        }
        status = OrderStatus.Completed;
    }
    //supply customer and manager
    public void approve(Manager m){
        manager = m;
        status = OrderStatus.Ready;
    }
    public void delivery(Customer c){
        customer  = c;
        status = OrderStatus.Completed;
    }
}
