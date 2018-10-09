package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.ActivityController;
import dk.mth.test.demo.model.ActivityLineitemController;
import dk.mth.test.demo.model.Customer;
import dk.mth.test.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private List<Person> hl;

    private ActivityController activityController = new ActivityController();
    private ActivityLineitemController activityLineitemController = new ActivityLineitemController();

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
        if(!email.equals("") && !password.equals("")) {
            hl.add(new Customer(name,birthday, email,password,"+"));
            return index(model);
        }

        return "/createcustomer";
    }

    @GetMapping(path = "/reservation-menu")
    public String reservation_menu() {

        return "/reservation-menu";
    }

    @GetMapping(path = "/reservations")
    public String reservations() {
        if(loginstatus) {
            System.out.println(" DEBUG : " + user.getEmail() + " " + user.getPassword());
            return "/reservations";
        }
        else
        {
        System.out.println(" DEBUG2 : " + user.getEmail() + " " + user.getPassword());
        return "/login";
        }
    }

    @GetMapping(path = "/login")
    public String login() {

        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password) {
        for(int i = 0; i < hl.size(); i++){
            System.out.println(" "+hl.get(i).getEmail());
            if (email.equals(hl.get(i).getEmail()) && !email.equals("")) {
                System.out.println("Email match successfully : " + email);
                if (password.equals(hl.get(i).getPassword()) && !password.equals("")) {
                    System.out.println("password match successfully : " + password);
                    loginstatus = true;
                    System.out.println("User successfully logged in : " + email + " | " + password);
                    return "/reservations";

                /*

                    Koden checker kun på den sidste oprettede USER!
                    Skal man kunne oprette flere reservationer (altså flere logins pr kunde?)
                    Det her skal vi få snakket om og rettet til ;)

                */

                } else {
                    System.out.println("password DO NOT match");
                    if(i==hl.size()-1) {
                        return "/login";
                    }
                }
            }else {
                System.out.println("email DO NOT match");
                if(i==hl.size()-1) {
                    return "/login";
                }
            }
        }

        return "/login";
    }

    @GetMapping(path = "/opret")
    public String opret() {

        return "/opret";
    }

    @GetMapping(path = "/activities")
    public String activities() {

        return "/activities";
    }

    @GetMapping(path = "/gokart")
    public String gokart(Model model) {
        model.addAttribute("activitylineitemliste", ActivityLineitemController.activityLineitemList);

        return "/gokart";
    }

    @GetMapping(path = "/sumo")
    public String sumo() {

        return "/sumo";
    }

    @GetMapping(path = "/paintball")
    public String paintball() {

        return "/paintball";
    }

    @GetMapping(path = "/minigolf")
    public String minigolf() {

        return "/minigolf";
    }

    @GetMapping(path = "/allBookings")
    public String allBookings() {

        return "/allBookings";
    }
}