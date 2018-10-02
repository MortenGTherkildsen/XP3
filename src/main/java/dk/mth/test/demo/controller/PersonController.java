package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.Person;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    private List<Person> hl;

    public PersonController(){
        hl = new ArrayList<>();
    }

    public String index(Model model){
        model.addAttribute("personData", hl);
        return "index";
    }

}
