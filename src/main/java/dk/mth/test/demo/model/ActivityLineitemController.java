package dk.mth.test.demo.model;

import dk.mth.test.demo.model.Activity;
import dk.mth.test.demo.model.ActivityLineitem;
import dk.mth.test.demo.model.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityLineitemController {

    public static List<ActivityLineitem> activityLineitemList;

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

        String newId = "1";
        String id;

        Activity activityVar = ActivityController.getActivity(activityId);

        if (activityVar == null) {return false;}


        String activity = activityVar.getActivity();
        int capacity = activityVar.getCapacity();

        if (activityLineitemList.size() > 0) {
            id = activityLineitemList.get(activityLineitemList.size()-1).getId();
        } else {id = "0";}

        if (!id.equalsIgnoreCase("0")) {
            int intID = Integer.parseInt(id);
            intID++;
            newId = "" + intID;
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

    public static ActivityLineitem getActivityLineitem (String id) {

        for (ActivityLineitem activityLineitem: activityLineitemList) {
            if (activityLineitem.getId().equalsIgnoreCase(id)) {
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

    public void deleteActivityLineItem(String id) {

        for (ActivityLineitem activityLineitem:activityLineitemList) {

            if (activityLineitem.getId().equalsIgnoreCase(id)) {
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

    public boolean addBooking(String bookingId, String lineitemId) {

        Booking foundBooking = BookingController.getBooking(bookingId);
        ActivityLineitem activityLineitem = getActivityLineitem(lineitemId);

        if (foundBooking == null || activityLineitem == null) {return false;}

        activityLineitem.bookingList.add(foundBooking);
        return true;
    }

    public void readBookings(String lineitemId) {

        for (ActivityLineitem activityLineitem:activityLineitemList) {
            if (activityLineitem.getId().equalsIgnoreCase(lineitemId)) {
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

    public boolean deleteBooking(String bookingId, String lineitemId) {

        ActivityLineitem activityLineitem = getActivityLineitem(lineitemId);

        for (Booking booking:activityLineitem.bookingList) {

            if (booking.getId().equalsIgnoreCase(bookingId)) {
                activityLineitem.bookingList.remove(booking);
                return true;
            }
        }
        return false;
    }

    public int calculateCapacity(String id) {

        ActivityLineitem activityLineitem = getActivityLineitem(id);

        int finalNumber = activityLineitem.getCapacity();

        for (Booking booking:activityLineitem.bookingList) {
            finalNumber = finalNumber-booking.getPeople();
        }
        return finalNumber;
    }


}
