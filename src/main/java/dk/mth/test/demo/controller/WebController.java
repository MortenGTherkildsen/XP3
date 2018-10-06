package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.Customer;
import dk.mth.test.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private List<Person> hl;


    public WebController(){
        hl = new ArrayList<>();
    }

    @GetMapping(path = "/")
    public String index(Model model){
        model.addAttribute("personData", hl );
        return "index";
    }

    @GetMapping(path = "/createcustomer")
    public String createcustomer() {

        return "/createcustomer";
    }

    @PostMapping("/createcustomer")
    public String createcustomer(@RequestParam String email, @RequestParam String password, @RequestParam String name, @RequestParam String birthday, Model model) {

        System.out.println(email + " " + password);
        hl.add(new Customer(name,birthday, email,password,"+"));
        return index(model);
    }

    @GetMapping(path = "/aktiviteter")
    public String aktiviteter() {

        return "/aktiviteter";
    }

    @GetMapping(path = "/login")
    public String login() {

        return "/login";
    }

    @GetMapping(path = "/opret")
    public String opret() {

        return "/opret";
    }

    @GetMapping(path = "/reservationer")
    public String reservationer() {

        return "/reservationer";
    }
}