package dk.mth.test.demo.model;

import java.util.ArrayList;

public class Manager extends Person {


    private ArrayList<Shift> roster = new ArrayList<>();

    public Manager(String name, String age, String email, String password,String id, ArrayList<Shift> roster) {
        super(name, age, email, password,id);
        this.roster = roster;
    }

    public ArrayList<Shift> getRoster() {
        return roster;
    }

    public void setRoster(ArrayList<Shift> roster) {
        roster = roster;
    }

}