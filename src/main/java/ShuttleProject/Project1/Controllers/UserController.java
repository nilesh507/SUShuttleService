package ShuttleProject.Project1.Controllers;

import ShuttleProject.Project1.Services.ShuttleServices;

import ShuttleProject.Project1.DataBases.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private ShuttleServices shuttleServices;

    //To add users into main database
    @PostMapping(path="/register")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String address, @RequestParam Integer suid,@RequestParam String email) {
        return  shuttleServices.ADDNEWUSER(name, address, suid, email);
    }

    //User request to pickup.
    @PostMapping(path="/requestPickup")
    public @ResponseBody List<String> pickupStudent(@RequestParam Integer suid){
        return shuttleServices.REQUESTPICKUP(suid);
    }

    @GetMapping("/address")
    public @ResponseBody List<User> getUserByAddress(@RequestParam String address){
        return shuttleServices.GETUSERBYADDRESS(address);
    }

    @GetMapping("/name")
    public @ResponseBody List<User> getUserByName(@RequestParam String name){
        return shuttleServices.GETUSERBYNAME(name);
    }

    @GetMapping(path="/all")
    public @ResponseBody List<User> getAllUsers() {
        return shuttleServices.ALL();
    }

    @GetMapping(path="/testing")
    public @ResponseBody List<User> wUser(){
        return shuttleServices.WaitingUsers();
    }
}
