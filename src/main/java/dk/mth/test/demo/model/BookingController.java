package dk.mth.test.demo.model;

import dk.mth.test.demo.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    public static List<Booking> bookingList;

    public BookingController () {
        bookingList = new ArrayList<>();
    }

    public int getNextBookingNumber(){
        int nextBookingNumber;
        if (bookingList.size() => 0) {
            nextBookingNumber = bookingList.size()+1;
        } else {nextBookingNumber = "1";}
        return nextBookingNumber;
    }


    public void createBooking(String customerId,String price, int people) {
    
        String newId = "1";
        String id;

        if (bookingList.size() > 0) {
            id = bookingList.get(bookingList.size()-1).getId();
        } else {id = "0";}


        if (!id.equalsIgnoreCase("0")) {
            int intID = Integer.parseInt(id);
            intID++;
            newId = "" + intID;
        }
        bookingList.add(new Booking(newId,customerId,price,people));
    }

    public static void createBooking(Booking booking) {

        String newId = "1";
        String id;

        if (bookingList.size() > 0) {
            id = bookingList.get(bookingList.size()-1).getId();
        } else {id = "0";}

        if (!id.equalsIgnoreCase("0")) {
            int intID = Integer.parseInt(id);
            intID++;
            newId = "" + intID;
        }
        booking.setId(newId);
        bookingList.add(booking);
    }

    public void readActivities() {
        for (Booking booking:bookingList) {
            System.out.println(booking.getId());
        }
    }

    public static Booking getBooking (String id) {

        for (Booking booking: bookingList) {
            if (booking.getId().equalsIgnoreCase(id)) {
                return booking;
            }
        }
        return null;
    }

    public void updateBooking(String booking, int capacity, String id) {
        //insert code here
    }

    public void deleteBooking(String id) {

        for (Booking booking:bookingList) {
            if (booking.getId().equalsIgnoreCase(id)) {
                bookingList.remove(booking);
                break;
            }
        }
    }

}