package dk.mth.test.demo.controller;

import dk.mth.test.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {

    private List<Person> hl;

    private BookingController bookingController = new BookingController();
    private PersonController personController = new PersonController();
    private ActivityController activityController = new ActivityController();
    private ActivityLineitemController activityLineitemController = new ActivityLineitemController();

    private Booking booking = new Booking(0,0,"",0);
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
        int personID = personController.getNextPersonId();
        if(!email.equals("") && !password.equals("")) {
            hl.add(new Customer(name,birthday, email,password,personID));
            booking.setCustomerId(personID);
            System.out.println("customer: "+booking.getCustomerId()+" | id: "+booking.getId() + " | amount: " + booking.getPeople() + " | price: " + booking.getPrice());
            return index(model);
        }

        return "/createcustomer";
    }

    @GetMapping(path = "/reservation-menu")
    public String reservation_menu() {

        return "/reservation-menu";
    }

    @GetMapping(path = "/reservations")
    public String reservations(Model model) {
        model.addAttribute("bookings", booking );
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
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        for(int i = 0; i < hl.size(); i++){
            System.out.println(" "+hl.get(i).getEmail());
            if (email.equals(hl.get(i).getEmail()) && !email.equals("")) {
                System.out.println("Email match successfully : " + email);
                if (password.equals(hl.get(i).getPassword()) && !password.equals("")) {
                    System.out.println("password match successfully : " + password);
                    loginstatus = true;
                    System.out.println("User successfully logged in : " + email + " | " + password);
                    model.addAttribute("bookings", booking );
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
        Date date1 = new Date();
        Date date2 = new Date();
        date2.setDate(date2.getDate()+2);
        date2.setHours(24);
        date1.setHours(0);
        model.addAttribute("activitylineitemdate", activityLineitemController.getListFromDate("1",date1,date2));

        return "/gokart";
    }

    @RequestMapping(value = "/gokart", method = RequestMethod.POST)
    public String gokart(@RequestParam int people) {
        if(people>0){
            booking.setPeople(people);
            String price = Integer.toString(people*100);
            booking.setPrice(price);
            booking.setId(bookingController.getNextBookingNumber());
            return "/createcustomer";
        }

        return "/index";
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