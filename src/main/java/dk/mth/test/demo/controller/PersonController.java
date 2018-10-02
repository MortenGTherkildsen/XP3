package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.Customer;
import dk.mth.test.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    private List<Person> hl;

    public PersonController(){
        hl = new ArrayList<>();
    }

    @GetMapping(path = "/")
    public String index(Model model){
        model.addAttribute("person", hl);
        return "index";
    }

    @GetMapping(path = "/createcustomer")
    public String createcustomer() {

        return "/createcustomer";
    }

    @PostMapping("/createcustomer")
    public String createcustomer(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {


        hl.add(new Customer(email, password));
        return "redirect:/index";
    }

}