package Showroom.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private Date start_date;
    private double based_salary;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Employee(String id, String name, Date start_date, double based_salary) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.based_salary = based_salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        String date = dateFormat.format(start_date);
        return date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public double getBased_salary() {
        return based_salary;
    }

    public void setBased_salary(double based_salary) {
        this.based_salary = based_salary;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", start_date=" + dateFormat.format(start_date) +
                ", based_salary=" + based_salary;
    }
}
