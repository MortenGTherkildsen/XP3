package dk.mth.test.demo.model;

public class Booking {

    private String id;
    private String customerId;
    private String price;
    private int people; //Number of people who are booking

    public Booking(String id, String customerId, String price, int people) {
        this.id = id;
        this.customerId = customerId;
        this.price = price;
        this.people = people;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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
