package ShuttleProject.Project1.Services;

import ShuttleProject.Project1.Repositories.PassengersDataRepository;
import ShuttleProject.Project1.Repositories.ShuttleDataRepository;
import ShuttleProject.Project1.Repositories.UserRepository;
import ShuttleProject.Project1.DataBases.ShuttleLocation;
import ShuttleProject.Project1.DataBases.User;
import ShuttleProject.Project1.DataBases.UserStatus;
import ShuttleProject.Project1.DataBases.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.*;


@Service
public class ShuttleServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PassengersDataRepository pdr;
    @Autowired
    private ShuttleDataRepository sdr;

//    Map<String, Integer> Address_Map  = new HashMap<String, Integer>() {{
//        Address_Map.put("BusStop", 100);
//        Address_Map.put("Marshal",95);
//    }};

    //ETAs of two shuttles respectively
    private int ETAS1;
    private int ETAS2;
    //This has valid user information
    public String ADDNEWUSER(String name, String address, Integer suid, String email){
        User n = new User();
        if(suid.toString().length() == 10 ){
            if(userRepository.findBySUID(suid) == null){
                n.setSUID(suid);
                n.setName(name);
                n.setAddress(address);
                System.out.println(email.trim());
                if(email.trim().endsWith("syr.edu")) {
                    if (userRepository.findByEmail(email) == null) {
                        n.setEmail(email);
                    }
                    else{
                        return "email already exists";
                    }
                }
                else {
                    return "please enter valid email";
                }
                n.setUserStatus(UserStatus.IDEL);
                userRepository.save(n);
                return "saved";
            }
            return "SUID already exists";
        }
        return "please enter valid SUID";
    }

    //User should be valid(suid should exist in main DataBase).
    //User should be IDEL.
    //User cannot request for pickup when he/she is already picked up.
    public List<String> REQUESTPICKUP(Integer suid){
        User u=userRepository.findBySUID(suid);
        List<String> l = new ArrayList<>();
        if(u!=null){
            if(u.getUserStatus()==UserStatus.IDEL){
                u.setUserStatus(UserStatus.WAITING);
                userRepository.save(u);
                //ETAs will be calculated and assigned to ETAS1 and ETAS2 here.
                // CHANGES TO BE MADE
                // etas can be calculated of the minimum of the shuttles available if we are taking n number of shuttles
                ETAS1 = 60;
                ETAS2 = 120;
                l.add("Your ETA for Shuttle-1 is one hour");
                l.add("Your ETA for Shuttle-2 is two hours");
                return l;
            } else if (u.getUserStatus()==UserStatus.PICKEDUP) {
                l.add("Your are already in your ride, hence you cannot request another ride");
                return l;
            } else if (u.getUserStatus()==UserStatus.WAITING) {
                l.add("Your ETA for Shuttle-1 is one hour");
                l.add("Your ETA for Shuttle-2 is two hours");
                return l;
            }
        }
        l.add("SUID not in DataBase");
        return l;
    }



    public String ADDPASSENGERWHENPICKUP(Integer suid, String address){
        User us = userRepository.findBySUID(suid);

        // CHANGES TO BE MADE
        // Generalize the number of shuttles going in a round picking and dropping the students
        ShuttleLocation s1 = sdr.getReferenceById(1);
        ShuttleLocation s2 = sdr.getReferenceById(2);
        Passenger p = new Passenger();
        if (us!=null){
            if (us.getUserStatus() == UserStatus.WAITING) {
                p.setSuid(suid);
                p.setAddress(address);
                // User will become passenger of Shuttle1 or Shuttle2.
                // Criteria -> based on ETA and seats available in Shuttles.
                if (ETAS1 <= ETAS2) {
                    if (s1.getSeats() == null || s1.getSeats() <= 25) {
                        s1.setSeats(s1.getSeats() - 1);
                        p.setShuttleid(s1.getSid());
                        us.setUserStatus(UserStatus.PICKEDUP);
                        pdr.save(p);
                        userRepository.save(us);
                        return "Passenger added to Shuttle1";
                    } else if (s2.getSeats() == null || s2.getSeats() <= 25) {
                        s2.setSeats(s2.getSeats() - 1);
                        p.setShuttleid(s2.getSid());
                        us.setUserStatus(UserStatus.PICKEDUP);
                        pdr.save(p);
                        userRepository.save(us);
                        return "Passenger added to Shuttle2";
                    } else {
                        return "no seats available in both the shuttles";
                    }
                } else if (ETAS1 > ETAS2) {
                    if (s2.getSeats() == null || s2.getSeats() <= 25) {
                        s2.setSeats(s2.getSeats() - 1);
                        p.setShuttleid(2);
                        us.setUserStatus(UserStatus.PICKEDUP);
                        pdr.save(p);
                        userRepository.save(us);
                        return "Passenger added to Shuttle2";
                    } else if (s1.getSeats() == null || s1.getSeats() <= 25) {
                        s1.setSeats(s1.getSeats() - 1);
                        p.setShuttleid(1);
                        us.setUserStatus(UserStatus.PICKEDUP);
                        pdr.save(p);
                        userRepository.save(us);
                        return "Passenger added to Shuttle1";
                    } else {
                        return "no seats available in both the shuttles";
                    }
                }
            } else {
                return "User hasn't raised an request to PICK-UP";
            }
        }
        return "Service Unavailable"; // user not in database register the user first
    }

    //setting up the location of the shuttle
    public String ADDSHUTTLEDATA(double latitude,double longitude,int shuttleid){
        ShuttleLocation s;
        //
        if (shuttleid==1){
            s=sdr.getReferenceById(1);
            s.setLatitude(latitude);
            s.setLongitude(longitude);
            sdr.save(s);
            return "Shuttle-1 Location has been updated";
        }
        else if(shuttleid==2){
            s=sdr.getReferenceById(2);
            s.setLatitude(latitude);
            s.setLongitude(longitude);
            sdr.save(s);
            return "Shuttle-2 Location has been updated";
        }
        else {
            return "invalid shuttle ID";
        }
    }

    // return the list of all the users that are waiting for the ride
    public List<User> WaitingUsers(){
        List<User> waitingUser = userRepository.findByUserStatus(UserStatus.WAITING);
        return waitingUser;
    }

    public List<User> GETUSERBYADDRESS(String address){
        return userRepository.findUserByAddress(address);
    }

    public List<User> GETUSERBYNAME(String name){
        return userRepository.findUserByName(name);
    }

    public List<User> ALL(){
        return userRepository.findAll();
    }

    public List<Passenger> ALLP(){
        return pdr.findAll();
    }
}
