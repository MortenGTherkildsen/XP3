package dk.mth.test.demo.model;

import dk.mth.test.demo.model.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    public static List<Activity> activityList = new ArrayList<>();

    public void createActivity(String activity, int capacity) {

        String newId = "1";
        String id;

        if (activityList.size() > 0) {
            id = activityList.get(activityList.size()-1).getId();
        } else {id = "0";}


        if (!id.equalsIgnoreCase("0")) {
            int intID = Integer.parseInt(id);
            intID++;
            newId = "" + intID;
        }
        activityList.add(new Activity(activity,capacity,newId));
    }

    public void readActivities() {
        for (Activity activity:activityList) {
            System.out.println(activity.getId());
        }
    }

    public static Activity getActivity (String id) {

        for (Activity activity: activityList) {
            if (activity.getId().equalsIgnoreCase(id)) {
                return activity;
            }
        }
        return null;
    }

    public void updateActivity(String activity, int capacity, String id) {
        //insert code here
    }

    public void deleteActivity(String id) {

        for (Activity activity:activityList) {
            if (activity.getId().equalsIgnoreCase(id)) {
                activityList.remove(activity);
                break;
            }
        }
    }

}
