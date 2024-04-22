package Showroom.Employee;

import java.util.Date;

public class Saler extends Employee{
    private double bonus_rate;
    private double KPI; // smallest value/amount

    public Saler(String id, String name, Date start_date, double based_salary, double bonus_rate, double KPI) {
        super(id, name, start_date, based_salary);
        this.bonus_rate = bonus_rate;
        this.KPI = KPI;
    }

    public double getBonus_rate() {
        return bonus_rate;
    }

    public void setBonus_rate(double bonus_rate) {
        this.bonus_rate = bonus_rate;
    }

    public double getKPI() {
        return KPI;
    }

    public void setKPI(double KPI) {
        this.KPI = KPI;
    }

    public double getSalary(double income){
        return super.getBased_salary() + (Math.max(income - this.KPI,0)) * this.bonus_rate ;
    }

    @Override
    public String toString() {
        return  "Saler{" +
                super.toString() +
                ", bonus_rate=" + bonus_rate +
                ", KPI=" + KPI +
                '}';
    }
}
