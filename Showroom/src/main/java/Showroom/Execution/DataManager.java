package Showroom.Execution;

import Showroom.Customer.Customer;
import Showroom.Customer.Interprise;
import Showroom.Employee.Employee;
import Showroom.Employee.Manager;
import Showroom.Employee.Saler;
import Showroom.Vehicle.Car;
import Showroom.Vehicle.Truck;
import Showroom.Vehicle.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    private final String SEP = ";";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final String vehicles_file_name = "vehicles.txt";
    private final String salers_file_name = "salers.txt";
    private final String managers_file_name = "managers.txt";
    private final String customers_file_name = "customers.txt";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;
    private ArrayList<Saler> salers;
    private ArrayList<Manager> managers;
    private ArrayList<Employee> employees;

    public DataManager() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.salers = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void load(String folder_name) {
        vehicles = this.loadVehicle(folder_name + "/" + vehicles_file_name);
        customers = this.loadCustomer(folder_name + "/" + customers_file_name);
        salers = this.loadSaler(folder_name + "/" + salers_file_name);
        managers = this.loadManager(folder_name + "/" + managers_file_name);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public ArrayList<Saler> getSalers() {
        return salers;
    }
    public ArrayList<Manager> getManagers() {
        return managers;
    }
    public void addVehicles(Vehicle vehicle){
        try(FileWriter writer = new FileWriter("src/Data/vehicles.txt",true)) {
            if (vehicle instanceof Car){
                writer.write("CAR"+SEP+vehicle.getManufacture()+SEP+vehicle.getPrice()+SEP+
                        vehicle.getMade_year()+SEP+vehicle.getColor()+SEP+vehicle.getTax()+SEP+
                        vehicle.getId()+SEP+((Car) vehicle).getSeats()+SEP+((Car) vehicle).getType());
                writer.write("\r\n");
            } else {
                writer.write("TRUCK"+SEP+vehicle.getManufacture()+SEP+vehicle.getPrice()+SEP+
                        vehicle.getMade_year()+SEP+vehicle.getColor()+SEP+vehicle.getTax()+SEP+
                        ((Truck) vehicle).getWeight()+SEP+((Truck) vehicle).getValid_year());
                writer.write("\r\n");
            }
        } catch (IOException e){
            System.out.println("Failed to add the vehicle due to an error: " + e.getMessage());
        }
        vehicles.add(vehicle);
        System.out.println("Successuflly added the vehicle!");
    }
    public void addManagers(Manager manager) {
        try (FileWriter writer = new FileWriter("src/Data/managers.txt",true);){
            ArrayList<String> ids = new ArrayList<>();
            for (Saler saler : manager.getList_of_saler()){
                ids.add(saler.getId());
            }
            writer.write("MANAGER"+SEP+manager.getId()+SEP+manager.getName()+SEP+
                    manager.getStart_date()+SEP+manager.getBased_salary()+SEP+
                    manager.getPromotion_date()+SEP+manager.getPosition_salary()+
                    SEP+ids);
            writer.write("\r\n");

        } catch (IOException e){
            System.out.println("Failed to add the employee due to an error: " + e.getMessage());
        }
        managers.add(manager);
        System.out.println("Successuflly added the employee!");
    }
    public void addSalers(Saler saler) {
        try(FileWriter writer = new FileWriter("src/Data/salers.txt",true);){
            writer.write("SALER"+SEP+saler.getId()+SEP+saler.getName()+SEP+
                    saler.getStart_date()+SEP+saler.getBased_salary()+SEP+
                    saler.getBonus_rate()+SEP+saler.getKPI());
            writer.write("\r\n");
        } catch (IOException e){
            System.out.println("Failed to add the employee due to an error: " + e.getMessage());
        }
        salers.add(saler);
        System.out.println("Successuflly added the saler!");
    }
    public void addCustomer(Customer customer) {
        try(FileWriter writer = new FileWriter("src/Data/customers.txt",true)) {
            if (customer instanceof Interprise){
                writer.write("INTERPRISE"+SEP+customer.getId()+SEP+
                        customer.getId_type()+SEP+customer.getName()+SEP+
                        customer.getAddress()+SEP+customer.getPhone()+SEP+((Interprise) customer).getTax_no()+SEP+
                        ((Interprise) customer).getDirector());
                writer.write("\r\n");
            } else {
                writer.write("INDIVIDUAL"+SEP+customer.getId()+SEP+
                        customer.getId_type()+SEP+customer.getName()+SEP+
                        customer.getAddress()+SEP+customer.getPhone());
                writer.write("\r\n");
            }
        } catch (IOException e){
            System.out.println("Failed to add the vehicle due to an error: " + e.getMessage());
        }
        customers.add(customer);
        System.out.println("Successuflly added the customer!");
    }
    private ArrayList<Vehicle> loadVehicle(String fname) {
        ArrayList<Vehicle> items = new ArrayList<>();
//        TO DO HERE
        try {
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 0)
                    items.add(loadFromStringVehicle(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
    private ArrayList<Customer> loadCustomer(String fname) {
        ArrayList<Customer> items = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                if (line.length() > 0 ){
                    items.add(loadFromStringCustomer(line));
                }
            }
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return items;
    }
    private ArrayList<Saler> loadSaler(String fname) {
        ArrayList<Saler> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    items.add(loadFromStringSaler(line));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
    private ArrayList<Manager> loadManager(String fname) {
        ArrayList<Manager> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.length() > 0) {
                    items.add(loadFromStringManager(line));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
    public void order(Order order){
      try(FileWriter writer = new FileWriter("src/Data/Transaction.txt",true)){
          writer.write(order.getCustomer().getId()+SEP+order.getManager().getId()+SEP+
                            order.getSaler().getId()+SEP+order.getVehicle().getId()+SEP+
                            order.getSell_date()+SEP+order.getStatus());
      }catch (IOException e){
          System.out.println("Failed to add the vehicle due to an error: " + e.getMessage());
      }

    }
    //    SUPPORT TO SAVE/LOAD FILE
    public Vehicle loadFromStringVehicle(String line) {
        String[] content = line.split(SEP);
        Vehicle v = null;
        if (content.length == 9) {
            String objType = content[0];
            if (objType.equals("TRUCK")) {
                v = new Truck(content[1],
                        Double.parseDouble(content[2]),
                        Integer.parseInt(content[3]),
                        content[4],
                        content[6],
                        Double.parseDouble(content[7]),
                        Integer.parseInt(content[8]));
            } else {
                v = new Car(content[1],
                        Double.parseDouble(content[2]),
                        Integer.parseInt(content[3]),
                        content[4],
                        content[6],
                        Integer.parseInt(content[7]),
                        Car.carTypes.valueOf(content[8]));
            }
        }

        return v;
    }
    public Saler loadFromStringSaler(String line){
        String[] content = line.split(SEP);
        Saler e = null;
        try {
            String objType = content[0];
            if (objType.equals("SALER")) {
                e = new Saler(content[1],
                        content[2],
                        dateFormat.parse(content[3]),
                        Double.parseDouble(content[4]),
                        Double.parseDouble(content[5]),
                        Double.parseDouble(content[6]));
            }
        } catch (ParseException ex) {
            System.out.println("Error parsing date for employee: " + line + ". Error: " + ex.getMessage());
        }
        return e;
    }
    public Manager loadFromStringManager(String line){
        String[] content = line.split(SEP);
        Manager e = null;
        try {
            String objType = content[0];
            if (objType.equals("MANAGER")) {
                content[7] = content[7].substring(1, content[7].length() - 1); // Remove brackets
                String[] salerIds = content[7].split(",");
                ArrayList<Saler> obj_saler = new ArrayList<>();
                for (String id: salerIds){
                    obj_saler.add(searchSaler(id.trim()));
                }
                e = new Manager(content[1],
                        content[2],
                        dateFormat.parse(content[3]),
                        Double.parseDouble(content[4]),
                        dateFormat.parse(content[5]),
                        Double.parseDouble(content[6]),
                        obj_saler);
            }
        } catch (ParseException ex) {
            System.out.println("Error parsing date for employee: " + line + ". Error: " + ex.getMessage());
        }
        return e;
    }
    public Customer loadFromStringCustomer(String line){
        String[] content = line.split(SEP);
        Customer c = null;
        String objType = content[0];
        if (objType.equals("INDIVIDUAL")) {
            c = new Customer(content[1],
                    Customer.identityType.valueOf(content[2]),
                    content[3],
                    content[4],
                    content[5]);
        } else {
            c = new Interprise(content[1],
                    content[3],
                    content[4],
                    content[5],
                    content[6],
                    content[7]);
        }
        return c;
    }
    public Saler searchSaler(String id_saler){
        for (Saler saler : salers){
            if (saler.getId().equals(id_saler)){
                return saler;
            }
        }
        return null;
    }
    public Manager searchManagerByName(String name){
        for (Manager m : managers){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }
    public Vehicle searchVehicleById(String id){
        for (Vehicle vehicle : vehicles){
            if (vehicle.getId().equals(id)){
                return vehicle;
            }
        }
        return null;
    }
    public Customer searchCustomerById(String id){
        for (Customer c : customers){
            if (c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
}