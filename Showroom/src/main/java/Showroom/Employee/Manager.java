package Showroom.Employee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee {
    private Date promotion_date;
    private ArrayList<Saler> list_of_saler ;
    private double position_salary;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Manager(String id, String name, Date start_date, double based_salary, Date promotion_date, double position_salary, ArrayList<Saler> list_of_saler) {
        super(id, name, start_date, based_salary);
        this.promotion_date = promotion_date;
        this.list_of_saler = list_of_saler;
        this.position_salary = position_salary;
    }

    public String getPromotion_date() {
        String date = dateFormat.format(promotion_date);
        return date;
    }

    public void setPromotion_date(Date promotion_date) {
        this.promotion_date = promotion_date;
    }

    public ArrayList<Saler> getList_of_saler() {
        return list_of_saler;
    }

    public void setList_of_saler(ArrayList<Saler> list_of_saler) {
        this.list_of_saler = list_of_saler;
    }

    public double getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(double position_salary) {
        this.position_salary = position_salary;
    }

    public double getSalary(){
        return super.getBased_salary() + this.position_salary;
    }
    public double getSalary(double bonus){
        return getSalary() + bonus;
    }
    @Override
    public String toString() {
        ArrayList<String> list_of_id_salers = new ArrayList<>();
        for (Saler saler : list_of_saler){
            list_of_id_salers.add(saler.getId());
        }
        return  "Manager{" +
                super.toString() +
                ", promotion_date=" + dateFormat.format(promotion_date) +
                ", list_of_saler=" + list_of_id_salers +
                '}';
    }
}
