package lobna.hajlaoui.prodcnns.Controller;

import lobna.hajlaoui.prodcnns.DTO.Startup_actDTO;
import lobna.hajlaoui.prodcnns.Entity.Startup_act;
import lobna.hajlaoui.prodcnns.Service.StartupActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StartupActController {
    @Autowired
    StartupActService startup_act_service;
    @GetMapping("/startup_act/{date}")
    public List<Startup_actDTO> findByDate(@PathVariable("date") String date) {
        return startup_act_service.findByDate(date);
    }
    @PostMapping("/store_startup_act")
    public Startup_act addStartupAct(@RequestBody Startup_act st) {
        return  startup_act_service.save_startup_act(st);
    }
}
