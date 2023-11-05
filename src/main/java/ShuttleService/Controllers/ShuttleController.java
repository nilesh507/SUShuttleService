package ShuttleService.Controllers;

import ShuttleService.Services.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShuttleController {
    @Autowired
    private ShuttleService s;

    @PostMapping(path = "/ShuttleUserEntry")
    public @ResponseBody String ShuttleUserEntry () {
        return s.AddShuttleUser();
    }

    @PostMapping(path = "/ShuttleLocation")
    public @ResponseBody String ShuttleLocation (@RequestParam double Latitude,@RequestParam double Longitude,@RequestParam Integer Shuttleid) {
        return s.ShuttleLocation(Latitude,Longitude,Shuttleid);
    }

}
