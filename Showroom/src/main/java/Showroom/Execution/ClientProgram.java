package Showroom.Execution;

import Showroom.Customer.Customer;
import Showroom.Customer.Interprise;
import Showroom.Employee.Manager;
import Showroom.Employee.Saler;
import Showroom.Vehicle.Car;
import Showroom.Vehicle.Truck;
import Showroom.Vehicle.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ClientProgram {
    public static boolean conditional = true;
    public static Scanner sc  = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public  static DataManager manager = new DataManager();
    public static void main(String[] args) throws Exception {
        manager.load("/Users/myainguyen/Downloads/huynhdong/CS206V/Showroom/src/main/java/Data");

        printOptiontTable();
        while(conditional) {
            System.out.print("Enter your choice(1-8): ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addVehicle();
                        printOptiontTable();
                        break;
                    case 2:
                        addEmployee();
                        printOptiontTable();
                        break;
                    case 3:
                        addCustomer();
                        printOptiontTable();
                        break;
                    case 4:
                        purchaseVehicle();
                        printOptiontTable();
                        break;
                    case 5:
                        Exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1-8).");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (1-8).");
                sc.nextLine();
            }
        }
    }
    public static void addVehicle(){
        System.out.println("Type of vehicle that you want to add");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.print("Your type of vehicle is: ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Manufacture: ");
        String manufacture = sc.nextLine();
        System.out.print("Color: ");
        String color = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Made_year: ");
        int made_year = sc.nextInt();
        if (type == 1){
            System.out.print("Seats: ");
            int seats = sc.nextInt();
            sc.nextLine();
            System.out.println("Type of car: ");
            System.out.println("1. Van");
            System.out.println("2. Sedan");
            System.out.println("3. SUV");
            System.out.print("Your type of car is: ");
            int car_type = sc.nextInt();
            sc.nextLine();
            String typeOfCar = null;
            switch (car_type){
                case 1:
                    typeOfCar = "Van";
                    break;
                case 2:
                    typeOfCar = "Sedan";
                    break;
                default:
                    typeOfCar = "SUV";
                    break;
            }
            manager.addVehicles(new Car(manufacture,price,made_year,color,id,seats,Car.carTypes.valueOf(typeOfCar)));
        }else {
            System.out.print("Weight: ");
            double weight = sc.nextDouble();
            System.out.print("Valid_year: ");
            int valid_year = sc.nextInt();
            manager.addVehicles(new Truck(manufacture,price,made_year,color,id,weight,valid_year));
        }

    }
    public static void addEmployee() {
        System.out.println("Type of employee that you want to add");
        System.out.println("1. Saler");
        System.out.println("2. Manager");
        System.out.print("Your type of employee is: ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Start date (yyyy-MM-dd): ");
        String date = sc.nextLine();
        System.out.print("Based-salary: ");
        double basedSalary = sc.nextDouble();
        if (type == 1){
            System.out.print("Bonus rate: ");
            double rate = sc.nextDouble();
            System.out.print("KPI: ");
            double KPI = sc.nextDouble();
            try{
                manager.addSalers(new Saler(id,name,dateFormat.parse(date),basedSalary,rate,KPI));
            }catch (ParseException ex) {
                System.out.println("Error parsing date. Error: " + ex.getMessage());
            }
        }else {
            sc.nextLine();
            System.out.print("Promotion date (yyyy-MM-dd): ");
            String pr_date = sc.nextLine();
            System.out.print("Position_salary: ");
            double po_salary = sc.nextDouble();
            sc.nextLine();
            System.out.println("List of id_salers in showroom");
            int num = 1;
            for (Saler saler : manager.getSalers()){
                System.out.println(num+". "+saler.getId());
                num += 1;
            }
            System.out.println("Which saler does the manager own ?");
            System.out.print("Id_Salers: ");
            String id_salers = sc.nextLine();
            String[] list_of_id_salers = id_salers.split(" ");
            ArrayList<Saler> list_of_salers = new ArrayList<>();
            for (String id_saler : list_of_id_salers){
                list_of_salers.add(manager.searchSaler(id_saler.trim()));
            }
            try{
                manager.addManagers(new Manager(id,name,dateFormat.parse(date),basedSalary,
                        dateFormat.parse(pr_date),po_salary,list_of_salers));
            }catch (ParseException ex) {
                System.out.println("Error parsing date. Error: " + ex.getMessage());
            }
        }
    }
    public static void addCustomer(){
        System.out.println("Type of customer that you want to add");
        System.out.println("1. Individual");
        System.out.println("2. Interprise");
        System.out.print("Your type of customer is: ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        if (type == 1){
            System.out.println("Type of identity:");
            System.out.println("1. CCCD");
            System.out.println("2. GPKD");
            System.out.println("3. GPLX");
            System.out.println("4. PASSPORT");
            System.out.print("Your type of identity is: ");
            int id_type = sc.nextInt();
            sc.nextLine();
            String typeOfIdentity = null;
            switch (id_type){
                case 1:
                    typeOfIdentity = "CCCD";
                    break;
                case 2:
                    typeOfIdentity = "GPKD";
                    break;
                case 3:
                    typeOfIdentity = "GPLX";
                    break;
                default:
                    typeOfIdentity = "PASSPORT";
                    break;
            }
            manager.addCustomer(new Customer(id,Customer.identityType.valueOf(typeOfIdentity),name,address,phone));
        }else {
            System.out.print("Tax no: ");
            String tax_no = sc.nextLine();
            System.out.print("Director name: ");
            String dir_name = sc.nextLine();
            manager.addCustomer(new Interprise(id,name,address,phone,tax_no,dir_name));
        }

    }
    public static void purchaseVehicle() throws Exception {
        System.out.println("Are you a new customer or not ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Your choice: ");
        int new_cus = sc.nextInt();
        sc.nextLine();
        if (new_cus == 1){
            System.out.print("Name: ");
            String name  = sc.nextLine();
            System.out.print("Id: ");
            String id = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            System.out.println("Are you a individual or interprise ?");
            System.out.println("1. Individual");
            System.out.println("2. Interprise");
            System.out.print("Your choice: ");
            int typeofCustomer = sc.nextInt();
            String typeOfIdentity = null;
            sc.nextLine();
            if (typeofCustomer == 1){
                System.out.println("Which is your type of identity ?");
                System.out.println("1. CCCD");
                System.out.println("2. GPKD");
                System.out.println("3. GPLX");
                System.out.println("4. PASSPORT");
                System.out.print("Your choice: ");
                int type_id = sc.nextInt();
                sc.nextLine();
                switch (type_id){
                    case 1:
                        typeOfIdentity = "CCCD";
                        break;
                    case 2:
                        typeOfIdentity = "GPKD";
                        break;
                    case 3:
                        typeOfIdentity = "GPLX";
                        break;
                    default:
                        typeOfIdentity = "PASSPORT";
                        break;
                }
                manager.addCustomer(new Customer(id,Customer.identityType.valueOf(typeOfIdentity),name,address,phone));
                makeContact(new Customer(id,Customer.identityType.valueOf(typeOfIdentity),name,address,phone));
            }else {
                System.out.print("Tax no: ");
                String tax_no = sc.nextLine();
                System.out.print("Director name: ");
                String dir_name = sc.nextLine();
                makeContact(new Interprise(id,name,address,phone,tax_no,dir_name));
            }

        }else {
            System.out.println("List of customers of my showroom");
            int count = 1;
            for (Customer customer : manager.getCustomers()){
                System.out.println(count+". "+customer.getId());
                count += 1;
            }
            System.out.print("Enter your customer id: ");
            String your_id = sc.nextLine();
            makeContact(manager.searchCustomerById(your_id));
        }

    }
    public static void makeContact(Customer c) throws Exception {
        System.out.println("There are managers in showroom");
        int count = 1;
        for (Manager m : manager.getManagers()){
            System.out.println(count+". "+m.getName());
            count += 1;
        }
        System.out.println("Manager that you want to guide you purchase vehicle");
        System.out.print("Enter manager name: ");
        String m_choi = sc.nextLine();
        Manager chose_m = manager.searchManagerByName(m_choi);
        System.out.println("List of saler of "+chose_m.getName());
        count = 1;
        for (Saler saler : chose_m.getList_of_saler()){
            System.out.println(count+". "+saler.getId());
            count += 1;
        }
        System.out.print("Enter saler id: ");
        String id_saler = sc.nextLine();
        Saler chose_s = manager.searchSaler(id_saler);
        System.out.println("Type of vehicle that you want to buy");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.print("Your choice: ");
        int veh_type = sc.nextInt();
        sc.nextLine();
        Vehicle chose_vehi = null;
        if (veh_type == 1){
            Set<String> setOfVehicle = new HashSet<>();
            for (Vehicle vehicle : manager.getVehicles()){
                if (vehicle instanceof Car){
                    setOfVehicle.add(String.valueOf(((Car) vehicle).getType()));
                }
            }
            System.out.println("__There are several type of cars");
            count = 1;
            for (String car_type : setOfVehicle){
                System.out.println(count+". "+car_type);
                count += 1;
            }
            System.out.print("Enter type of car that you want to buy: ");
            String car_type = sc.nextLine();
            System.out.println("Manufacture \t Type of car \t Real price \t Car id");
            for (Vehicle vehicle : manager.getVehicles()){
                if (vehicle instanceof Car){
                    double realPrice = vehicle.getPrice() + vehicle.getPrice()*(vehicle.getTax()/100);
                    if (String.valueOf(((Car) vehicle).getType()).equals(car_type)){
                        System.out.println(vehicle.getManufacture()+" \t\t\t "+
                                ((Car) vehicle).getType() +" \t\t\t "+
                                realPrice+" \t\t\t "+
                                vehicle.getId());
                    }
                }
            }
            System.out.print("Enter car id that you want to buy: ");
            String chose_id = sc.nextLine();
            chose_vehi = (Car) manager.searchVehicleById(chose_id);
        }else {
            System.out.println("__There are several type of trucks");
            System.out.println("Manufacture \t Weight \t Valid year \t Real price \t Truck id");
            for (Vehicle vehicle : manager.getVehicles()){
                if (vehicle instanceof Truck){
                    double realPrice = vehicle.getPrice() + vehicle.getPrice()*(vehicle.getTax()/100);
                    System.out.println(vehicle.getManufacture() + " \t\t\t " +
                            ((Truck) vehicle).getWeight() + " \t\t\t " +
                            ((Truck) vehicle).getValid_year() + " \t\t\t " +
                            realPrice + " \t\t\t " +
                            vehicle.getId());
                }
            }
            System.out.print("Enter truck id that you want to buy: ");
            String chose_id = sc.nextLine();
            chose_vehi = (Truck) manager.searchVehicleById(chose_id);
        }
        double realPrice = chose_vehi.getPrice() + chose_vehi.getPrice()*(chose_vehi.getTax()/100);
        Order order = new Order(c,chose_s,chose_m,chose_vehi,new Date(),realPrice);
        System.out.println("Vertify this contact by "+chose_m.getName());
        System.out.println("1. Approve");
        System.out.println("2. Deny");
        System.out.print("Choice of "+chose_m.getName()+": ");
        int chose_vertify = sc.nextInt();
        if (chose_vertify == 1){
            order.approve();
            System.out.println("Do customer want to delivery this vehicle");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            int delivery = sc.nextInt();
            if (delivery == 1){
                order.delivery();
            }
        }
        manager.order(order);
    }
    public static void printOptiontTable() {
        System.out.println("+--------------+----------+---------+");
        System.out.println("|            Showroom               |");
        System.out.println("+--------------+----------+---------+");
        System.out.println("1. Add a new vehicle");
        System.out.println("2. Add a new employee");
        System.out.println("3. Add a new customer");
        System.out.println("4. Purchase vehicle");
        System.out.println("5. Exit");
        System.out.println("+--------------+----------+---------+");
    }
    public static void Exit() {
        conditional = false;
        System.out.println("The application is shutting down.....");
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
        }

    }
}

