package ShuttleProject.Project1.Controllers;

import ShuttleProject.Project1.DataBases.Passenger;
import ShuttleProject.Project1.Services.ShuttleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShuttleController {

    @Autowired
    private ShuttleServices shuttleServices;
    //Shuttle request to add user as passenger
    //user status should be waiting which means user raised a pickup request
    //passenger will be added based on ETA and seats available in a Shuttle
    @PostMapping(path = "/addPassenger")
    public @ResponseBody String addPassengerWhenPickup(@RequestParam Integer suid, @RequestParam String address){
        return shuttleServices.ADDPASSENGERWHENPICKUP(suid,address);
    }

    //Shuttle request to update it's Location
    @PostMapping(path="/ShuttleLocation")
    public @ResponseBody String addShuttleData(@RequestParam double latitude,@RequestParam double longitude , @RequestParam int shuttleid ){
        return shuttleServices.ADDSHUTTLEDATA(latitude, longitude,shuttleid);
    }

    //returns all the passengers list
    @GetMapping(path="/allpassengers")
    public @ResponseBody List<Passenger> getallpassengers(){
        return shuttleServices.ALLP();
    }
}
