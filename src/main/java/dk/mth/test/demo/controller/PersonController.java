package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.Customer;
import dk.mth.test.demo.model.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {

    private List<Person> hl;

    public PersonController(){
        hl = new ArrayList<>();
    }

    @GetMapping(path = "/")
    public String index(Model model){
        model.addAttribute("personData", hl);
        return "index";
    }

    @GetMapping("/createcustomer")
    public String createcustomer(@ModelAttribute Model model) {
        return "createcustomer";
    }

    @PostMapping("/createcustomer")
    public String getcreatecustomer(@ModelAttribute Customer customer) {
        hl.add(customer);
        return "redirect:/index";
    }

}