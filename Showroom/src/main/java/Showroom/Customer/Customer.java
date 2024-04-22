package Showroom.Customer;

public class Customer {
    public static enum identityType {CCCD,GPKD,PASSPORT,GPLX};
    private String id;
    private identityType id_type;
    private String name;
    private String address;
    private String phone;

    public Customer(String id, identityType id_type, String name, String address, String phone) {
        this.id = id;
        this.id_type = id_type;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public identityType getId_type() {
        return id_type;
    }

    public void setId_type(identityType id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", id_type=" + id_type +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'';
    }
}

