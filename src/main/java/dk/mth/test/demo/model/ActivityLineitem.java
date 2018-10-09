package dk.mth.test.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityLineitem {


    private int id;
    private String activity;
    private int capacity;
    private Date dateStart;
    private Date dateEnd;
    public List<Booking> bookingList = new ArrayList();

    public ActivityLineitem(int id, String activity, int capacity, Date dateStart, Date dateEnd) {
        this.id = id;
        this.activity = activity;
        this.capacity = capacity;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
