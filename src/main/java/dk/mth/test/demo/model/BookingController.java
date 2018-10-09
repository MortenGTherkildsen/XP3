package dk.mth.test.demo.model;

import dk.mth.test.demo.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    public List<Booking> bookingList;

    public BookingController () {
        bookingList = new ArrayList<>();
    }

    public int getNextBookingNumber(){
        int nextBookingNumber;

        if (bookingList.size() > 0) {

            nextBookingNumber = bookingList.size()+1;
        } else {nextBookingNumber = 1;}
        return nextBookingNumber;
    }


    public void createBooking(int customerId, String price, int people) {

        int id = getNextBookingNumber();


        bookingList.add(new Booking(id,customerId,price,people));
    }

    public void readActivities() {
        for (Booking booking:bookingList) {
            System.out.println(booking.getId());
        }
    }

    public  Booking getBooking(int id) {

        for (Booking booking: bookingList) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    public void updateBooking(String booking, int capacity, int id) {
        //insert code here
    }

    public void deleteBooking(int id) {

        for (Booking booking:bookingList) {
            if (booking.getId() == id) {
                bookingList.remove(booking);
                break;
            }
        }
    }

}