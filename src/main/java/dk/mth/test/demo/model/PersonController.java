package dk.mth.test.demo.model;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    public static List<Person> personList;

    public PersonController (){
        personList = new ArrayList<>();
    }

    public static Person getPerson (int arraySlot){

        Person person = personList.get(arraySlot);

        return person;
    }

    public void deletePerson(String id){

        for (Person person:personList) {

            if (person.getId().equalsIgnoreCase(id)){
                personList.remove(person);
                break;
            }

        }

    }

    public void createCustomer(String name, String birthdate, String email, String password){

        int genId = 1;
        String id;


        if (personList.size()==0){
            id="1";} else {
            genId = Integer.parseInt( personList.get(personList.size()-1).getId())+1;
            id = ""+genId;

        }

        Customer customer = new Customer(name,birthdate,email,password,id);
        personList.add(customer);


    }

    public List<Customer> getCustomerList (){

        List<Customer> customerList = new ArrayList<>();

        for (Person person:personList) {

            if(person instanceof Customer){ customerList.add((Customer) person); }

        }
        return customerList;
    }

    public void createManager(String name, String birthdate, String email, String password){

        int genId = 1;
        String id;


        if (personList.size()==0){
            id="1";} else {
            genId = Integer.parseInt( personList.get(personList.size()-1).getId())+1;
            id = ""+genId;

        }

        Manager manager = new Manager(name,birthdate,email,password,id);
        personList.add(manager);


    }

    public List<Manager> getManagerList (){

        List<Manager> managerList = new ArrayList<>();

        for (Person person:personList) {

            if(person instanceof Manager){ managerList.add((Manager) person); }

        }
        return managerList;
    }

    public void createActivityManager(String name, String birthdate, String email, String password){

        int genId = 1;
        String id;


        if (personList.size()==0){
            id="1";} else {
            genId = Integer.parseInt( personList.get(personList.size()-1).getId())+1;
            id = ""+genId;

        }

        ActivityManager activityManager= new ActivityManager(name,birthdate,email,password,id);
        personList.add(activityManager);


    }

    public List<Manager> getActivityManagerList (){

        List<Manager> activityManagerList = new ArrayList<>();

        for (Person person:personList) {

            if(person instanceof ActivityManager){ activityManagerList.add((ActivityManager) person); }

        }
        return activityManagerList;
    }


}