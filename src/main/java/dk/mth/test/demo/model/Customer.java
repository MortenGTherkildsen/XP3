package dk.mth.test.demo.model;

import java.util.ArrayList;

public class Customer extends Person {

    private String customernumber = "";
    private ArrayList<Booking> bookingnumbers = new ArrayList<>();

    public Customer(String name, String birthdate, String email, String password, String customernumber, ArrayList<Booking> bookingnumbers) {
        super(name, birthdate, email, password);
        this.customernumber = customernumber;
        this.bookingnumbers = bookingnumbers;
    }

    public Customer(String name, String birthdate, String email, String password, String customernumber) {
        super(name, birthdate, email, password);
        this.customernumber = customernumber;
    }

    public Customer(String name, String birthdate, String email, String password, ArrayList<Booking> bookingnumbers) {
        super(name, birthdate, email, password);
        this.bookingnumbers = bookingnumbers;
    }

    public Customer(String name, String birthdate, String email, String password) {
        super(name, birthdate, email, password);
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public ArrayList<Booking> getBookingnumbers() {
        return bookingnumbers;
    }

    public void setBookingnumbers(ArrayList<Booking> bookingnumbers) {
        this.bookingnumbers = bookingnumbers;
    }

}
