package dk.mth.test.demo.model;

public class Activity {

    String activity;
    int capacity;
    String id;

    public Activity(String activity, int capacity, String id) {
        this.activity = activity;
        this.capacity = capacity;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
