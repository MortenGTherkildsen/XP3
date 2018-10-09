package dk.mth.test.demo.model;
import java.util.ArrayList;

public class Customer extends Person {

    private String customernumber = "";
    public ArrayList<Booking> bookingnumbers = new ArrayList<>();


    public Customer(String email, String password){
        super(email, password);
    }


    public Customer(String name, String birthdate, String email, String password,int id, ArrayList<Booking> bookingnumbers) {
        super(name, birthdate, email, password,id);
        this.bookingnumbers = bookingnumbers;
    }

    public Customer(String name, String birthdate, String email, String password,int id) {
        super(name, birthdate, email, password,id);
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public ArrayList<Booking> getBookingnumbers() {
        return this.bookingnumbers;
    }

    public void setBookingnumbers(ArrayList<Booking> bookingnumbers) {
        this.bookingnumbers = bookingnumbers;
    }

}