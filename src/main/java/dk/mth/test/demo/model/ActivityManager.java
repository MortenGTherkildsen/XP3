package dk.mth.test.demo.model;

import java.util.ArrayList;

public class ActivityManager extends Manager {

    public ActivityManager(String name, String age, String email, String password, int managernumber, ArrayList<Shift> roster) {
        super(name, age, email, password, managernumber, roster);
    }

    public ActivityManager(String name, String age, String email, String password, int managernumber) {
        super(name, age, email, password, managernumber);
    }
}
