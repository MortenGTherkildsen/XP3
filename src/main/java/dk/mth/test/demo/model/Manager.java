package dk.mth.test.demo.model;

import java.util.ArrayList;

public class Manager extends Person {

    private String managernumber = "";
    private ArrayList<Shift> roster = new ArrayList<>();

    public Manager(String name, String age, String email, String password, String managernumber, ArrayList<Shift> roster) {
        super(name, age, email, password);
        this.managernumber = managernumber;
        this.roster = roster;
    }

    public String getManagernumber() {
        return managernumber;
    }

    public void setManagernumber(String managernumber) {
        this.managernumber = managernumber;
    }

    public ArrayList<Shift> getRoster() {
        return roster;
    }

    public void setRoster(ArrayList<Shift> roster) {
        roster = roster;
    }

}
