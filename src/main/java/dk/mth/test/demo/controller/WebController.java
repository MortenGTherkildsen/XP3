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
    private Person user = new Person("","");
    private boolean loginstatus = false;


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
        user.setEmail(email); user.setPassword(password);
        return index(model);
    }

    @GetMapping(path = "/reservationer")
    public String reservationer() {
        if(loginstatus) {
            System.out.println(" DEBUG : " + user.getEmail() + " " + user.getPassword());
            return "/reservationer";
        }
        System.out.println(" DEBUG2 : " + user.getEmail() + " " + user.getPassword());
        return "/login";
    }

    @GetMapping(path = "/login")
    public String login() {

        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password){
        if(email.equals(user.getEmail())&&!email.equals("")){
            System.out.println("Email match successfully : "+email);
            if(password.equals(user.getPassword())&&!password.equals("")){
                System.out.println("password match successfully : "+password);
                loginstatus = true;
                System.out.println("User successfully logged in : "+email+" | "+password);
                return "/reservationer";
            }
            else
            {
                System.out.println("password DO NOT match");
                return "/login";
            }
        }
        else
        {
            System.out.println("email DO NOT match");
            return "/login";
        }
    }

    @GetMapping(path = "/opret")
    public String opret() {

        return "/opret";
    }

    @GetMapping(path = "/aktiviteter")
    public String aktiviteter() {

        return "/aktiviteter";
    }

}