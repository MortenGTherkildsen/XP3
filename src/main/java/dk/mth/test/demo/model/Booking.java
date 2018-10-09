package dk.mth.test.demo.model;

public class Booking {

    private int id;
    private int customerId;
    private String price;
    private int people; //Number of people who are booking

    public Booking(int id, int customerId, String price, int people) {
        this.id = id;
        this.customerId = customerId;
        this.price = price;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
