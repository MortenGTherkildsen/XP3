package dk.mth.test.demo.model;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    public static List<Person> personList;

    public PersonController (){
        personList = new ArrayList<>();
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

    public Person getPerson (int arraySlot){

        Person person = personList.get(arraySlot);

        return person;
    }

}