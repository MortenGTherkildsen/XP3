package dk.mth.test.demo.model;

import dk.mth.test.demo.model.Activity;
import dk.mth.test.demo.model.ActivityLineitem;
import dk.mth.test.demo.model.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityLineitemController {

    public List<ActivityLineitem> activityLineitemList;

    public ActivityLineitemController() {
        activityLineitemList = new ArrayList<>();

        for (Activity activity:ActivityController.activityList) {

            for (int j = 0; j < 30; j++) {

                for (int i = 0; i < 13; i++) {

                    Date date = new Date();

                    date.setHours(7+i);
                    date.setMinutes(0);
                    date.setSeconds(0);
                    date.setDate(date.getDate() + j);

                    Date dateEnd = date;
                    dateEnd.setHours(date.getHours() + 1);

                    createActivity(activity.getId(), date, dateEnd);
                }

            }
        }

    }

    public boolean createActivity(String activityId, Date dateStart, Date dateEnd) {

        int newId = 1;
        int id;

        Activity activityVar = ActivityController.getActivity(activityId);

        if (activityVar == null) {return false;}


        String activity = activityVar.getActivity();
        int capacity = activityVar.getCapacity();

        if (activityLineitemList.size() > 0) {
            id = activityLineitemList.get(activityLineitemList.size()-1).getId();
        } else {id = 0;}

        if (id != 0) {
            id++;
        }


        activityLineitemList.add(new ActivityLineitem(newId,activity,capacity,dateStart,dateEnd));
        return true;

    }

    public void readActivityLineitems() {
        for (ActivityLineitem activityLineitem:activityLineitemList) {
            //System.out.println(activityLineitem.getActivity());
            System.out.println(activityLineitem.getDateStart());
        }
    }

    public  ActivityLineitem getActivityLineitem (int id) {

        for (ActivityLineitem activityLineitem: activityLineitemList) {
            if (activityLineitem.getId() == id) {
                return activityLineitem;
            }
        }
        return null;
    }

    /*
    public void updateActivity(String activity, int capacity, String id) {
        //insert code here
    }
    */

    public void deleteActivityLineItem(int id) {

        for (ActivityLineitem activityLineitem:activityLineitemList) {

            if (activityLineitem.getId() == id) {
                activityLineitemList.remove(activityLineitem);
                break;
            }
        }
    }

    public List<ActivityLineitem> getListFromDate (String activityId, Date dateFrom, Date dateTo) {

        List<ActivityLineitem> returnList = new ArrayList<>();

        for (ActivityLineitem activityLineItem:activityLineitemList) {

            if (activityLineItem.getDateStart().after(dateFrom) && activityLineItem.getDateStart().before(dateTo)
                    && activityLineItem.getActivity().equals(ActivityController.getActivity(activityId).getActivity()) ) {

                returnList.add(activityLineItem);

            }
            if (activityLineItem.getDateStart().after(dateTo)
                    && activityLineItem.getActivity().equals(ActivityController.getActivity(activityId).getActivity())) {
                break;
            }
        }

        return returnList;
    }

    /*public boolean addBooking(int bookingId, int lineitemId) {

        Booking foundBooking = null;
        ActivityLineitem activityLineitem = null;

        try{
        foundBooking = BookingController.getBooking(bookingId);}
        catch (NullPointerException e){}

        try{
        activityLineitem = getActivityLineitem(lineitemId);}
        catch (NullPointerException e) {}

        if (foundBooking == null || activityLineitem == null) {return false;}

        activityLineitem.bookingList.add(foundBooking);
        return true;
    }*/

    public void readBookings(int lineitemId) {

        for (ActivityLineitem activityLineitem:activityLineitemList) {
            if (activityLineitem.getId() == lineitemId) {
                for (Booking booking:activityLineitem.bookingList) {
                    System.out.println(booking.getId());
                }
                break;
            }
        }
    }

    public void updateBooking(String something) {
        //hello
    }

    public boolean deleteBooking(int bookingId, int lineitemId) {

        ActivityLineitem activityLineitem = getActivityLineitem(lineitemId);

        for (Booking booking:activityLineitem.bookingList) {

            if (booking.getId() == bookingId) {
                activityLineitem.bookingList.remove(booking);
                return true;
            }
        }
        return false;
    }
    
    public int calculateCapacity(int id) {

        ActivityLineitem activityLineitem = getActivityLineitem(id);

        int finalNumber = activityLineitem.getCapacity();

        for (Booking booking:activityLineitem.bookingList) {
            finalNumber = finalNumber-booking.getPeople();
        }
        return finalNumber;
    }

}
