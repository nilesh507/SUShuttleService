package ShuttleService.Controllers;

import java.util.*;

import ShuttleService.Models.Users;
import ShuttleService.Services.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private ShuttleService s;
    @PostMapping(path = "/sign-in")
    public @ResponseBody String UserEntry (@RequestParam Integer suid,@RequestParam String name,
                                           @RequestParam String email,@RequestParam String address) {
    return s.SignIn(suid,name,email,address);
    }

    @PostMapping(path = "/UserPickUp")
    public @ResponseBody List<String> UserPickUpReq (@RequestParam Integer SUID) {
        return s.UserPickUpRequests(SUID);
    }

    @GetMapping (path = "/Users")
    public @ResponseBody List<Users> Users () {
        return s.Users();
    }

}
