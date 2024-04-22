package Showroom.Customer;

public class Interprise extends Customer {
    private String tax_no;
    private String director;

    public Interprise(String id, String name, String address, String phone, String tax_no, String director) {
        super(id, identityType.GPKD, name, address, phone);
        this.tax_no = tax_no;
        this.director = director;
    }

    public String getTax_no() {
        return tax_no;
    }

    public void setTax_no(String tax_no) {
        this.tax_no = tax_no;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return super.toString() +
                " tax_no='" + tax_no + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
